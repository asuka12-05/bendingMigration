package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.ConsumerController;

@ControllerAdvice(assignableTypes = ConsumerController.class)
public class ConsumerExceptionHandler {

	// 消費者用コントローラーでのエラー
    @ExceptionHandler(RuntimeException.class) // 自作の専用例外など
    public String handleConsumerException(Exception e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
        return "redirect:/bending/consumer";
    }

}
