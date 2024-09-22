package hu.otpmobile.ticketing.ticket.client.partner;

import hu.otpmobile.ticketing.ticket.client.partner.dto.PartnerReservationRequest;
import hu.otpmobile.ticketing.ticket.client.partner.dto.PartnerReservationResponse;
import hu.otpmobile.ticketing.ticket.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.EventsResponse;
import org.springframework.stereotype.Component;

@Component
public class PartnerClient {


  public EventsResponse getEvents() {
    return null;
  }

  public EventDetailsResponse getEvent(Long id) {
    return null;
  }

  public PartnerReservationResponse reserveSeat(
      PartnerReservationRequest partnerReservationRequest) {
    return null;
  }
}
