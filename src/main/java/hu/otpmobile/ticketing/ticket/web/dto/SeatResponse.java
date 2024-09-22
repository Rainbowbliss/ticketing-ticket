package hu.otpmobile.ticketing.ticket.web.dto;

import hu.otpmobile.ticketing.ticket.enumeration.Currency;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class SeatResponse {

  private String id;
  private BigDecimal price;
  private Currency currency;
  private boolean reserved;
}
