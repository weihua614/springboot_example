package springboot_ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springboot_ssmp.pojo.Emp;

@Repository
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
}
