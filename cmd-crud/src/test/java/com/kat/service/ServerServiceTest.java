package com.kat.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.kat.dao.ServerDAO;
import com.kat.model.Server;

public class ServerServiceTest {

	@Mock
    ServerDAO serverDAO;

    @InjectMocks
	private ServerService serverService;
    
    private Server server;
    private List<Server> servers;
    private String name;
    private String description;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		name = "name";
		description = "description";
		
		server = new Server();
		server.setName(name);
		server.setDescription(description);
		
		servers = Arrays.asList(server);
		
	}

	@Test
	public void testAddServer() {
		
		when(serverDAO.addServer(any(Server.class))).thenReturn(true);
		boolean result = serverService.addServer(name, description);
		verify(serverDAO).addServer(any(Server.class));
		assertTrue(result);
	}

	@Test
	public void testEditServer() {
		
		when(serverDAO.editServer(any(String.class), any(String.class))).thenReturn(true);
		boolean result = serverService.editServer(name, description);
		verify(serverDAO).editServer(any(String.class), any(String.class));
		assertTrue(result);
	}

	@Test
	public void testDeleteServer() {
		
		when(serverDAO.deleteServer(any(String.class))).thenReturn(false);
		boolean result = serverService.deleteServer(name);
		verify(serverDAO).deleteServer(any(String.class));
		assertFalse(result);
	}

	@Test
	public void testListServers() {
		
		when(serverDAO.listServers()).thenReturn(servers);
		List<Server> result = serverService.listServers();
		verify(serverDAO).listServers();
		assertEquals(1, result.size());
		
	}

	@Test
	public void testCountServers() {
		
		when(serverDAO.countServers()).thenReturn(5);
		int result = serverService.countServers();
		verify(serverDAO).countServers();
		assertEquals(5, result);
	}

	@Test
	public void testFilterServersByName() {
		
		when(serverDAO.getServerByName(any(String.class))).thenReturn(server);
		Server result = serverService.filterServersByName(name);
		verify(serverDAO).getServerByName(any(String.class));
		assertEquals(description, result.getDescription());
	}

}
