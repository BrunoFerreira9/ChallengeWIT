package ChallengeJava.Calculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("calculator/")
public class RestController {
    public static  int requestIdentifier = 1;

    HttpHeaders headers = new HttpHeaders();
    @Autowired
    ChallengeJava.Calculator.Calculator Calculator ;
    @GetMapping(value = "/sum")
    public ResponseEntity<?> Soma(@RequestParam Map<String, String> allParams) throws JsonProcessingException {

        headers.clear();
        MDC.put("requestIdentifier",String.valueOf(requestIdentifier));

        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Calculator.Sum(allParams));

    }

    @GetMapping(value = "/substraction")
    public ResponseEntity<?> Substraction(@RequestParam Map<String, String> allParams) throws JsonProcessingException {

        headers.clear();
        MDC.put("requestIdentifier",String.valueOf(requestIdentifier));

        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Calculator.Substraction(allParams));

    }

    @GetMapping(value = "/multiplication")
    public ResponseEntity<?> Multiplication(@RequestParam Map<String, String> allParams) throws JsonProcessingException {
        headers.clear();
        MDC.put("requestIdentifier",String.valueOf(requestIdentifier));

        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Calculator.Multiplication(allParams));

    }

    @GetMapping(value = "/division")
    public ResponseEntity<?> Division(@RequestParam Map<String, String> allParams) {
        headers.clear();
        MDC.put("requestIdentifier",String.valueOf(requestIdentifier));

        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Calculator.Division(allParams));

        } catch (ArithmeticException | JsonProcessingException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getMessage());
        }
    }
}
