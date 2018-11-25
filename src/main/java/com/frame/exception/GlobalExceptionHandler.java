package com.frame.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.domain.JsonResult;


/**
 * @author zhanglm
 * @date 2018年11月20日 下午12:41:10
 *<p>
 * 	全局异常类
 *<p>
 */
@CrossOrigin
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException ex) {
        return exceptionFormat(1, ex);
    }

    
  //自定义异常捕获
    @ExceptionHandler({MyException.class})
    public String myException(MyException ex) {
        System.out.println("自定义异常");
        return exceptionFormat(999, ex);
    }

    private <T extends Throwable> String exceptionFormat(Integer code, T ex) {  
        log.error(String.format(logExceptionFormat, code, ex.getMessage()));  
        return JsonResult.failed(code, ex.getMessage());  
    }


}
