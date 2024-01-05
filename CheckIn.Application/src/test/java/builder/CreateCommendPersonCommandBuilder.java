package builder;

import com.nur.command.commend.create.CreateCommendPersonCommand;

public class CreateCommendPersonCommandBuilder {
  public CreateCommendPersonCommand build() {
    return new CreateCommendPersonCommand(new CommendPersonDTOBuilder().build());
  }
}
