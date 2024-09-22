package hu.otpmobile.ticketing.ticket.service;

import hu.otpmobile.ticketing.ticket.client.core.CoreClient;
import hu.otpmobile.ticketing.ticket.client.core.dto.UserPaymentRequest;
import hu.otpmobile.ticketing.ticket.client.partner.PartnerClient;
import hu.otpmobile.ticketing.ticket.client.partner.dto.PartnerReservationRequest;
import hu.otpmobile.ticketing.ticket.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.EventsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.ReservationRequest;
import hu.otpmobile.ticketing.ticket.web.dto.ReservationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerService {

  private final PartnerClient partnerClient;
  private final CoreClient coreClient;

  public EventsResponse getEvents() {
    return partnerClient.getEvents();
  }

  public EventDetailsResponse getEvent(Long id) {
    return partnerClient.getEvent(id);
  }

  public ReservationResponse reserveSeat(ReservationRequest reservationRequest) {
    var eventDetails = getEvent(reservationRequest.getEventId());
    var userDetails = coreClient.getUserDetails(reservationRequest.getUserId());

    if (!reservationRequest.getCardId().equals(userDetails.getCardId())) {
      log.error("Ez a bankkártya nem ehhez a felhasználóhoz tartozik");
      throw new RuntimeException();
    }

    var seatOptional = eventDetails.getData().getSeats().stream()
        .filter(seatResponse -> seatResponse.getId().equals(reservationRequest.getSeatId()))
        .findFirst();

    if (seatOptional.isEmpty()) {
      log.error("Nem létezik ilyen szék!");
      throw new RuntimeException();
    }

    var seat = seatOptional.get();

    if (seat.isReserved()) {
      log.error("Már lefoglalt székre nem lehet jegyet eladni!");
      throw new RuntimeException();
    }

    if (userDetails.getCardBalance().compareTo(seat.getPrice()) < 0) {
      log.error("A felhasználónak nincs elegendő pénze hogy megvásárolja a jegyet!");
      throw new RuntimeException();
    }

    var response = partnerClient.reserveSeat(
        new PartnerReservationRequest(reservationRequest.getEventId(),
            reservationRequest.getSeatId()));

    if (response.isSuccess()) {
      coreClient.paySeatPrice(
          new UserPaymentRequest(reservationRequest.getUserId(), reservationRequest.getCardId(),
              seat.getPrice()));
    }

    return response;
  }
}
