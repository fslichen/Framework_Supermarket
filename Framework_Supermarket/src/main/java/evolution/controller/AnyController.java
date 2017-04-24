package evolution.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import evolution.controller.dto.RequestDto;
import evolution.controller.dto.ResponseDto;

@RestController
public class AnyController {
	@GetMapping("/get")
	public ResponseDto get() {
		return null;
	}
	
	@PostMapping("/post")
	public ResponseDto post(@RequestBody RequestDto requestDto) {
		return null;
	}
	
	@PatchMapping("/patch")
	public ResponseDto patch(@RequestBody RequestDto requestDto) {
		return null;
	}
	
	@DeleteMapping("/delete")
	public ResponseDto delete() {
		return null;
	}
	
	@GetMapping("/requestParam")
	public ResponseDto requestParam(@RequestParam("parameter") String parameter) {
		return null;
	}
}
