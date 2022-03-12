import User.impl.UserImpl;
import exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger logger= LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) throws CustomException {
        logger.info("Hi logger");
        UserImpl normUserImpl =new UserImpl();
        UserImpl badUserImpl =new UserImpl();
        UserImpl badUserImpl2 =new UserImpl();
        //normUser
        normUserImpl.setLogin("Ilya1234");
        normUserImpl.setPassword("hello");
        normUserImpl.setConfirmPassword("hello");
        System.out.println(normUserImpl);
        //error correct login
        badUserImpl.setLogin(" Iya1234");
        badUserImpl.setPassword("hello");
        badUserImpl.setConfirmPassword("hello");
        System.out.println(badUserImpl);
        //error equals password
        badUserImpl2.setLogin("Iya1234");
        badUserImpl2.setPassword("heello");
        badUserImpl2.setConfirmPassword("hello");
        System.out.println(badUserImpl2);
    }
}
