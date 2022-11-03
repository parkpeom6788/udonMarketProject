package org.kosta.udonmarket.controller;

public class HandlerMapping {

	private static HandlerMapping instnace = new HandlerMapping();
	private HandlerMapping() {	}
	public static HandlerMapping getInstance() {
		return instnace;
	}
	
	public Controller create(String controllerName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		StringBuilder classInfo = new StringBuilder(this.getClass().getPackage().getName()).append(".").append(controllerName);
		return (Controller) Class.forName(classInfo.toString()).newInstance();
	}
	
}
