package com.synex.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.synex.cart.beans.Cart;
import com.synex.cart.beans.Item;

public class CartDao implements ICartDao {

	Cart cart = Cart.getCartInstance();

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cart-app", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synex.cart.dao.ICartDao#addItem(com.synex.cart.beans.Item)
	 */
	@Override
	public void addItem(Item item) {

		// int status = 0;
		// try {
		// Connection con = CartDao.getConnection();
		// PreparedStatement ps = con.prepareStatement("insert into
		// cart(item_id) values (?)");
		// ps.setInt(0, item.getItemId());
		// status = ps.executeUpdate();
		//
		// con.close();
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }

		cart.getItems().add(item);

	}

}
