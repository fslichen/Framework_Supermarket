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
		if (!shoppingCartService.isRequired(shoppingCart.getSpringBoot())) {
			return;
		} 
		String sourceProjectPath = System.getProperty("user.dir");
		String targetProjectPath = shoppingCart.getTargetProjectPath();
		String sourceBasePackagePath = sourceProjectPath + "/src/main/java/evolution";
		String basePackageName = shoppingCart.getBasePackageName();
		String targetBasePackagePath = FileUtil.createFolders(targetProjectPath, "/src/main/java/", basePackageName);
		String sourceResourcePath = sourceProjectPath + "/src/main/resources";
		String targetResourcePath = FileUtil.createFolders(targetProjectPath, "/src/main/resources");
		FileUtil.copy(new File(sourceBasePackagePath + "/Application.java"), new File(targetBasePackagePath + "/Application.java"));
		FileUtil.copy(new File(sourceResourcePath + "/application.properties"), new File(targetResourcePath + "/application.properties"));
		String evolution = "evolution";
		if (shoppingCartService.isRequired(shoppingCart.getSpringMvc())) {
			FileUtil.copy(sourceBasePackagePath + "/controller", FileUtil.createFolders(targetBasePackagePath, "/controller"), evolution, basePackageName);
		}
		if (shoppingCartService.isRequired(shoppingCart.getMyBatis())) {
			FileUtil.copy(sourceBasePackagePath + "/mybatis", FileUtil.createFolders(targetBasePackagePath, "/mybatis"), evolution, basePackageName);
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
		shoppingCart.setMyBatis(true);
		shop(shoppingCart);
	}
}
