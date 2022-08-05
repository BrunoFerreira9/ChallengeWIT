package ChallengeJava.Calculator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.Map;


@Service
public class CalculatorService {
    public static  final Logger log = LogManager.getLogger(CalculatorService.class);

    private static final DecimalFormat f = new DecimalFormat("##.00"); // 2 casas decimais
    private static final  ObjectMapper objectMapper = new ObjectMapper();


    public String Sum(final Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Sum. Request identifier: "+ MDC.get("requestIdentifier"));

        final double resultFinal = Double.parseDouble(allParams.get("a")) + Double.parseDouble(allParams.get("b"));

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
       // return a+b;
    }

    public String Substraction(final Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Substraction. Request identifier: "+ MDC.get("requestIdentifier"));
        final double resultFinal = Double.parseDouble(allParams.get("a")) - Double.parseDouble(allParams.get("b"));

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
    }

    public String Multiplication(final Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Multiplication. Request identifier: "+ MDC.get("requestIdentifier"));
        final double resultFinal = Double.parseDouble(allParams.get("a")) * Double.parseDouble(allParams.get("b"));
        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));
    }

    public String Division(final Map<String, String> allParams) throws JsonProcessingException {
        log.info("New request GET for Division. Request identifier: "+ MDC.get("requestIdentifier"));

        final double b = Double.parseDouble(allParams.get("b"));

        if(b==0) {
            throw new ArithmeticException(objectMapper.writeValueAsString(new Result("Division by zero.")));
        }

        final double resultFinal = Double.parseDouble(allParams.get("a")) / b;

        return objectMapper.writeValueAsString(new Result(f.format(resultFinal)));

    }


}
