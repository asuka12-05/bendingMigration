package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 業者コントローラー
 */
@Controller
public class AdminController {

	/**
	 * 業者画面に遷移する
	 * @return
	 */
	@GetMapping("/bending/admin")
	public String showAdmin() {
		return "admin";
	}
	
	/**
	 * 在庫を補充する
	 * @return
	 */
	@PostMapping("/replenish")
	public String replenish() {
		return "redirect:/bending/admin";
	}
	
	/**
	 * 商品を別商品に交換する
	 * @return
	 */
	@PostMapping("/replace")
	public String replace() {
		return "redirect:/bending/admin";
	}
	
	/**
	 * カスタム商品を作成する
	 * @return
	 */
	@PostMapping("/addCustom")
	public String addCustom() {
		return "redirect:/bending/admin";
	}
	
	/**
	 * 売り上げを回収する
	 * @return
	 */
	@PostMapping("/collect")
	public String collect() {
		return "redirect:/bending/admin";
	}
}
