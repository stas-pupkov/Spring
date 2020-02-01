package ru.pupkov.stas;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/first")
    public String firstPage() {
        return "first";
    }

    @GetMapping("/second")
    public String secondPage() {
        return "second";
    }

    @RequestMapping("/hello")
    public String display(HttpServletRequest request, @RequestParam("pass") String pass, Model model) {
        //read the provided form data
        String name = request.getParameter("name");

        //We can use @RequestParam to provide access
        //String pass = request.getParameter("pass");

        if(pass.equals("admin"))
        {
            String message = "Hello " + name;
            //add a message to the model
            model.addAttribute("message", message);
            return "correct";
        }
        else
        {
            String message = "Sorry " + name + ". You entered an incorrect password";
            model.addAttribute("message", message);
            return "incorrect";
        }
    }
}
