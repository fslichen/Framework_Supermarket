package evolution.shoppingCart.controller.dto;

import lombok.Data;

@Data
public class ShoppingCart {
	private Boolean springBoot;
	private Boolean springMvc;	
	private String targetFolderBasePath;
	private String packageName;
}
