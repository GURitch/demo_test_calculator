package skypro.javaind.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.javaind.calculator.service.CalculatorService;

@RestController
//@RequestMapping("/calculator")
public class Controller {
    CalculatorService calculatorService;

    public Controller(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/")
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") Double x, @RequestParam("num2") Double y) {
        return calculatorService.plus(x, y);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") double x, @RequestParam("num2") double y) {
        return calculatorService.minus(x, y);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") double x, @RequestParam("num2") double y) {
        return calculatorService.multiply(x, y);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") double x, @RequestParam("num2") double y) {
        return calculatorService.divide(x, y);
    }
}
