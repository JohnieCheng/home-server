package com.johnie.homeserver.common.interceptor;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalController {

    /**
     * 全局数据绑定
     * 应用到所有的@RequestMapping注解方法，在其执行官之前初始化数据绑定器
     *
     * @param model
     */
    @ModelAttribute
    public void add(Model model) {
        model.addAttribute("msg", "此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对");
    }

    /**
     * 全局数据预处理
     * 应用到所有的@RequestMapping注解方法，在其执行官之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }

    /**
     * 全局异常处理
     * 应用到所有的@RequestMapping注解方法，在其抛出Exception异常时执行
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return "error";
    }


}
