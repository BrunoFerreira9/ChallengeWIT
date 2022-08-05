package ChallengeJava.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class calculator {

    public double Sum(Map<String, String> allParams) {
        return   Double.parseDouble(allParams.get("a")) + Double.parseDouble(allParams.get("b"));
       // return a+b;
    }

    public double Substraction(Map<String, String> allParams) {
        return   Double.parseDouble(allParams.get("a")) - Double.parseDouble(allParams.get("b"));
    }

    public double Multiplication(Map<String, String> allParams) {
        return   Double.parseDouble(allParams.get("a")) * Double.parseDouble(allParams.get("b"));
    }

    public double Division(Map<String, String> allParams) {
        double b = Double.parseDouble(allParams.get("b"));
        if(b==0)
            throw new ArithmeticException("Division by zero.");

         return   Double.parseDouble(allParams.get("a")) / b;

    }


}
