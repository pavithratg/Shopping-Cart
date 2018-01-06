package com.synex.service;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.synex.cart.beans.Cart;
import com.synex.cart.beans.Item;
import com.synex.cart.dao.CartDao;
import com.synex.cart.dao.ICartDao;

public class CartService implements ICartService {

	Cart cart = Cart.getCartInstance();

	/* (non-Javadoc)
	 * @see com.synex.service.ICartService#addItem(com.synex.cart.beans.Item)
	 */
	@Override
	public void addItem(Item item) {

		ICartDao cartDao = new CartDao();
		cartDao.addItem(item);

	}

	/* (non-Javadoc)
	 * @see com.synex.service.ICartService#deserializeCart()
	 */
	@Override
	public Cart deserializeCart() {
		Cart c = null;
		// deserialization

		try {
			FileInputStream fis = new FileInputStream("temp.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c = (Cart) ois.readObject();
			ois.close();

			System.out.println("Color: " + c.getCartId());
			System.out.println("Name: " + c.getItems());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException eof) {
			// end of file reached, do nothing
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return c;

	}

}
