package Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Customer Management */
public class CustomerManagement implements PublicConstants {
	private ArrayList<Customer> customerList;
	Scanner sc;
	private String path = "C:\\Users\\chois\\Desktop\\";

	CustomerManagement(ArrayList<Customer> customerList) {
		this.customerList = customerList;
		sc = new Scanner(System.in);
	}

	/* ## 0. �� ��� ��� */
	public void printCustomerList() {
		if (customerList.size() == 0) System.out.println(NO_EXIST_CUSTOMER_MSG);
		else {
			for (Customer customer : this.customerList)
				System.out.println(customer.getCustomerNo() + "\t" + customer.getName() + "\t" + customer.getGender()
						+ "\t" + customer.getPhoneNum() + "\t" + customer.getPoint());
		}
	}

	/* 1. �ű� �� ��� */
	
	public Customer registerNewCustomer() {
		Customer newbie = new Customer();
		System.out.print(">> �� ��ȣ : ");
		newbie.setCustomerNo(sc.next());
		System.out.print(">> �ڵ��� ��ȣ : ");
		newbie.setPhoneNum(sc.next());
		System.out.print(">> �� �̸� : ");
		newbie.setName(sc.next());
		System.out.print(">> �� ���� : ");
		newbie.setGender(sc.next());
		System.out.print(">> �� ����Ʈ : 0��\n");
		newbie.setPoint(0);
		System.out.print(">> �� ��й�ȣ : ");
		newbie.setPassword(sc.next());
		try {
			FileWriter fw = new FileWriter(path + "customer.txt",true);
			fw.write(newbie.getCustomerNo()+"/");
			fw.write(newbie.getPhoneNum()+"/");
			fw.write(newbie.getName()+"/");
			fw.write(newbie.getGender()+"/");
			fw.write(newbie.getPoint()+"\n");
			fw.close();
			System.out.println("����Ϸ�");
		} catch (Exception e) {
			System.out.println("���ܹ߻�");
		}
		return newbie;
		
	}

	/* 2. �� ���� ���� */
	
	public void modifyCustomerInfo() {
		customerList.set(this.searchCustomerList(MODIFY_CUSTOMER_MSG), this.registerNewCustomer());
		
	}
	

	/* 3. �� ����Ʈ ��ȸ */
	
	public void lookupCustomerPoint() {
		Customer customer = this.customerList.get(this.searchCustomerList(LOOKUP_CUSTOMER_MSG));
		System.out.println(customer.getName() + "���� ���� �ܿ� ����Ʈ�� " + customer.getPoint() + " ����Ʈ �Դϴ�.");
	}
	
	/* 4. �α��� */
	
	public void loginCustomer() {
		String password;
		Customer customer = this.customerList.get(this.searchCustomerList(LOGIN_CUSTOMER_MSG));
		while(true) {
			System.out.println("��й�ȣ �Է�: ");
			password = sc.next();
			if(customer.getPassword().equals(password)) {
				System.out.println("�α��� ����");
				System.out.println("������ ������ " + customer.getCustomerNo() + "\t" + customer.getName() + "\t" + customer.getGender()
				+ "\t" + customer.getPhoneNum() + "\t" + customer.getPoint() +"�Դϴ�.\n");
				break;
			}
			else
				System.out.println("��й�ȣ�� �ٸ��ϴ�. �ٽ� �Է��� �ּ���");
		}
	}
	
	/* 4. �� ���� */
	
	public void deleteCustomer() {
		this.customerList.remove(this.searchCustomerList(DELETE_CUSTOMER_MSG));
	}
	
	/* �� ����Ʈ���� �� ������ ã�� �޼��� */
	
	public int searchCustomerList(String message) {
		String customerNo;
		while (true) {
			System.out.print(message);
			customerNo = sc.next();
			for (Customer customer : this.customerList) {
				if (customer.getCustomerNo().equals(customerNo))
					return this.customerList.indexOf(customer);
			}
			System.out.println(INVALID_CUSTOMER_NO_MSG);

		}
		
	}
	

	/* Get & Set */

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	/* Get & Set */
}
