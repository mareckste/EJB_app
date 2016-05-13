package controll;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import entity.User;
import remote.TestBeanRemote;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		Context ctx = new InitialContext();
		TestBeanRemote remote =  (TestBeanRemote)ctx.lookup("ejb:EJBTestEAR/EJBTestServer//TestBean!remote.TestBeanRemote");
		
		List<User> u = remote.getAllUsers();
		System.out.println(u.size());
		for (User curr: u) {
			System.out.println(curr.getName());
		}
	}
}
