package com.kat.dao;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kat.model.Item;

@Repository
public class ItemDAO implements IItemDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session session;
	
	@PostConstruct
	public void init(){
		try {
		    this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    this.session = sessionFactory.openSession();
		}
	}

	@Override
	public Item getItemByID(int id) {
		return (Item)(session.load(Item.class, id));
	}

}
