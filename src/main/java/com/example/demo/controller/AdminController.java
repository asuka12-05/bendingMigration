package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.DrinkDto;
import com.example.demo.dto.SalesDto;
import com.example.demo.service.AdminService;

/**
 * 業者コントローラー
 */
@Controller
public class AdminController {
	
	/** DI */
	private final AdminService adminService;

	/**
	 * コンストラクタインジェクション
	 * @param adminService		業者サービス
	 */
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 業者画面に遷移する
	 * @return
	 */
	@GetMapping("/bending/admin")
	public String showAdmin(Model model, HttpSession session) {
		model.addAttribute("drinkList", adminService.getDrinkList(session));
		model.addAttribute("sales", adminService.getSales(session));
		return "admin";
	}
	
	/**
	 * 在庫を補充する
	 * @return
	 */
	@PostMapping("/replenish")
	public String replenish(@RequestParam int drinkId,  @RequestParam int count, HttpSession session,
							RedirectAttributes redirectAttributes) {
		adminService.replenish(session, drinkId, count);
		return "redirect:/bending/admin";
	}
	
	/**
	 * 商品を別商品に交換する
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/replace")
	public String replace(@RequestParam int drinkId, DrinkDto drinkDto, HttpSession session) throws Exception {
		adminService.replace(session, drinkId, drinkDto);
		return "redirect:/bending/admin";
	}
	
	/**
	 * カスタム商品を作成する
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/addCustom")
	public String addCustom(@RequestParam int drinkId, DrinkDto drinkDto, HttpSession session) throws Exception {
		adminService.addCustomDrink(session, drinkDto);
        adminService.replace(session, drinkId, drinkDto);
		return "redirect:/bending/admin";
	}
	
	/**
	 * 売り上げを回収する
	 * @return
	 */
	@PostMapping("/collect")
	public String collect(HttpSession session, RedirectAttributes redirectAttributes) {
		SalesDto sales = adminService.collectSales(session);
        redirectAttributes.addFlashAttribute("collectedSales", sales);
		return "redirect:/bending/admin";
	}
}
