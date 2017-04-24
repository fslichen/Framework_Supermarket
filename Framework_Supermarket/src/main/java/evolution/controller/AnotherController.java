package evolution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnotherController {
	@GetMapping("redirect")
	public String redirect() {
		return "redirect:http://www.google.com";
	}
}
