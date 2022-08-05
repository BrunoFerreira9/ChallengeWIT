package ChallengeJava.Calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("calculator/")
public class restController {
    public static  final Logger log = LoggerFactory.getLogger(restController.class);
    public static  int requestIdentifier = 1;

    HttpHeaders headers = new HttpHeaders();
    @Autowired
    calculator Calculator ;
    @GetMapping(value = "/sum")
    public ResponseEntity<?> Soma(@RequestParam Map<String, String> allParams) {

        headers.clear();
        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));

        //log.info("Request GET - Sum");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Calculator.Sum(allParams));

    }

    @GetMapping(value = "/substraction")
    public ResponseEntity<?> Substraction(@RequestParam Map<String, String> allParams) {

        headers.clear();


            headers.add("requestIdentifier",String.valueOf(requestIdentifier++));
            //log.info("Request GET - Substraction");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Calculator.Substraction(allParams));

    }

    @GetMapping(value = "/multiplication")
    public ResponseEntity<?> Multiplication(@RequestParam Map<String, String> allParams) {

        headers.clear();
        headers.add("requestIdentifier",String.valueOf(requestIdentifier++));
            //log.info("Request GET - Multiplication");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Calculator.Multiplication(allParams));

    }

    @GetMapping(value = "/division")
    public ResponseEntity<?> Division(@RequestParam Map<String, String> allParams) {
        headers.clear();
        try {
            headers.add("requestIdentifier",String.valueOf(requestIdentifier++));
           // log.info("Request GET - Division");

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Calculator.Division(allParams));

        } catch (ArithmeticException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(ex.getMessage());
        }
    }
}
