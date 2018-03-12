package com.kat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.dao.ItemDAO;
import com.kat.model.Item;

@Service
public class ItemService implements IItemService {
	
	@Autowired
	private ItemDAO itemDAO;

	@Override
	public Item getItemByID(int id) {
		return itemDAO.getItemByID(id);
	}

}
