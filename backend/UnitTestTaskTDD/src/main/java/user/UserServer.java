package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServer {
    static List<User> users = new ArrayList<>(Arrays.asList(
            new User("mohamed","mohamed@gmail.com","mohamed123123",
                new ArrayList<>(Arrays.asList(
                    new Account(1,0,1000, "mohamed@gmail.com"),
                    new Account(2,0,2000.0, "mohamed@gmail.com"),
                    new Account(3,1,3000.0, "mohamed@gmail.com"),
                    new Account(4,1,4000.0, "mohamed@gmail.com")
                ))
            ),
            new User("ahmed","ahmed@gmail.com","ahmed123123",
                new ArrayList<>(Arrays.asList(
                    new Account(5,0,1000.0, "ahmed@gmail.com"),
                    new Account(6,0,2000.0, "ahmed@gmail.com"),
                    new Account(7,1,3000.0, "ahmed@gmail.com"),
                    new Account(8,1,4000.0, "ahmed@gmail.com")
                ))
            ),
            new User("mostafa","mostafa@gmail.com","mostafa123123",
                new ArrayList<>(Arrays.asList(
                    new Account(9,0,1000.0, "mostafa@gmail.com"),
                    new Account(10,0,2000.0, "mostafa@gmail.com"),
                    new Account(11,1,3000.0, "mostafa@gmail.com"),
                    new Account(12,1,4000.0, "mostafa@gmail.com")
                ))
            ),
            new User("mahmoud","mahmoud@gmail.com","mahmoud123123",
                new ArrayList<>(Arrays.asList(
                    new Account(13,0,0.0, "mahmoud@gmail.com"),
                    new Account(14,0,0.0, "mahmoud@gmail.com"),
                    new Account(15,1,0.0, "mahmoud@gmail.com"),
                    new Account(16,1,0.0, "mahmoud@gmail.com")
                ))
            ),
            new User("taha","taha@gmail.com","taha123123",
                new ArrayList<>(Arrays.asList(
                    new Account(17,0,0.0, "taha@gmail.com"),
                    new Account(18,0,0.0, "taha@gmail.com"),
                    new Account(19,1,0.0, "taha@gmail.com"),
                    new Account(20,1,0.0, "taha@gmail.com")
                ))
            ),
            new User("abdelrahman","abdelrahman@gmail.com","abdelrahman123123",
                new ArrayList<>(Arrays.asList(
                    new Account(21,0,0.0, "abdelrahman@gmail.com"),
                    new Account(22,0,0.0, "abdelrahman@gmail.com"),
                    new Account(23,1,0.0, "abdelrahman@gmail.com"),
                    new Account(24,1,0.0, "abdelrahman@gmail.com")
                ))
            ),
            new User("Abdullah","Abdolallah@gmail.com","Abdullah123123",
                new ArrayList<>(Arrays.asList(
                    new Account(25,0,0.0, "Abdolallah@gmail.com"),
                    new Account(26,0,0.0, "Abdolallah@gmail.com"),
                    new Account(27,1,0.0, "Abdolallah@gmail.com"),
                    new Account(28,1,0.0, "Abdolallah@gmail.com")
                ))
            )
    ));


    public static List<User> getAllUsers(){
        return  users;
    }


    public static List<User> signUp(String name, String email, String password) throws NotValidMailException {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean validEmail = email.matches(regex);
        if(validEmail){
            boolean emailExist = users.stream().anyMatch(u->u.getEmail().equals(email));
            if(!emailExist){
                users.add( new User( name, email, password, null));
                System.out.println(name + ", signup successfully");
            }else{
                System.out.println("there is a user with the same email");
            }
        }else {
            System.out.println("please enter a valid email, this can't be an email");
            throw new NotValidMailException("please enter a valid email, this can't be an email");
        }
        return users;
    }


    public static User login(String email, String password) throws NotValidMailException {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean validEmail = email.matches(regex);
        if(validEmail){
            if(password.length()>5) {
                User userLogged = users.stream().
                        filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).
                        findFirst().orElse(null);

                if (userLogged != null) {
                    userLogged.setLogedin(true);
                    System.out.println(userLogged.getName() + ", logged in successfully");
                    return userLogged;
                } else {
                    System.out.println("Invalid email and password");
                }
            }else {
                System.out.println("please enter a valid password, password length should be longer than 5");
            }
        }else {
            System.out.println("please enter a valid email, this can't be an email");
            throw new NotValidMailException("please enter a valid email, this can't be an email");
        }
        return null;

    }
    public static List<Account> getAllUserAccounts(User myUser){
        return myUser.getUserAccounts();
    }


    public static void openNewAccount(User user, int id, int type, double balance){
        boolean accountExist = users.stream().
                anyMatch(u->u.getUserAccounts().stream().anyMatch(a->a.getId() == id));

        List<Account> myUserAccounts = user.getUserAccounts();

        if(!accountExist){
            myUserAccounts.add(new Account(id,type,balance, user.getEmail()));
            user.setUserAccounts(myUserAccounts);
            System.out.printf("\nthe Account has been opened successfully " +
                    "\n with ID: %s " +
                    "\n and Account type: %s " +
                    "\n and with balance: %s \n", id, type, balance);
        }
        else {
            System.out.println("this account id does exist");
        }
    }


    public static Account deposit(User user, int accountId, double depositAmount){
        Account account = user.getUserAccounts().
                stream().filter(a->a.getId()==accountId).findFirst().orElse(null);
        if(account != null ){
            if(depositAmount>=0) {
                account.setBalance(account.getBalance() + depositAmount);
                System.out.printf("the amount deposited successfully and this account current balance: %s",
                        account.getBalance());
            }else {
                System.out.println("could not deposit negative amount");
            }
        }else{
            System.out.println("could not find account with that id");
        }
        return account;
    }


    public static Account withdraw(User user, int accountId, double withdrawAmount){
        Account account = user.getUserAccounts().
                stream().filter(a->a.getId()==accountId).findFirst().orElse(null);
        if(account != null ){
            if (account.getBalance()>=withdrawAmount){
                if(withdrawAmount>=0) {
                    account.setBalance(account.getBalance() - withdrawAmount);
                    System.out.printf("\nyou withdraw %s successfully  " +
                                    "\n and your new balance: %s \n",
                            withdrawAmount, account.getBalance());
                }else {
                    System.out.println("could not withdraw negative amount");
                }
            }else{
                System.out.println("sorry there is no enough balance!");
            }
        }else{
            System.out.println("could not find account with that id");
        }
        return account;
    }
}
