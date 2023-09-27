package user;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServer {
    static List<User> users = new ArrayList<>(Arrays.asList(
            new User("mohamed","mohamed@gmail.com","mohamed123123"),
            new User("ahmed","ahmed@gmail.com","ahmed123123"),
            new User("mostafa","mostafa@gmail.com","mostafa123123"),
            new User("mahmoud","mahmoud@gmail.com","mahmoud123123"),
            new User("taha","taha@gmail.com","taha123123"),
            new User("abdelrahman","abdelrahman@gmail.com","abdelrahman123123"),
            new User("Abdullah","Abdolallah@gmail.com","Abdullah123123")
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
                users.add( new User(name, email, password));
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
    public static boolean login(String email, String password) throws NotValidMailException {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        boolean validEmail = email.matches(regex);
        if(validEmail){
            User userLogged = users.stream().
                    filter(u->u.getEmail().equals(email) && u.getPassword().equals(password)).
                    findFirst().orElse(null);

            if(userLogged != null){
                userLogged.setLogedin(true);
                System.out.println(userLogged.getName() + ", logged in successfully");
                return true;
            }else {
                System.out.println("Invalid email and password");
            }
        }else {
            System.out.println("please enter a valid email, this can't be an email");
            throw new NotValidMailException("please enter a valid email, this can't be an email");
        }
        return false;

    }

}
