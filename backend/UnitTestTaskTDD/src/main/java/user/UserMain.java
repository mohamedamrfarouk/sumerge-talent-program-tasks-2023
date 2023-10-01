package user;

import java.util.List;
import java.util.Scanner;

public class UserMain {
    public static void afterLogin(User loggedInUser){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(
                            "1 - list all user accounts \n" +
                            "2 - open new account \n"+
                            "3 - deposit money in one of your accounts \n"+
                            "4 - withdraw money from account \n"+
                            "else - log out and get to previous choices\n");

            System.out.print("enter your choice: ");

            String choice = sc.next();

            if(choice.equals("1")){
                List<Account> loggedInUserAccounts = UserServer.getAllUserAccounts(loggedInUser);
                loggedInUserAccounts.forEach(a->
                        System.out.println("account id:"+a.getId()+"\n"+
                                "account balance:"+a.getBalance()+"\n"+
                                "account type:"+a.getType()+"\n")
                );

            }
            else if (choice.equals("2")) {
                System.out.print("enter account id: ");
                int accountId = sc.nextInt();
                System.out.print("enter account type if current enter 1 of saving enter 2: ");
                int accountType = sc.nextInt();
                System.out.print("enter account balance: ");
                double accountBalance = sc.nextDouble();

                UserServer.openNewAccount(loggedInUser, accountId, accountType, accountBalance);
            }
            else if(choice.equals("3")){
                System.out.print("enter account id: ");
                int accountId = sc.nextInt();
                System.out.print("enter deposit amount: ");
                double depositAmount = sc.nextDouble();
                UserServer.deposit(loggedInUser, accountId, depositAmount);
            }
            else if(choice.equals("4")){
                System.out.print("enter account id: ");
                int accountId = sc.nextInt();
                System.out.print("enter withdraw amount: ");
                double withdrawAmount = sc.nextDouble();
                UserServer.withdraw(loggedInUser, accountId, withdrawAmount);
            }
            else{
                break;
            }
        }
    }



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
                    User loggedInUser = UserServer.login(email,password);
                    if (loggedInUser.isLogedin()){
                        afterLogin(loggedInUser);
                    }


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
