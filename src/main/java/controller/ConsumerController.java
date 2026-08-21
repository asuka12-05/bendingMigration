package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 消費者コントローラー
 */
@Controller
public class ConsumerController {

	/**
	 * 消費者画面に遷移する
	 * @return
	 */
	@GetMapping("/bending/consumer")
	public String showConsumer() {
		return "consumer";
	}
	
	/**
	 * 商品を購入しおつりを返金する
	 * @return
	 */
	@PostMapping("/buy")
	public String buyDrink() {
		return "redirect:/bending/consumer";
	}
	
	/**
	 * 商品を購入せず投入金額をそのまま返金
	 * @return
	 */
	@PostMapping("/return")
	public String returnChange() {
		return "redirect:/bending/consumer";
	}
	
	/**
	 * 投入額をサーバー側で管理
	 * @return
	 */
	@PostMapping("/insertMoney")
	public String insertMoney() {
		return "redirect:/bending/consumer";
	}
}
