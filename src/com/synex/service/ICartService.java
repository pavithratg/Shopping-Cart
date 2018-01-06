package com.synex.service;

import com.synex.cart.beans.Cart;
import com.synex.cart.beans.Item;

public interface ICartService {

	void addItem(Item item);

	Cart deserializeCart();

}