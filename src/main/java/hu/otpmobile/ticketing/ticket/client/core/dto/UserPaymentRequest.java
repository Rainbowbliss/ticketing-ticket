package hu.otpmobile.ticketing.ticket.client.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentRequest {

  Long userId;
  String cardId;
  BigDecimal price;
}
