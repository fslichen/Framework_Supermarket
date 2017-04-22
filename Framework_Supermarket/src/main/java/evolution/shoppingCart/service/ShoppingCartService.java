package evolution.shoppingCart.service;

import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {	
	public Boolean isRequired(Boolean object) {
		if (object != null && object == true) {
			return true;
		}
		return false;
	}
}
