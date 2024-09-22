package hu.otpmobile.ticketing.ticket.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

  private Long reservationId;
  private boolean success;

}
