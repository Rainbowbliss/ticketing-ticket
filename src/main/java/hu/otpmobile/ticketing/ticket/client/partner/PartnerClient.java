package hu.otpmobile.ticketing.ticket.client.partner;

import hu.otpmobile.ticketing.ticket.client.partner.dto.PartnerReservationRequest;
import hu.otpmobile.ticketing.ticket.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.EventsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.ReservationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PartnerClient {

  private static final String BASE_URL = "/api/v1/events";

  @Value("${app.urls.partner}")
  private String partnerUrl;

  private final RestClient restClient = RestClient.create();

  public EventsResponse getEvents() {
    return restClient
        .get()
        .uri(partnerUrl + BASE_URL)
        .retrieve()
        .body(EventsResponse.class);
  }

  public EventDetailsResponse getEvent(Long id) {
    return restClient
        .get()
        .uri(partnerUrl + BASE_URL + "/" + id)
        .retrieve()
        .body(EventDetailsResponse.class);
  }

  public ReservationResponse reserveSeat(
      PartnerReservationRequest partnerReservationRequest) {
    return restClient
        .post()
        .uri(partnerUrl + BASE_URL + "/reserve")
        .contentType(MediaType.APPLICATION_JSON)
        .body(partnerReservationRequest)
        .retrieve()
        .body(ReservationResponse.class);
  }
}
