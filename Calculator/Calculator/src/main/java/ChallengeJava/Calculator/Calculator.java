package ChallengeJava.Calculator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import org.modelmapper.ModelMapper;

import java.text.DecimalFormat;
import java.util.Map;

@Service
public class Calculator {
    public static  final Logger log = LoggerFactory.getLogger(Calculator.class);
    DecimalFormat f = new DecimalFormat("##.00"); // 2 casas decimais
    private ObjectMapper objectMapper = new ObjectMapper();
    double resultFinal;


    public String Sum(Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Sum");
        resultFinal = Double.parseDouble(allParams.get("a")) + Double.parseDouble(allParams.get("b"));

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
       // return a+b;
    }

    public String Substraction(Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Substraction");
        resultFinal = Double.parseDouble(allParams.get("a")) - Double.parseDouble(allParams.get("b"));

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
    }

    public String Multiplication(Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Multiplication");
         resultFinal = Double.parseDouble(allParams.get("a")) * Double.parseDouble(allParams.get("b"));
        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
    }

    public String Division(Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Division");

        double b = Double.parseDouble(allParams.get("b"));
        if(b==0)
            throw new ArithmeticException("Division by zero.");

        resultFinal = Double.parseDouble(allParams.get("a")) / b;

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));

    }


}
