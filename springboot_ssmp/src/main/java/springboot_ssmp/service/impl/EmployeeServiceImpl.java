package springboot_ssmp.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_ssmp.mapper.EmployeeMapper;
import springboot_ssmp.pojo.Employee;
import springboot_ssmp.service.IEmployeeService;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public Page<Employee> getEmployPages() {
        Page<Employee> objectPage = new Page<>(2,2);
        return employeeMapper.selectPage(objectPage,null);
    }


//    @Override
//    public boolean mupdateById() {
//        employeeMapper.updateById();
//    }
}
