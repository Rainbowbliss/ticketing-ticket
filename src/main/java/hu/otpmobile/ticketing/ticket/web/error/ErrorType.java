package hu.otpmobile.ticketing.ticket.web.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

  WRONG_BANK_CARD_ID("10100", "Ez a bankkártya nem ehhez a felhasználóhoz tartozik!",
      HttpStatus.INTERNAL_SERVER_ERROR),
  SEAT_DOES_NOT_EXISTS("20002", " Nem létezik ilyen szék!", HttpStatus.BAD_REQUEST),
  RESERVED_SEAT("20002", "Már lefoglalt székre nem lehet jegyet eladni!", HttpStatus.BAD_REQUEST),
  NOT_ENOUGH_MONEY("10101", "A felhasználónak nincs elegendő pénze hogy megvásárolja a jegyet!",
      HttpStatus.BAD_REQUEST);


  private final String code;
  private final String message;
  private final HttpStatus httpStatus;

  ErrorType(String code, String message, HttpStatus httpStatus) {
    this.code = code;
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
