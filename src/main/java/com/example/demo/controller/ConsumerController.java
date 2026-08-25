package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.BendingDAO;
import com.example.demo.dto.DrinkDto;
import com.example.demo.service.ConsumerService;

/**
 * 消費者コントローラー
 */
@Controller
public class ConsumerController {

	/** DI */
	private final ConsumerService consumerService;
	private final BendingDAO dao;

	/**
	 * コンストラクタインジェクション
	 * @param consumerService	消費者サービス
	 * @param dao				DAO
	 */
	public ConsumerController(ConsumerService consumerService, BendingDAO dao) {
		this.consumerService = consumerService;
		this.dao = dao;
	}

	/**
	 * 消費者画面に遷移する
	 * @return
	 */
	@GetMapping("/bending/consumer")
	public String showConsumer(Model model, HttpSession session) {
		model.addAttribute("drinkList", consumerService.getDrinkList(session));
		model.addAttribute("insertedMoney", dao.getInsertedMoney(session));
		return "consumer";
	}

	/**
	 * 商品を購入しおつりを返金する
	 * @return
	 */
	@PostMapping("/buy")
	public String buyDrink(@RequestParam int drinkId, HttpSession session, RedirectAttributes redirectAttributes) {
		int change = consumerService.purchase(session, drinkId);
		DrinkDto gotDrink = consumerService.findById(session, drinkId);
		redirectAttributes.addFlashAttribute("gotDrink", gotDrink);
		redirectAttributes.addFlashAttribute("change", change);
		return "redirect:/bending/consumer";
	}

	/**
	 * 商品を購入せず投入金額をそのまま返金
	 * @return
	 */
	@PostMapping("/return")
	public String returnChange(HttpSession session, RedirectAttributes redirectAttributes) {
		int change = consumerService.returnChange(session);
		redirectAttributes.addFlashAttribute("change", change);
		return "redirect:/bending/consumer";
	}

	/**
	 * 投入額をサーバー側で管理
	 * @return
	 */
	@PostMapping("/insertMoney")
	public String insertMoney(@RequestParam int amount, HttpSession session, RedirectAttributes redirectAttributes) {
		consumerService.insertMoney(session, amount);
		return "redirect:/bending/consumer";
	}
}
