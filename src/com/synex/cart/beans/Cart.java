package com.synex.cart.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart implements Serializable {

	private static Cart cart = createCartInstance();;
	private String CartId;
	private List<Item> items = new ArrayList<>();

	private Cart() {

		CartId = UUID.randomUUID().toString();

	}

	private static Cart createCartInstance() {
		cart = new Cart();
		return cart;
	}

	public String getCartId() {
		return CartId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public static Cart getCartInstance() {
		return cart;
	}

}
