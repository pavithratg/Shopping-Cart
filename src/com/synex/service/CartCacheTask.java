package com.synex.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.synex.cart.beans.Cart;

public class CartCacheTask implements Runnable {

	@Override
	public void run() {
		Cart cart = Cart.getCartInstance();

		// serialization
		try {
			FileOutputStream fs = new FileOutputStream("temp.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(cart);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
