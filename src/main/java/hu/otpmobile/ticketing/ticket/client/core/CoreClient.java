package hu.otpmobile.ticketing.ticket.client.core;

import hu.otpmobile.ticketing.ticket.client.core.dto.UserDetailsResponse;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class CoreClient {
  public UserDetailsResponse getUserDetails(Long userId) {
    return null;
  }

  public void deductSeatPrice(Long userId, String cardId, BigDecimal price) {

  }
}
