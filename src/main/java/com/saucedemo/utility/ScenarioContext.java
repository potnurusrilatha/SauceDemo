package com.saucedemo.utility;

import Enums.Context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> scenarioContext;

    public ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    public Object getContext(Context key) {
        return scenarioContext.get(key.toString());
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }

	public boolean isFailed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void attach(byte[] screenshot, String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}
