package com.kat.model;

import java.util.ArrayList;
import java.util.List;

public enum Command {
	
	HELP("help"),
    ADD("add"),
    EDIT("edit"),
    DELETE("delete"),
    LIST("list"),
    FILTER("filter"), 
    COUNT("count");

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String command() {
        return command;
    }
    
    public static List<String> stringValues(){
    	
    	List<String> stringValues = new ArrayList<String>();
    	
    	for(Command cmd:Command.values()){
    		stringValues.add(cmd.command());
    	}
    	
    	return stringValues;
    }

}
