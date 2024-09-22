package hu.otpmobile.ticketing.ticket.web.dto;

import lombok.Data;

@Data
public class ReservationRequest {

  private Long eventId;
  private String seatId;
  private String cardId;
  private Long userId;
}
