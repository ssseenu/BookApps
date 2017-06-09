package bookAppTest.model;

import bookApp.model.Role;

public class TestRole {
	
		public static void main(String[] args) {
			Role role1 = new Role();
			
			role1.setId(201);
			role1.setName("Author");
			
			System.out.println("ID = " + role1.getId());
			System.out.println("Role Name = " + role1.getName());
		}
}
