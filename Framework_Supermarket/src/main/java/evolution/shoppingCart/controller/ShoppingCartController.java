package evolution.shoppingCart.controller;

import java.io.File;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import evolution.FileUtil;
import evolution.shoppingCart.controller.dto.ShoppingCart;
import evolution.shoppingCart.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService = new ShoppingCartService();
	
	@PostMapping("/shop")
	public void shop(@RequestBody ShoppingCart shoppingCart) {
		String sourceProjectPath = System.getProperty("user.dir");
		String sourceBasePackagePath = sourceProjectPath + "/src/main/java/evolution";
		String targetProjectPath = shoppingCart.getTargetProjectPath();
		String evolution = "evolution";
		String basePackageName = shoppingCart.getBasePackageName();
		String javaPath = "/src/main/java/";
		if (!shoppingCartService.isRequired(shoppingCart.getSpringBoot())) {
			return;
		} else if (shoppingCartService.isRequired(shoppingCart.getSpringMvc())) {
			FileUtil.copy(sourceBasePackagePath + "/controller", FileUtil.createFolders(targetProjectPath, javaPath, basePackageName, "/controller"), evolution, basePackageName);
		}
		FileUtil.copy(new File(sourceProjectPath + "/pom.xml"), new File(targetProjectPath + "/pom.xml"));
	}
	
	@Test
	public void test() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setTargetProjectPath("/home/chen/Desktop/Buffer/Project");
		shoppingCart.setBasePackageName("com.evolution");
		shoppingCart.setSpringBoot(true);
		shoppingCart.setSpringMvc(true);
		shop(shoppingCart);
	}
}
