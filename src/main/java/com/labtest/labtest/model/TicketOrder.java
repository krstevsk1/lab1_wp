package com.labtest.labtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOrder {
    private String movieTitle;
    private String clientName;
    private String clientAddress;
    private Long numberOfTickets;
}
