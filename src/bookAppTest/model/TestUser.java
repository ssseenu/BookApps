package bookAppTest.model;

import bookApp.model.User;

public class TestUser {
			
			public static void main(String[] args) {
				
				User user1 = new User();
				user1.setId(101);
				user1.setName("Seenu");
				user1.setUserName("seenusssg");
				user1.setPassword("sssg");
				user1.setMobileNo(9876543210l);
				user1.setEmailId("sssg@gmail.com");
				user1.setActive("A");
				user1.setRoleId(101);
				
				System.out.println("ID = " + user1.getId());
				System.out.println("Name = " + user1.getName());
				System.out.println("UserName = " + user1.getUserName());
				System.out.println("Password = " + user1.getPassword());
				System.out.println("Mobile Number = " + user1.getMobileNo());
				System.out.println("Email ID = " + user1.getEmailId());
				System.out.println("Active = " + user1.getActive());
				System.out.println("Role ID = " + user1.getRoleId());
				
			}

}
