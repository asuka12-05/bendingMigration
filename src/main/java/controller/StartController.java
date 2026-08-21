package controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartController {

	/**
	 * スタート画面に遷移
	 * @return
	 */
	@GetMapping({"/", "/bending/start"})
	public String showStart() {
		return "start";
	}

	/**
	 * リセットボタンを押下したらデフォルト状態に戻る
	 * @return
	 */
	@PostMapping("/reset")
	public String resetDefault(HttpSession session) {
		return "redirect:/bending/start";
	}
}
