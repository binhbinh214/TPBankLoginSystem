package model;

import common.Library;
import common.CheckValidation;
import java.util.Locale;

public class LoginBank {

    private static LoginBank instance = null;
    Library l = new Library();
    CheckValidation val = new CheckValidation();

    public static LoginBank Instance() {
        if (instance == null)
            synchronized (LoginBank.class) {
            if (instance == null) {
                instance = new LoginBank();
            }
        }
        return instance;
    }

    public void login(Locale language) {
        val.getWordLanguage(language, "enterAccountNumber");
        String account = l.getString("");
        while (!val.checkAccount(language, account)) {
            val.getWordLanguage(language, "enterAccountNumber");
            account = l.getString("");
        }
        val.getWordLanguage(language, "enterPassword");
        String password = l.getString("");
        while (val.checkPassword(language, password) == null) {
            val.getWordLanguage(language, "enterPassword");
            password = l.getString("");
        }
        String captchaGenerated = l.generateCaptchaText();
        System.out.println(captchaGenerated);
        val.getWordLanguage(language, "enterCaptcha");
        String captchaInput = l.getString("");
        while (!val.checkCaptcha(language, captchaGenerated, captchaInput)) {
            captchaGenerated = l.generateCaptchaText();
            System.out.println(captchaGenerated);
            val.getWordLanguage(language, "enterCaptcha");
            captchaInput = l.getString("");
        }
        val.getWordLanguage(language, "loginSuccess");
        System.out.println("");
    }

}
