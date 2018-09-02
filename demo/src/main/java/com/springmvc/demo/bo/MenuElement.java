package com.springmvc.demo.bo;

public class MenuElement {
	
	private String menuTitle;
	
	private String menuClass;

	private String hRef;
	
	private String active;
	
	public MenuElement(String menuTitle, String menuClass, String hRef, String active) {
		this.menuTitle = menuTitle;
		this.menuClass = menuClass;
		this.hRef = hRef;
		this.active = active;
	}

	public void setUnactive() {
		this.active = "unactive";
	}

	public void setActive() {
		this.active = "active";
	}
	
	
	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}

	public String getHRef() {
		return hRef;
	}

	public void setHRef(String hRef) {
		this.hRef = hRef;
	}

	public String getActive() {
		return active;
	}

	
	
	
}