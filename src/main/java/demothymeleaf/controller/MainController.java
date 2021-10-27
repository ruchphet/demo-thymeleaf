package demothymeleaf.controller;

import demothymeleaf.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    private Employee employee = new Employee();
    private List<Employee> employeeList = new ArrayList<>();
    String vExpression = "Hello Thymeleaf";

    @RequestMapping("/")
    public String root(Model model) {
        model.addAttribute("greetingMsg", vExpression);
        model.addAttribute("employee", employee);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Model model, Employee employeeInput) {
        logger.info("Receive Employee : {} ", employeeInput);
        employeeList.add(employeeInput);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("greetingMsg", vExpression);
        model.addAttribute("employee", employee);
        return "index";
    }
}
