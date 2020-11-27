package com.aklil.gsmvc.employee_management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("employees") // identified as a class that can handle web requests and responses
public class EmployeeController {

    // controller delegates work to the methods to handle the requests

    private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping({"","/"})
    public String index(Model model){

        //String indexPageMessage = "Hello MVC";
        //model.addAttribute("message", indexPageMessage);

        var employees = employeeService.getEmployees();

        model.addAttribute("employees", employees);

        return "employees/employees";
    }

    @GetMapping({"/add", "/edit/{id}"})
    public String addEditEmployee(@PathVariable("id")Optional<Long> id, Model model){

        if (id.isPresent()) {
            Employee employee = employeeService.getEmployeeById(id.get()).get();
            model.addAttribute("employee", employee);
        } else {
            model.addAttribute("employee", new Employee());
        }

        return "employees/add-edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @PostMapping("/create")
    public String createEmployee(Employee employee){
       employeeService.createOrUpdate(employee);
       return "redirect:/employees";
    }


    //http://localhost:8080/employee?id=1
    @GetMapping("/employee")
    public String getEmployee(@RequestParam("id") long id,  Model model){

        logger.info("Using request param");

        var entity = employeeService.getEmployeeById(id);

        entity.ifPresent(employee -> {
            model.addAttribute("firstName", employee.getFirstName());
            model.addAttribute("lastName", employee.getLastName());
        });

        return "employees/detail";
    }

    //http://localhost:8080/employee/1
    @GetMapping("/employee/{id}")
    public String getEmployeeByPathVar(@PathVariable("id") long id, Model model){

        logger.info("Using path variable");

        var entity = employeeService.getEmployeeById(id);

        entity.ifPresent(employee -> {
            model.addAttribute("firstName", employee.getFirstName());
            model.addAttribute("lastName", employee.getLastName());
        });

        return "employees/detail";
    }


}
