package hu.otpmobile.ticketing.ticket.web.dto;

import lombok.Data;

@Data
public class EventDetailsResponse {

  private EventSeatsResponse data;
  private boolean success;
}
