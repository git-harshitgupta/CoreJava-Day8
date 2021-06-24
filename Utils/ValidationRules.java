package Utils;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.*;

import com.app.core.Customer;
import com.app.core.Customer.*;

import static com.app.core.Customer.sdf;
import exeception.CustomerHandlingException;
public class ValidationRules {
    private static Date tempDate;
    static {
        try {
            tempDate = sdf.parse("1-1-1995");
        }
        catch (ParseException e) {
            System.out.println("Error in static date block " + e);
        }
    }
    public static Date convertDate(String date) throws ParseException, CustomerHandlingException {
       Date d1 = sdf.parse(date);
        if(d1.before(tempDate)){
            throw new CustomerHandlingException("Your age is not valid");
        }
        return d1;
    }
    public static String validateEmail(String email, Customer[] customer) throws CustomerHandlingException {

        for(Customer test : customer){
            if(test!=null)
                if(email.equals(test.getEmailAddress())){
                    throw new CustomerHandlingException("Email address already present");
                }
        }

        if(email.contains("@")&&email.contains(".com")){
            return email;
        }
        else
            throw new CustomerHandlingException("Invaild email entered");
    }

    public static String validatePassword(String password) throws CustomerHandlingException {
        if(password.length()>=3&&password.length()<=9){
            return password;
        }
        else
            throw new CustomerHandlingException("Entered password is to short");
    }

}
