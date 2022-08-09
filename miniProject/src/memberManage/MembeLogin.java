package memberManage;

import java.util.Scanner;

import loginManage.Customer;

public class MembeLogin {

	Scanner sc = new Scanner(System.in);
	
	public void Login() {
		
		Customer customer = new Customer();
		
		System.out.println("ID입력: ");
		String id = sc.nextLine();
		System.out.println("PW입력: ");
		String pw = sc.nextLine();
		
		
	}
}
