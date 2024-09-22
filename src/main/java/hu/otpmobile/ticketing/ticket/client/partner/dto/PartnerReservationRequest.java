package hu.otpmobile.ticketing.ticket.client.partner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerReservationRequest {

  private Long eventId;
  private String seatId;
}
