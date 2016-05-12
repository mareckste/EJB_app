package test;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
public class TestBean implements TestBeanRemote {
	@EJB
	private EJB2Bean bean2; 

    public String add(int i1, int i2) {
    	return bean2.getStr(i1 + i2);
    }

}
