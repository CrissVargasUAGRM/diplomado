package builder;

import com.nur.dtos.PersonDTO;
import java.util.UUID;

public class PersonDTOBuilder {
  public PersonDTO build() {
    return new PersonDTO(String.valueOf(UUID.randomUUID()), "Cristhian", "Vargas", "1234567");
  }
}
