package builder;

import com.nur.dtos.CommendDTO;
import java.util.UUID;

public class CommendDTOBuilder {
  public CommendDTO build() {
    return new CommendDTO(
        String.valueOf(UUID.randomUUID()),
        String.valueOf(UUID.randomUUID()),
        "Bueno",
        "Lo que sea",
        "Condominio",
        3);
  }
}
