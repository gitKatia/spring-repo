package com.kat.dao;

import java.util.List;

import com.kat.model.Server;

public interface IServerDAO {
	
	boolean addServer(Server server);
	boolean editServer(String name, String description);
	boolean deleteServer(String name);
	List<Server> listServers();
	int countServers();
	Server getServerByName(String name);

}
