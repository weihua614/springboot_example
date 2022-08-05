package springboot_ssmp.pojo;

import lombok.Data;

@Data
public class Emp {
    private Integer empId;
    private String  empName;
    private Integer age;
    private String sex;
    private String email;

    public Emp() {
    }

    public Emp(Integer empId, String empName, Integer age, String sex, String email) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }


}
