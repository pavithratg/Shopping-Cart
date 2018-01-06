package com.synex.service;

import com.synex.cart.beans.Item;
import com.synex.cart.dao.IItemDao;
import com.synex.cart.dao.ItemDao;

public class ItemService implements IItemService {
	
	/* (non-Javadoc)
	 * @see com.synex.service.IItemService#getItemById(int)
	 */
	@Override
	public Item getItemById(int id) {
		IItemDao itemDao = new ItemDao();
		Item item = itemDao.getItemById(id);
		return item;
	}

}
