
package controller;

import java.util.Locale;
import repository.LoginRepo;
import view.Menu;
import repository.ILoginRepo;


public class LoginManager extends Menu<String> {
    static String[] options = {"Vietnamese", "English", "Exit"};
    private ILoginRepo loginRepository;
    Locale vietnamese = new Locale("vi");
    Locale english = new Locale("en");
    public LoginManager() {
        super("============= LOGIN PROGRAM =============", options);
        loginRepository = new LoginRepo();
    }

    @Override
    public void execute(int n) {
        switch(n) {
            case 1: loginRepository.login(vietnamese);
            break;
            case 2: loginRepository.login(english);
            break;
            case 3: System.exit(0);
            break;
        }
    }

}