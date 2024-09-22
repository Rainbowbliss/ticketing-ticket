package hu.otpmobile.ticketing.ticket.web.dto;

import lombok.Data;
import java.util.List;

@Data
public class EventsResponse {

  private List<EventResponse> data;
  private boolean success;
}
