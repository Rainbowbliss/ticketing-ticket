package hu.otpmobile.ticketing.ticket.client.core.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class UserDetailsResponse {

  private Long userId;
  private String cardId;
  private BigDecimal cardBalance;

}
