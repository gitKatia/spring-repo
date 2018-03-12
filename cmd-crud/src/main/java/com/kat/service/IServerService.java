package com.kat.service;

import java.util.List;

import com.kat.model.Server;

public interface IServerService {
	
	boolean addServer(String name, String description);
	boolean editServer(String name, String description);
	boolean deleteServer(String name);
	List<Server> listServers();
	int countServers();
	Server filterServersByName(String name);

}
