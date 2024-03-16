package model;

import enums.Gender;
import exception.MyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User {
    private Long ID;
    private String fullName;
    private String email;
    private String password;
    private Gender gender;
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(Long ID, String fullName, String email, String password, Gender gender, List<Post> posts) {
        this.ID = ID;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.posts = posts;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        boolean choose = true;
        System.out.println("write user fullName");
        while (choose) {
            try {
                String name =  new Scanner(System.in).nextLine();

                if (name.matches(".*\\d.*")) {
                    throw new MyException("адамдын аты тамгалар менен жазылат");
                }
                this.fullName = name;
                choose = false;
            }catch(MyException e ){
                System.err.println(e.getMessage());
            }
            catch (Exception e) {
                System.err.println("write letter");
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        boolean choose = true;
        System.out.println("write user email");
        while (choose) {
            String word = new Scanner(System.in).nextLine();
            if (word.contains("@gmail.com") && !word.equals(getEmail())) {
                this.email = word;
                choose = false;
            } else if (!word.contains("@gmail.com")) {
                System.err.println(word + " must contain '@.gmail.com'");
                System.out.println(" write again ");
            } else {
                System.err.println(" this email already exist ! ");
                System.out.println(" write again");
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        boolean choose = true;
        System.out.println("write user password");
        while (choose) {
            String word = new Scanner(System.in).nextLine();
            if (word.length() > 7) {
                this.password = word;
                choose = false;
            } else {
                System.err.println(" password length must more than 8 ");
                System.out.println(" write again");
            }

        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender() {
        boolean choose = true;
        System.out.println("Choose gender \n"+ Arrays.toString(Gender.values()));
        while (choose) {
            try {
                this.gender = Gender.valueOf(new Scanner(System.in).nextLine());
                choose = false;
            } catch (Exception e) {
                System.err.println("write gender");
            }
        }
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User  " +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", posts=" + posts +
                '}';
    }
}
