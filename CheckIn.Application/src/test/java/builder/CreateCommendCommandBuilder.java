package builder;

import com.nur.command.commend.create.CreateCommendCommand;

public class CreateCommendCommandBuilder {
  public CreateCommendCommand build() {
    return new CreateCommendCommand(new CommendDTOBuilder().build());
  }
}
