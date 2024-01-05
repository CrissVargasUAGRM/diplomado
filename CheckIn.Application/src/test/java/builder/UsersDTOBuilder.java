package builder;

import com.nur.dtos.UsersDTO;
import java.util.UUID;

public class UsersDTOBuilder {
  public UsersDTO build() {
    return new UsersDTO(
        String.valueOf(UUID.randomUUID()),
        "Criss",
        "cristhian@gmail.com",
        "123456",
        "Huesped",
        String.valueOf(UUID.randomUUID()));
  }
}
