package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.controller.AdminController;

@ControllerAdvice(assignableTypes = AdminController.class)
public class AdminExceptionHandler {

	// 管理者用コントローラーでのエラー
	@ExceptionHandler(RuntimeException.class)
	public String handleAdminException(Exception e, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errorMsg", e.getMessage());
		return "redirect:/bending/admin";
	}
}
