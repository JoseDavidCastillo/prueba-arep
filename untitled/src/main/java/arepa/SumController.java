package arepa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @GetMapping("/sum")
    public int sum(@RequestParam(value = "number1") int number1,@RequestParam(value = "number2") int number2){
        return number1+number2;
    }
}
