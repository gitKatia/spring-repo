package com.kat.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kat.model.Server;

@Repository
public class ServerDAO implements IServerDAO {

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
	public boolean addServer(Server server) {
		
		Server existingServer = getServerByName(server.getName());
		if(existingServer == null) {
			session.save(server);
			return true;
		} else {
			System.err.println("A server with the same name already exists.");
			return false;
		}
	}

	@Override
	public boolean editServer(String name, String description) {
		
		Server server = getServerByName(name);
		if(server != null){
			String hql = "update Server s set s.description =:description where s.name =:name";
			Query q = session.createQuery(hql).setParameter("name", name).setParameter("description", description);
			q.executeUpdate();
			return true;
		} else {
			System.err.println("Could not find any server with this name.");
			return false;
		}
	}

	@Override
	public boolean deleteServer(String name) {
		
		Server server = getServerByName(name);
		if(server != null){
			String hql = "delete from Server s where s.name =:name";
			Query q = session.createQuery(hql).setParameter("name", name);
			q.executeUpdate();
			//session.delete(server);
			return true;
		} else {
			System.err.println("Could not find any server with this name.");
			return false;
		}
	}

	@Override
	public List<Server> listServers() {
		
		@SuppressWarnings("unchecked")
		List<Server> servers = (List<Server>) session.createCriteria(Server.class).addOrder(Order.asc("name")).list();
		return servers;
	}

	@Override
	public int countServers() {
		
		String hql = "select count(s.id) from Server s";
		Query query = session.createQuery(hql);
		return ((Number) query.uniqueResult()).intValue();
	}
	
	@Override
	public Server getServerByName(String name) {
		
		String hql = "from Server s where s.name = :name";
		return (Server)session.createQuery(hql)
				.setParameter("name", name).uniqueResult();
		
	}

}
