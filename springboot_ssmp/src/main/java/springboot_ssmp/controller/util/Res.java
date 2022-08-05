package springboot_ssmp.controller.util;

import lombok.Data;

@Data
public class Res {
    private Boolean flag;
    private Object data;
    private String mes;

    public Res() {
    }

    public Res(Boolean flag) {
        this.flag = flag;
    }

    public Res(Boolean flag, Object object) {
        this.flag = flag;
        this.data = object;
    }

    public Res(String mes) {
        this.mes = mes;
    }

    public Res(Boolean flag, Object data, String mes) {
        this.flag = flag;
        this.data = data;
        this.mes = mes;
    }
}
