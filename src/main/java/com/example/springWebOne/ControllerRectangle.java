package com.example.springWebOne;
import com.example.rectangle.GeometryException;
import com.example.rectangle.Rectangle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerRectangle {

    @GetMapping("/recktangle")
    public String tempRect(
            @RequestParam(value = "a", defaultValue = "0") double a,
            @RequestParam(value = "b", defaultValue = "0") double b, Model model)  {
        model.addAttribute("num1", a);
        model.addAttribute("num2", b);
        try {
            Rectangle r1 = new Rectangle(a, b);
            System.out.println("получен прямоугольник:: "+ r1 );//для отладки
            model.addAttribute("perim", r1.perimeter());
            model.addAttribute("area", r1.area());
            System.out.println("получен периметр:: " + r1.perimeter() );//для отладки
            System.out.println("получена площадь:: " + r1.area() );//для отладки
        } catch (Exception e) {
            System.out.println("не удалось создать прямоугольник"  );//для отладки
        }
        return "tempRect";
    }
}
