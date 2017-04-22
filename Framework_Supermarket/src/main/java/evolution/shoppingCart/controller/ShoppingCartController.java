package evolution.shoppingCart.controller;

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
	
	@PostMapping("/copy")
	public void copy(@RequestBody ShoppingCart shoppingCart) {
		String sourceFolderBasePath = System.getProperty("user.dir") + "/src/main/java/evolution";
		String targetFolderBasePath = shoppingCart.getTargetFolderBasePath();
		String evolution = "evolution";
		String packageName = shoppingCart.getPackageName();
		if (!shoppingCartService.isRequired(shoppingCart.getSpringBoot())) {
			return;
		} else if (shoppingCartService.isRequired(shoppingCart.getSpringMvc())) {
			FileUtil.copy(sourceFolderBasePath + "/controller", FileUtil.createFolders(targetFolderBasePath, packageName, "/controller"), evolution, packageName);
		}
	}
	
	@Test
	public void test() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setTargetFolderBasePath("/home/chen/Desktop/Buffer/Project");
		shoppingCart.setSpringMvc(true);
		shoppingCart.setPackageName("com.evolution");
		shoppingCart.setSpringBoot(true);
		copy(shoppingCart);
	}
}
