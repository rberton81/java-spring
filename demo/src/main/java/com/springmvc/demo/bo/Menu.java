package com.springmvc.demo.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class Menu {
	
	private Map<String, MenuElement> menuElements = new LinkedHashMap<String, MenuElement>();
	
	public void addAll(MenuElement ... menuElements) {
		for(MenuElement menuElement : menuElements) {
			this.menuElements.put(menuElement.getMenuTitle(), menuElement);
		}
	}

	public Collection<MenuElement> getMenuElements() {
		return menuElements.values();
	}

	public void setActive(String menuName) {
		this.menuElements.get(menuName).setActive();
	}
	
	public void unactiveAll()
	{
		for(MenuElement menuElement : this.getMenuElements()) {
			menuElement.setUnactive();
		}
	}
	
}