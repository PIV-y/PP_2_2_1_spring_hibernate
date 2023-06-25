package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      Car car1 = new Car("Toy", 1);
      Car car2 = new Car("Vol", 2);
      Car car3 = new Car("Wol", 3);
      Car car4 = new Car("Rang", 4);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",  car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      userService.add(car1);
      userService.add(car2);
      userService.add(car3);
      userService.add(car4);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru",  new Car("Toy", 1)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Vol", 2)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Wol", 3)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Rang", 4)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car type = "+user.getCar().toString());
         System.out.println();
      }
      context.close();
   }
}
