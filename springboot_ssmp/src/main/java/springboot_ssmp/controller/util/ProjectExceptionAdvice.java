package springboot_ssmp.controller.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public Res doOtherException(Exception ex){

        ex.printStackTrace();
        return new Res("服务器出现异常");
    }

}
