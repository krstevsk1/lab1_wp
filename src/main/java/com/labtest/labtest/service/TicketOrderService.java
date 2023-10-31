package com.labtest.labtest.service;

import com.labtest.labtest.model.TicketOrder;
import org.springframework.stereotype.Service;

@Service
public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}
