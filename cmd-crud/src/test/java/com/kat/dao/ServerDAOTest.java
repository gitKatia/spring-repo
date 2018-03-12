package com.kat.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kat.model.Server;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-context.xml")
@Transactional
public class ServerDAOTest {

	@Resource(name = "sessionFactory")
    private SessionFactory exampleSessionFactory;

    @Resource(name = "serverDAO")
	private ServerDAO serverDAO;
	
	@Test
	public void testAddServer() {
		
		Server server = new Server();
		server.setName("server1");
		server.setDescription("Description");
		boolean result = serverDAO.addServer(server);
		assertFalse(result);
	}

	@Test
	public void testEditServer() {
		
		boolean edited = serverDAO.editServer("server3", "Machine 3 Europa");
		assertTrue(edited);
		
	}

	@Test
	public void testDeleteServer() {
		
		boolean result = serverDAO.deleteServer("server2");
		assertTrue(result);
	}

	@Test
	public void testListServers() {
		
		List<Server> result = serverDAO.listServers();
		assertTrue(result.size() >= 3);
	}

	@Test
	public void testCountServers() {
		
		int result = serverDAO.countServers();
		assertTrue(result >= 3);
	}

	@Test
	public void testGetServerByName() {
		
		Server result = serverDAO.getServerByName("server4");
		assertEquals("Machine 4", result.getDescription());
	}


}
