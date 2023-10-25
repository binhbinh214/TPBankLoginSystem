
package common;

import java.util.Locale;
import java.util.ResourceBundle;

public class CheckValidation {
    
    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    
    public void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }
    public String checkString(Locale language, String s) {
        if (s.length() != 0)
            return s;
        getWordLanguage(language, "errCheckInputIntLimit");
        System.out.println("");
        return null;
    }
    
    public boolean checkAccount(Locale language, String s) {
        if (s.matches(ACCOUNT_NUMBER_VALID))
            return true;
        getWordLanguage(language, "errCheckInputAccount");
        System.out.println("");
        return false;
    }
    
    public String checkPassword(Locale language, String s) {
        if (isValidPassword(language, s))
            return s;
        return null;
    }
    
    private boolean isValidPassword(Locale language, String password) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "errCheckLengthPassword");
            System.out.println("");
            return false;
        }
        int countDigit = 0;
        int countLetter = 0;
        for (int i = 0; i < lengthPassword; i++)
            if (Character.isDigit(password.charAt(i)))
                countDigit++;
            else 
                if (Character.isLetter(password.charAt(i)))
                    countLetter++;
        if (countDigit < 1 || countLetter < 1) {
            getWordLanguage(language, "errCheckAlphanumericPassword");
            System.out.println("");
            return false;
        }
        return true;
    }
    public boolean checkCaptcha(Locale language, String captchaGenerated, String captchaInput) {
        if (captchaInput.isEmpty())
            return false;
        for (int i = 0; i < captchaInput.length(); i++)
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println("");
                return false;
            }
        return true;
    }
}