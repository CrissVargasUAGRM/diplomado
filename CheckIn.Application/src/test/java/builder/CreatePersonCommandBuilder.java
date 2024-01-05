package builder;

import com.nur.command.person.create.CreatePersonCommand;

public class CreatePersonCommandBuilder {
  public CreatePersonCommand build() {
    return new CreatePersonCommand(new PersonDTOBuilder().build());
  }
}
