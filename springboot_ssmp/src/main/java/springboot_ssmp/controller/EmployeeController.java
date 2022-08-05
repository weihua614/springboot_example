package springboot_ssmp.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot_ssmp.pojo.Emp;
import springboot_ssmp.pojo.Employee;
import springboot_ssmp.service.IEmpService;
import springboot_ssmp.service.IEmployeeService;

import java.util.List;

//@RestController
//@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee(){
        //   List<Emp> list = empService.list();
        return employeeService.list();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id){

        return employeeService.getById(id);
    }

    @PostMapping
    public Boolean saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @PutMapping("/{id}")
    public Boolean updateEmployee(Employee employee,@PathVariable("id") Integer id)
    {
        LambdaQueryWrapper<Employee> wrapper=new LambdaQueryWrapper<>();

        return employeeService.updateById(employee);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable("id") Integer id)
    {
        return employeeService.removeById(id);
    }

    @GetMapping("/a")
    public Page<Employee> getEmployeePage(){
//        Page<Employee> page=new Page<>(3,2);
//        return employeeService.page(page,null);
        return employeeService.getEmployPages();
    }
}
