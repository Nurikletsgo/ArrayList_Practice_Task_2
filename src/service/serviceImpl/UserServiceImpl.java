package service.serviceImpl;

import enums.Gender;
import model.DataBase;
import model.GenerateId;
import model.Post;
import model.User;
import service.PostService;
import service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    @Override
    public String register() {
        User user = new User();
        user.setID(GenerateId.generateUserId());
        user.setFullName();
        user.setEmail();
        user.setPassword();
        user.setGender();
        DataBase.users.add(user);
        return "User " + user.getFullName() + " successfully added ";
    }

    @Override
    public String login(String email, String password) {
        PostServiceImpl postService = new PostServiceImpl();
        for (User user : DataBase.users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                System.out.println("    ~~~~~~~~~ WELCOME TO ACCOUNT ~~~~~~~~~~");
                while (true) {
                    System.out.println("""
                            1. add post
                            2. delete post by id
                            3. get all post user by id
                            4. exit""");
                    try {
                        switch (new Scanner(System.in).nextInt()) {
                            case 1:
                                Post post = new Post();
                                post.setID(GenerateId.generatePostId());
                                System.out.println("write imageIrl");
                                post.setImageIrl(new Scanner(System.in).nextLine());
                                System.out.println("write description");
                                post.setDirection(new Scanner(System.in).nextLine());
                                user.getPosts().add(postService.addPostToUser(post));
                                break;
                            case 2:
                                System.out.println("write post Id");
                                user.getPosts().remove(postService.deletePostById(new Scanner(System.in).nextLong()));
                                break;
                            case 3:
                                System.out.println("write user id");
                                System.out.println(postService.getAllPostByUserId(new Scanner(System.in).nextLong()));
                                break;
                            case 4:
                                return " good bye";

                            default:
                                System.err.println("choose only 1-2-3-4");
                        }

                    } catch (Exception e) {
                        System.err.println(" write again (Exception)");
                    }
                }
            }
        }

        return "wrong email or password";
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : DataBase.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return DataBase.users;
    }
}
