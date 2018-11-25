package com.frame.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhanglm
 * @date 2018年11月22日 下午1:59:46
 * 
 */
@Controller
public class I18nController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/i18n")
    public String i18n(Model model) {
        String message = messageSource.getMessage("page.content", null, Locale.SIMPLIFIED_CHINESE);
        System.out.println("message=" + message);
        model.addAttribute("content", message);
        return "/i18n";
    }
}