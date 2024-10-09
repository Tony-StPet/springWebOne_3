package com.example.springWebOne;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class Controller2 {
    @GetMapping("/str2")
    public String str2(Model model){
        System.out.println("запрос к template2");

        int x = new Random().nextInt(1, 100);
        int y = new Random().nextInt(30, 80);
        model.addAttribute("num1", x);
        model.addAttribute("num2", y);
        return "tepmlate2";
    }



    public Controller2() {
        System.out.println("создается  Controller2");
    }

    @GetMapping("/additionist")
    public String additionist(
        @RequestParam(value = "a", defaultValue = "0") int a,
        @RequestParam(value = "b", defaultValue = "0") int b, Model model){

            System.out.println("получены числа:: a = " + a + "  b = "+ b );//для отладки
            model.addAttribute("num1", a);
            model.addAttribute("num2", b);
        model.addAttribute("result", (a+b));
        System.out.println("получена сумма чисел:: a + b = " + (a+b) );//для отладки
        return "templateSum";
    }
}
