
package repository;

import model.LoginBank;
import java.util.Locale;


public class LoginRepo implements ILoginRepo {

    @Override
    public void login(Locale language) {
        LoginBank.Instance().login(language);
    }  
}