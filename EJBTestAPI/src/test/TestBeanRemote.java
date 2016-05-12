package test;

import javax.ejb.Remote;

@Remote
public interface TestBeanRemote {
	public String add(int i1, int i2);
}
