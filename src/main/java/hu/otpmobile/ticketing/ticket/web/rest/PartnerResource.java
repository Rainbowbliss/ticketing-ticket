package hu.otpmobile.ticketing.ticket.web.rest;

import hu.otpmobile.ticketing.ticket.service.PartnerService;
import hu.otpmobile.ticketing.ticket.web.dto.EventDetailsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.EventsResponse;
import hu.otpmobile.ticketing.ticket.web.dto.ReservationRequest;
import hu.otpmobile.ticketing.ticket.web.dto.ReservationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class PartnerResource {

  private final PartnerService partnerService;

  @GetMapping
  private EventsResponse getEvents() {
    return partnerService.getEvents();
  }

  @GetMapping("/{id}")
  private EventDetailsResponse getEvent(@PathVariable Long id) {
    return partnerService.getEvent(id);
  }

  @PostMapping("/reserve")
  private ReservationResponse reserveSeat(
      @RequestBody @Valid ReservationRequest reservationRequest) {
    return partnerService.reserveSeat(reservationRequest);
  }

}
