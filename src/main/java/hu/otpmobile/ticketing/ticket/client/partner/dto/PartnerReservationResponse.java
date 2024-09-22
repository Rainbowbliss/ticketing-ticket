package hu.otpmobile.ticketing.ticket.client.partner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerReservationResponse {

  private Long reservationId;
  private boolean success;

}
