package springboot_ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot_ssmp.pojo.Employee;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
