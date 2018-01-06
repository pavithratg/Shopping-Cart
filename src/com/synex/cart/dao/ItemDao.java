package com.synex.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.synex.cart.beans.Item;

public class ItemDao implements IItemDao {

	List<Item> items = new ArrayList<>();

	{
		Item i1 = new Item(1, "Mango", 10);
		Item i2 = new Item(2, "Apple", 20);
		Item i3 = new Item(3, "Orange", 30);

		items.add(i1);
		items.add(i2);
		items.add(i3);

	}

	/* (non-Javadoc)
	 * @see com.synex.cart.dao.IItemDao#getItemById(int)
	 */
	@Override
	public Item getItemById(int id) {
		Item i = new Item();

//		try {
//			Connection con = CartDao.getConnection();
//			PreparedStatement ps = con.prepareStatement("select * from item where id=?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				i.setItemId(rs.getInt(1));
//
//			}
//			con.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

		i = items.get(id);
		return i;
	}

}
