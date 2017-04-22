package evolution.shoppingCart.controller.dto;

import lombok.Data;

@Data
public class ShoppingCart {
	private String targetProjectPath;
	private String basePackageName;
	private Boolean springBoot;
	private Boolean springMvc;	
}
