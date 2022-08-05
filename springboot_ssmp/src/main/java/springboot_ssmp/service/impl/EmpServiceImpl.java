package springboot_ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import springboot_ssmp.mapper.EmpMapper;
import springboot_ssmp.pojo.Emp;
import springboot_ssmp.service.IEmpService;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
}
