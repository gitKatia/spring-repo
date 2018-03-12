package com.kat.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.kat.model.Command;
import com.kat.model.Server;
import com.kat.service.IServerService;
import com.mysql.jdbc.StringUtils;

public class Main {

	@Parameter(names = "-command", description = "Available commands:\n"
			+ "1.help:use \"-command help\" to get help on usage\n"
			+ "2.add:use \"-command add -name <yourServerName> -description <yourServerDescription>\" to add a new server\n"
			+ "3.edit:use \"-command edit -name <yourServerName> -description <yourServerDescription>\" to edit an existing server\n"
			+ "4.delete:use \"-command delete -name <yourServerName>\" to delete an existing server\n"
			+ "5.list:use \"-command list\" to list all existing servers\n"
			+ "6.filter:use \"-command filter -name <yourServerName>\" to retrieve a server by name\n"
			+ "7.count:use \"-command count\" to retrieve the number of existing servers\n", required = true)

	private static String command;

	@Parameter(names = "-name", description = "Server name; used in add, edit, delete,filter commands.")
	private static String name;

	@Parameter(names = "-description", description = "Server description; used in add, edit commands.")
	private static String description;

	public static void main(String[] args) {

		Main main = new Main();

		try {
			JCommander cmd = new JCommander(main);
			cmd.parse(args);
			System.out.println(command);
			if (validateArgs()) {
				command = command.toLowerCase();
				main.run(cmd);
			} else {
				JCommander.getConsole().println("Cannot validate arguments: ");
				cmd.usage();
				System.exit(1);
			}
		} catch (Exception exc) {
			JCommander.getConsole().println("Cannot parse arguments: " + exc.getMessage());
			System.exit(1);
		}

	}

	public static boolean validateArgs() {

		if (Command.stringValues().contains(command.toLowerCase())) {

			if (command.equalsIgnoreCase("add") || command.equalsIgnoreCase("edit")) {
				return !(StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(description));
			} else if (command.equalsIgnoreCase("delete") || command.equalsIgnoreCase("filter")) {
				return !(StringUtils.isNullOrEmpty(name));
			}

			return true;
		} else {
			return false;
		}

	}

	public void run(JCommander cmd) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		IServerService service = (IServerService) context.getBean("serverService");
		performAction(service, cmd);

	}

	public static void performAction(IServerService service, JCommander cmd) {

		switch (command) {

		case "help":
			cmd.usage();
			break;
		case "add":
			boolean addServer = service.addServer(name, description);
			if (addServer) {
				System.out.println("Server added successfully.");
			} else {
				System.out.println("Add Server operation failed.");
			}
			break;
		case "edit":
			boolean editServer = service.editServer(name, description);
			if (editServer) {
				System.out.println("Server edited successfully.");
			} else {
				System.out.println("Edit Server operation failed.");
			}
			break;
		case "delete":
			boolean deleteServer = service.deleteServer(name);
			if (deleteServer) {
				System.out.println("Server deleted successfully.");
			} else {
				System.out.println("Delete Server operation failed.");
			}
			break;
		case "filter":
			Server server = service.filterServersByName(name);
			if (server != null) {
				System.out.println(server);
			} else {
				System.out.println("Not found");
			}
			break;
		case "count":
			int count = service.countServers();
			System.out.println("The number of servers is currently " + count);
			break;
		case "list":
			List<Server> servers = service.listServers();
			if (servers != null && !servers.isEmpty()) {
				for (Server s : servers) {
					System.out.println(s);
				}
			} else {
				System.out.println("No servers found.");
			}
			break;
		default:
			System.out.println("Wrong command.");
		}
	}

}
