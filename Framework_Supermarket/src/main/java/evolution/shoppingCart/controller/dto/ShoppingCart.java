package evolution.shoppingCart.controller.dto;

import lombok.Data;

@Data
public class ShoppingCart {
	private String targetProjectPath;
	private String basePackageName;
	private Boolean springBoot;
	private Boolean springMvc;
	private Boolean myBatis;
	
	public String getBasePackageName() {
		return basePackageName;
	}
	
	public Boolean getMyBatis() {
		return myBatis;
	}
	
	public Boolean getSpringBoot() {
		return springBoot;
	}
	
	public Boolean getSpringMvc() {
		return springMvc;
	}
	
	public String getTargetProjectPath() {
		return targetProjectPath;
	}
	
	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}
	
	public void setMyBatis(Boolean myBatis) {
		this.myBatis = myBatis;
	}
	
	public void setSpringBoot(Boolean springBoot) {
		this.springBoot = springBoot;
	}
	
	public void setSpringMvc(Boolean springMvc) {
		this.springMvc = springMvc;
	}
	
	public void setTargetProjectPath(String targetProjectPath) {
		this.targetProjectPath = targetProjectPath;
	}	
	
	@Override
	public String toString() {
		return "ShoppingCart [targetProjectPath=" + targetProjectPath + ", basePackageName=" + basePackageName
				+ ", springBoot=" + springBoot + ", springMvc=" + springMvc + ", myBatis=" + myBatis + "]";
	}
}
