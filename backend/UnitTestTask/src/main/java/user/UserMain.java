package user;

import java.util.Scanner;

public class UserMain {
    public static void main(String[] args) throws NotValidMailException {
        /**
         1 - Login
         2 - Signup
         3 - close system
         */
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("\n"+
                            "1 - Login\n" +
                            "2 - Signup\n"+
                            "3 - close system");
            System.out.print("enter your choice: ");
            String choice = sc.next();
            if(choice.equals("1")){
                System.out.print("enter your email: ");
                String email = sc.next();
                System.out.print("enter your password: ");
                String password = sc.next();

                try {
                    boolean loggedIn = UserServer.login(email,password);
                    if (loggedIn){break;}
                    else {
                        System.out.println("try again");
                    }
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println();
                    System.out.println("try again");
                }
            }
            else if(choice.equals("2")){
                System.out.print("enter your name: ");
                String name = sc.next();
                System.out.print("enter your email: ");
                String email = sc.next();
                System.out.print("enter your password: ");
                String password = sc.next();

                try {
                    int lenBeforeSignUp = UserServer.users.size();
                    UserServer.signUp(name, email, password);
                    if (lenBeforeSignUp < UserServer.users.size()){
                        break;
                    }else{
                        System.out.println();
                        System.out.println("please try again with different email or login ");

                    }

                }catch (Exception e){
                    System.out.println();
                    System.out.println(e);
                    System.out.println("please try again");
                }
            }
            else if(choice.equals("3")) {
                System.out.println("thank you ! Bye");
                break;
            }
            else{
                System.out.println("\nplease choose valid option");
            }
        }
    }
}
