package test;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		Context ctx = new InitialContext();
		TestBeanRemote remote =  (TestBeanRemote)ctx.lookup("ejb:EJBTestEAR/EJBTestServer//TestBean!test.TestBeanRemote");
		
		System.out.println("5 + 6 = "+ remote.add(5, 6));
		System.out.println("7 + 7 = "+ remote.add(7, 7));
	}
}
