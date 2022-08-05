package springboot_ssmp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import springboot_ssmp.pojo.Employee;

public interface IEmployeeService extends IService<Employee> {
//    public boolean mupdateById();
    public Page<Employee> getEmployPages();
}
