package com.dmql.tms.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.dmql.tms.pojo.*;
import com.dmql.tms.repository.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class TicketDataController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommunicationRepository communicationRepository;

    @PostMapping("/category/upload")
    public String uploadCategories(@RequestParam("file")MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<TicketCategories> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(TicketCategories.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<TicketCategories> categories
                    = csvToBean.parse();
            categoryRepository.saveAll(categories);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "SUCCESS";
    }

    @PostMapping("/ticket/upload")
    public String uploadTickets(@RequestParam("file")MultipartFile file) throws IOException {
        String message = "Thank you for reaching out to us. We hope your issue: %s is resolved!!";
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<Ticket> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Ticket.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Ticket> tickets
                    = csvToBean.parse();

            List<TicketCategories> ticketCategoriesList = categoryRepository.findAll();
            List<TicketStatus> statusList = statusRepository.findAll();
            List<Users> usersList = userRepository.findAll();


            Map<String, Integer> categoryMap = new HashMap<>();
            for(TicketCategories ticketCategory: ticketCategoriesList) {
                categoryMap.put(ticketCategory.getCategoryName(), ticketCategory.getId());
            }

            Map<String, Integer> statusMap = new HashMap<>();
            for(TicketStatus status: statusList) {
                statusMap.put(status.getStatus(), status.getId());
            }

            Map<Integer, Users> usersMap = new HashMap<>();
            for(Users user: usersList) {
                usersMap.put(user.getId(), user);
            }


            List<Communication> communications = new ArrayList<>();
            for(Ticket ticket: tickets) {
                Random rnd = new Random();
                int ticketId = rnd.nextInt(99999999);
                ticket.setTicketId(ticketId);
                ticket.setTicketCategory(categoryMap.get(ticket.getCategory_name()));
                ticket.setTicketStatus(statusMap.get(ticket.getStatus_name()));
                ticket.setUpdated_at(LocalDateTime.now());
                ticket.setCreated_at(LocalDateTime.now());
                ticket.setCreated_by_id(ticket.getTicketId()%100);
                ticket.setAgent_id((ticket.getTicketId())%100 + 100);
                if(ticket.getTicketStatus()>0) {
                    Communication communication = new Communication();
                    communication.setTicket_id(ticketId);
                    if(ticketId%2==0)
                        communication.setType("EMAIL");
                    else
                        communication.setType("SMS");
                    Users user = usersMap.get(ticket.getCreated_by_id());
                    communication.setEmail(user.getEmail());
                    communication.setPhone_number(user.getPhoneNumber());
                    communication.setMessage(String.format(message, ticket.getTicket_description()));
                    communications.add(communication);
                }
            }

            ticketRepository.saveAll(tickets);
            communicationRepository.saveAll(communications);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "SUCCESS";
    }
}
