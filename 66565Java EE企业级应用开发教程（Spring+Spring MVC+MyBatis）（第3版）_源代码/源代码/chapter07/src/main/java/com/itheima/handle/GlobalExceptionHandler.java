package com.itheima.handle;


import com.itheima.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.logging.Handler;



@ControllerAdvice
public class GlobalExceptionHandler implements HandlerInterceptor {
    //处理MyException类型的异常
    @ExceptionHandler(MyException.class)
    public ModelAndView handleMyException(MyException ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
    //处理IOException类型的异常
    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(Exception ex)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "文件读取异常！");
        modelAndView.setViewName("error");
        return modelAndView;
    }
    //处理Exception类型的异常
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex)  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "网络异常！");
        modelAndView.setViewName("error");
        ex.printStackTrace();
        return modelAndView;
    }
}
