package springboot_ssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboot_ssmp.mapper.EmpMapper;
import springboot_ssmp.pojo.Emp;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SpringbootSsmpApplicationTests {

    @Autowired
    private EmpMapper empMapper;
    @Test
    void contextLoads() {
        Emp emp = new Emp();
        emp.setAge(22);
       // System.out.println(emp.getEmpName);
//        System.out.println(empMapper.selectList(null));
//        int i=1;
//        int i1 = empMapper.deleteById(26);
//        System.out.println(i1);
//        int insert = empMapper.insert(emp);
//        System.out.println(insert);
//        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("age",23);
//        List<Emp> emps = empMapper.selectByMap(objectObjectHashMap);


//        分页
//        Page<Emp> objectPage = new Page<>(3,5);
//        Page<Emp> empPage = empMapper.selectPage(objectPage, null);
//        System.out.println(empPage);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("emp_Id",1);
        List<Emp> emps = empMapper.selectByMap(stringObjectHashMap);
        System.out.println(emps);
    }

    @Test
    public void testTiaojian(){
        String text="男";
        LambdaQueryWrapper<Emp> lambdaQueryChainWrapper=new LambdaQueryWrapper<>();
        lambdaQueryChainWrapper.like(text!=null,Emp::getSex,text);
        empMapper.selectList(lambdaQueryChainWrapper);
    }

}
