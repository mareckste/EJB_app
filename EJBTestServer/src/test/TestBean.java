package test;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
public class TestBean implements TestBeanRemote {

    public int add(int i1, int i2) {
    	return i1 + i2;
    }

}
