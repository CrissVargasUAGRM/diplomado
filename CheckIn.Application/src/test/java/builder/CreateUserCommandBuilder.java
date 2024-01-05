package builder;

import com.nur.command.users.create.CreateUserCommand;

public class CreateUserCommandBuilder {
  public CreateUserCommand build() {
    return new CreateUserCommand(new UsersDTOBuilder().build());
  }
}
