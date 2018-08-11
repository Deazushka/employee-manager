package by.training.employeemanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "redirect:/main.html";
    }

    @GetMapping("/main")
    public String main() {
        return "redirect:/main.html";
    }

    @GetMapping("/salary")
    public String salary() {
        return "redirect:/salary.html";
    }

    @GetMapping("/vacation")
    public String vacation() {
        return "redirect:/vacation.html";
    }
}
