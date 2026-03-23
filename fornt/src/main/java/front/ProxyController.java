package front;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class ProxyController {

    private final String EC2_1 = "http://44.201.221.65:8080/sum";
    private final String EC2_2 = "http://98.94.60.192:8080/sum";

    private final RestTemplate restTemplate = new RestTemplate();
    private final Random random = new Random();

    @GetMapping("/sum")
    public String proxyTopdown(@RequestParam int number1, @RequestParam int number2) {

        String targetUrl = random.nextBoolean() ? EC2_1 : EC2_2;

        String fullUrl = targetUrl + "?number1=" + number1 + "&number2=" + number2;

        return restTemplate.getForObject(fullUrl, String.class);
    }
}