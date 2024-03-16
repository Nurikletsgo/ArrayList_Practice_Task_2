import model.GenerateId;
import model.Post;
import service.serviceImpl.PostServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PostServiceImpl postService = new PostServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        while (true) {
            try {
                System.out.println("""
                        1. register
                        2. login
                        3. get user by email
                        4. get all users
                        5. exit""");
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        System.out.println(userService.register());
                        break;
                    case 2:
                        System.out.println("write user email ");
                        String email = new Scanner(System.in).nextLine();
                        System.out.println("write password");
                        String password = new Scanner(System.in).nextLine();
                        System.err.println(userService.login(email, password));
                        break;
                    case 3:
                        System.out.println("write email ");
                        System.out.println(userService.getUserByEmail(new Scanner(System.in).nextLine()));
                        break;
                    case 4:
                        System.out.println(userService.getAllUsers());
                    case 5 :
                        System.out.println(" THANK YOU");
                        return;
                    default:
                        System.err.println("choose only 1-2-3-4-5");

                }
            } catch (Exception e) {
                System.err.println(" write again (Exception)");
            }


        }
    }
}