package user;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServerTest {

    List<User> usersMock;
    User existingUser;

    @BeforeAll
    static void beforeAll(){
        System.out.println("testing started!");
    }

    @BeforeEach
    @DisplayName("SignUp test init before each")
    void init() {
        usersMock = mock(UserServer.users.getClass());

        existingUser = UserServer.users.get(1);

        when(usersMock.size()).thenReturn(7);
    }
    @Nested
    class SignUpTests {
        // check nothing changed with the users list
        @Test
        @DisplayName("Sign up with Existing User")
        void testSignUpExistingUser() throws NotValidMailException {
            assertEquals(usersMock.size(),
                    UserServer.signUp(existingUser.getName(),
                            existingUser.getEmail(),
                            existingUser.getPassword()).size(),
                    "this test failed, it should return the users without " +
                            "extra user who tried to signed up as this email already associated with a user"
            );
        }

        // check that it will throw error when use invalid email
        @Test
        @DisplayName("SignUp with invalid email or password ")
        void testSignUpInvalidCredentials() throws NotValidMailException {
            assertThrows(NotValidMailException.class, () ->
                            UserServer.signUp(" ", " ", " "),
                    "this test failed, it should return the users without " +
                            "extra user who tried to signed up as this can't be an email"
            );
        }


        // check is changes the users list size
        @Test
        @DisplayName("SignUp with valid credentials")
        void testSignUpValidCredentials() throws NotValidMailException {
            assertNotEquals(usersMock.size(),
                    UserServer.signUp("momo", "momo@gmail.com", "momo123123").size(),
                    "this test failed, it should return the users with extra user who signed up"
            );
            when(usersMock.size()).thenReturn(8);

        }
    }

    @Nested
    class LoginTests{
        @Test
        @DisplayName("login with invalid")
        void testLoginWithInvalidEmail() throws NotValidMailException {
            assertNull(UserServer.login("email@email.com","password123"));
        }
        @Test
        @DisplayName("login with not an email")
        void testLoginWithNotEmail() throws NotValidMailException {
            assertThrows(NotValidMailException.class,
                    () -> UserServer.login("invalid email", "password123"));
        }
        @Test
        @DisplayName("login with invalid password, length < 7")
        void testLoginWithNotValidPassword() throws NotValidMailException {
            assertNull(UserServer.login("mohamed@gmail.com", "pass"));
        }
        @Test
        @DisplayName("login with valid email and password")
        void testLoginWithValidEmailAndPassword() throws NotValidMailException {
            assertNotNull(UserServer.login("mohamed@gmail.com","mohamed123123"));
            assertEquals(UserServer.login("mohamed@gmail.com","mohamed123123").getEmail(), "mohamed@gmail.com");
            assertEquals(UserServer.login("mohamed@gmail.com","mohamed123123").getPassword(), "mohamed123123");
        }
    }
    @Nested
    class AfterLoggingInServices{
        User user = UserServer.login("mohamed@gmail.com","mohamed123123");
        List<Account> accounts = UserServer.users.stream().filter(u->u == user).findFirst().get().getUserAccounts();
        int accountsSizeBeforeTestCase = accounts.size();

        AfterLoggingInServices() throws NotValidMailException {
        }
        @Test
        @DisplayName("get all accounts of a specific user")
        void testGetAllUserAccounts() throws NotValidMailException {
            assertEquals(UserServer.getAllUserAccounts(user),accounts);
        }

        @Nested
        class OpenNewAccountTests{
            @Test
            @DisplayName("open new account with existing account id")
            void testOpenAccountWithExistingId(){
                UserServer.openNewAccount(user,1,1,0);
                assertEquals(accountsSizeBeforeTestCase,accounts.size());
            }
            @Test
            @DisplayName("open new account with existing account id")
            void testOpenAccountWithOtherUserExistingId(){
                UserServer.openNewAccount(user,20,1,0);
                assertEquals(accountsSizeBeforeTestCase,accounts.size());
            }
            @Test
            @DisplayName("open new account with new id")
            void testOpenAccountWithNewId(){
                UserServer.openNewAccount(user,51,1,0);
                assertNotEquals(accountsSizeBeforeTestCase,accounts.size());
            }
        }

        @Nested
        class DepositTests{
            @Test
            @DisplayName("deposit money in account with invalid account id")
            void testDepositWithInvalidAccountId(){
                assertNull(UserServer.deposit(user, 999,10));
            }
            @Test
            @DisplayName("deposit negative amount of money")
            void testDepositWithNegativeDepositAmount(){
                double beforeRunningBalance = accounts.stream().filter(a->a.getId()==1).findFirst().get().getBalance();
                assertEquals(UserServer.deposit(user, 1,-10).getBalance() ,
                        beforeRunningBalance);
            }
            @Test
            @DisplayName("deposit money in account with valid id and amount")
            void testDepositWithValidAccountId(){
                assertNotNull(UserServer.deposit(user, 1,10));
                assertEquals(UserServer.deposit(user, 1,10).getBalance() ,
                        accounts.stream().filter(a->a.getId()==1).findFirst().get().getBalance());
            }
        }

        @Nested
        class WithdrawTests{
            @Test
            @DisplayName("withdraw money in account with invalid id")
            void testWithdrawWithInvalidAccountId(){
                assertNull(UserServer.withdraw(user, 999,10));
            }
            @Test
            @DisplayName("withdraw negative amount of money")
            void testWithdrawWithNegativeWithdrawAmount(){
                double beforeRunningBalance = accounts.stream().filter(a->a.getId()==1).findFirst().get().getBalance();
                assertEquals(UserServer.withdraw(user, 1,-10).getBalance() ,
                        beforeRunningBalance);
            }
            @Test
            @DisplayName("withdraw amount of money more than the balance")
            void testWithdrawWithAmountMoreThanAccountBalance(){
                double beforeRunningBalance = accounts.stream().filter(a->a.getId()==1).findFirst().get().getBalance();
                assertEquals(UserServer.withdraw(user, 1,1000000000).getBalance() ,
                        beforeRunningBalance);
            }
            @Test
            @DisplayName("withdraw valid amount of money with valid account id")
            void testWithdrawWithValidAccountId(){
                assertNotNull(UserServer.withdraw(user, 1,10));
                assertEquals(UserServer.withdraw(user, 1,10).getBalance() ,
                        accounts.stream().filter(a->a.getId()==1).findFirst().get().getBalance());
            }
        }
    }
}