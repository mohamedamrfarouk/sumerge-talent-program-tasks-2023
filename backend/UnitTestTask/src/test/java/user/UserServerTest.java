package user;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServerTest {


    @Test
     void signUp() throws NotValidMailException {
        List<User> usersMock = mock(UserServer.users.getClass());

        User existingUser = UserServer.users.get(1);

        when(usersMock.size()).thenReturn(7);

        // check nothing changed with the users list
        assertEquals(usersMock.size(),
                UserServer.signUp(existingUser.getName(),
                        existingUser.getEmail(),
                        existingUser.getPassword()).size(),
                "this test failed, it should return the users without " +
                        "extra user who tried to signed up as this email already associated with a user"
        );

        // check that it will throw error when use invalid email
        assertThrows(NotValidMailException.class,()->
                UserServer.signUp(" "," "," "),
                "this test failed, it should return the users without " +
                        "extra user who tried to signed up as this can't be an email"
        );

        // check is changes the users list size
        assertNotEquals(usersMock.size(),
                UserServer.signUp("momo","momo@gmail.com","momo123123").size(),
                "this test failed, it should return the users with extra user who signed up"
        );
    }

    @org.junit.jupiter.api.Test
    void login() throws NotValidMailException {
        assertFalse(UserServer.login("email@email.com","password123"));
        assertThrows(NotValidMailException.class , ()-> UserServer.login("invalid email","password123"));
        assertTrue(UserServer.login("mohamed@gmail.com","mohamed123123"));
    }
}