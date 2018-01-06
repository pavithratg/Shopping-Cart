package com.synex.cart.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.synex.cart.beans.Cart;
import com.synex.cart.beans.Item;
import com.synex.service.CartCacheTask;
import com.synex.service.CartService;
import com.synex.service.ICartService;
import com.synex.service.IItemService;
import com.synex.service.ItemService;

public class CartApp {

	public static void main(String[] args) {

		List<String> items = new ArrayList<>();

		Cart cart = Cart.getCartInstance();

		items.add("1 - mango");
		items.add("2 - apple");
		items.add("3 - orange");

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome To Goel Store!");

		ICartService cartService = new CartService();
		IItemService itemService = new ItemService();
		Item item = new Item();

		while (true) {

			try {
				System.out.println(items);
				System.out.println("Please enter itemId: ");
				int itemId = scan.nextInt();

				item = itemService.getItemById(itemId);
				cartService.addItem(item);

				System.out.println("to add more items enter 1 or 0 to exit");

				int status = scan.nextInt();
				System.out.println(status);

				//throw new Exception();

				 if (status == 0) {
				
				 System.out.println("Your Cart: ");
				 System.out.println(cart.getItems());
				
				 double total = 0;
				
				 for (Item it : cart.getItems()) {
				 total += it.getItemPrice();
				 }
				 System.out.println("Total: " + total);
				
				 break;
				 }

			} catch (Exception e) {

				// in case of an exception serializing the object to a file.
				CartCacheTask target = new CartCacheTask();
				Thread t = new Thread(target);
				t.start();
				try {
					t.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				// after exception restoring the cart using deserialization.
				cart = cartService.deserializeCart();
				System.out.println(cart);

				double total = 0;
				 for (Item it : cart.getItems()) {
				 total += it.getItemPrice();
				 }
				System.out.println("Total: " + total);
			}

		}

	}

}
