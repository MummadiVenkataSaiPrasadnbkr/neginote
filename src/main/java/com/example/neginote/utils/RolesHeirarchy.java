package com.example.neginote.utils;

import java.util.HashMap;
import java.util.Map;

public class RolesHeirarchy {
	
	public static final Map<String, Integer> ROLE_HIERARCHY = new HashMap<>();
	static {
		
		ROLE_HIERARCHY.put("correspondent", 0);
	    ROLE_HIERARCHY.put("principal", 1);
	    ROLE_HIERARCHY.put("hod", 2);
	    ROLE_HIERARCHY.put("placementofficer", 2); // same level as HOD
	    ROLE_HIERARCHY.put("lecturer", 3);
	    ROLE_HIERARCHY.put("student", 4);
		
	}
	

}
