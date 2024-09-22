package hu.otpmobile.ticketing.ticket.client.core;

import hu.otpmobile.ticketing.ticket.client.core.dto.UserDetailsResponse;
import hu.otpmobile.ticketing.ticket.client.core.dto.UserPaymentRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CoreClient {

  private static final String BASE_URL = "/api/v1/users";

  @Value("${app.urls.core}")
  private String coreUrl;

  private final RestClient restClient = RestClient.create();

  public UserDetailsResponse getUserDetails(Long userId) {
    return restClient
        .get()
        .uri(coreUrl + BASE_URL + "/" + userId)
        .retrieve()
        .body(UserDetailsResponse.class);
  }

  public void paySeatPrice(UserPaymentRequest userPaymentRequest) {
    restClient
        .put()
        .uri(coreUrl + BASE_URL + "/pay")
        .contentType(MediaType.APPLICATION_JSON)
        .body(userPaymentRequest)
        .retrieve()
        .toBodilessEntity();
  }
}
