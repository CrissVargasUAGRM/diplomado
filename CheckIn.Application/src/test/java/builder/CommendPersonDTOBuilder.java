package builder;

import com.nur.dtos.CommendPersonDTO;
import java.util.UUID;

public class CommendPersonDTOBuilder {
  public CommendPersonDTO build() {
    return new CommendPersonDTO(
        String.valueOf(UUID.randomUUID()),
        String.valueOf(UUID.randomUUID()),
        "Bueno",
        "Lo que sea",
        "Cristhian",
        3);
  }
}
