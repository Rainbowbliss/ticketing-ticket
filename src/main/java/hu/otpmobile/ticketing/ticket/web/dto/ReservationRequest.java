package hu.otpmobile.ticketing.ticket.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

  private Long eventId;
  private String seatId;
  private String cardId;
  private Long userId;
  private BigDecimal cardBalance;
}
