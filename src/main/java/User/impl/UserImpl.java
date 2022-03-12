package User.impl;

import User.User;
import exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserImpl implements User {
    public static final Logger logger = LogManager.getLogger(UserImpl.class.getName());
    private String login;
    private String password;
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if(equalsPasswaord(password,confirmPassword)){
            this.confirmPassword = confirmPassword;
        }else {
            logger.error("password other at all");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws CustomException {
        if (login == null || login.length()>20) {
            try {
                if(login.length()>20){
                    throw new CustomException("login need to have length less 20");
                }
            } catch (NullPointerException e) {
                logger.error("Login is empty or line more 20",e);
            }
        } else {
            if (!cheakLogin(login)) {
                logger.error("incorrect login was input");
            } else {
                this.login = login;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    @Override
    public boolean cheakLogin(String login) {
        String regex = "[A-Za-z0-9]+";
        boolean flag ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(login);
        flag = matcher.matches();
        return flag;
    }

    @Override
    public boolean equalsPasswaord(String password, String confirmPassword) {
        boolean flag = false;
        if (password.equals(confirmPassword)) {
            flag = true;
        }
        return flag;
    }
}
