package com.kat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kat.dao.IServerDAO;
import com.kat.model.Server;


@Component
public class ServerService implements IServerService {

	@Autowired
	IServerDAO serverDAO;

	@Override
	public boolean addServer(String name, String description) {
		
		Server server = new Server();
		server.setName(name);
		server.setDescription(description);
		return serverDAO.addServer(server);
		
	}

	@Override
	public boolean editServer(String name, String description) {
		
		Server server = new Server();
		server.setName(name);
		server.setDescription(description);
		return serverDAO.editServer(name, description);
	}

	@Override
	public boolean deleteServer(String name) {
		
		return serverDAO.deleteServer(name);
	}

	@Override
	public List<Server> listServers() {
		
		return serverDAO.listServers();
	}

	@Override
	public int countServers() {
		
		return serverDAO.countServers();
	}

	@Override
	public Server filterServersByName(String name) {
		
		return serverDAO.getServerByName(name);
		
	}

}
