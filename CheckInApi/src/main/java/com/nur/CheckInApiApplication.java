package com.nur;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.nur.annotations.Generated;
import com.nur.repositories.ICommendPersonRepository;
import com.nur.repositories.ICommendRepository;
import com.nur.repositories.IPersonRepository;
import com.nur.repositories.IUserRepository;
import com.nur.repositories.commend.CommendCrudRepositoryImpl;
import com.nur.repositories.commend.CommendPersonCrudRepositoryImpl;
import com.nur.repositories.persons.PersonsCrudRepositoryImpl;
import com.nur.repositories.users.UserCrudRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.Arrays;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
		scanBasePackages = {"con.nur.controllers"}
)
@ComponentScan(
    basePackages = {
      "controllers",
      "com.nur.repositories",
      "com.nur",
      "event",
      "core",
    })
@EntityScan("com.nur.model")
@EnableJpaRepositories(basePackages = {"com.nur.repositories"})
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "NurBnB microservices", version = "1.0.0"))
@Generated
public class CheckInApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(CheckInApiApplication.class, args);
  }

  @Bean(name = "personsRepository")
  public IPersonRepository personsRepository() {
    return new PersonsCrudRepositoryImpl();
  }

  @Bean(name = "usersRepository")
  public IUserRepository usersRepository() {
    return new UserCrudRepositoryImpl();
  }

  @Bean(name = "commendRepository")
  public ICommendRepository commendRepository(){
    return new CommendCrudRepositoryImpl();
  }

  @Bean(name = "commendPersonRepository")
  public ICommendPersonRepository commendPersonRepository() { return new CommendPersonCrudRepositoryImpl(); }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }

  @Bean
  Pipeline pipeline(
      ObjectProvider<Command.Handler> commandHandlers,
      ObjectProvider<Notification.Handler> notificationHandlers,
      ObjectProvider<Command.Middleware> middlewares) {
    return new Pipelinr()
        .with(commandHandlers::stream)
        .with(notificationHandlers::stream)
        .with(middlewares::orderedStream);
  }

}
