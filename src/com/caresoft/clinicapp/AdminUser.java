package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {

	public AdminUser(Integer id, String role) {
//	public AdminUser(Integer id, Integer employeeID, String role) {
		super(id);
		this.employeeID = employeeID;
		this.role = role;
	}
//... imports class definition...
    
		// Inside class:
	    private Integer employeeID;
	    private String role;
	    private ArrayList<String> securityIncidents = new ArrayList<String>() ;
    
    
//    AdminUser adminUser = new AdminUser(null, null);
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
	    public void newIncident(String notes) {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
	            new Date(), this.id, notes
	        );
	        securityIncidents.add(report);
	    }
	    
	    public void authIncident() {
	        String report = String.format(
	            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
	            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
	        );
	        securityIncidents.add(report);
	    }
		
	    
		
		@Override
		public ArrayList<String> reportSecurityIncidents() {
			// TODO Auto-generated method stub
			return this.securityIncidents;
		}
		
		@Override
		public boolean assignPin(int pin) {
			// TODO Auto-generated method stub
			if (String.valueOf(pin).length() >= 6) {
				return true;
			} 
			return false;
							
		}
			
		@Override
		public boolean accessAuthorized(Integer confirmedAuthID) {
			// TODO Auto-generated method stub
			if (confirmedAuthID != this.id) {
				this.authIncident();
				return false;
			}
				return true;
			
		}
	    
	    // TO DO: Setters & Getters
		public Integer getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(Integer employeeID) {
			this.employeeID = employeeID;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public ArrayList<String> getSecurityIncidents() {
			return securityIncidents;
		}
		public void setSecurityIncidents(ArrayList<String> securityIncidents) {
			this.securityIncidents = securityIncidents;
		}
		

}

