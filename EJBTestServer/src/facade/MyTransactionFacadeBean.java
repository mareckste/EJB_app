package facade;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import entity.Flight;
import entity.User;
import entity.UserFlight;
import remote.MyTransactionFacadeBeanRemote;

/**
 * Session Bean implementation class TransactionFacadeBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyTransactionFacadeBean implements MyTransactionFacadeBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext context;
	
    public boolean createOrUpdateUser(User u) {
    	UserTransaction ut = context.getUserTransaction();
    	
    	try {
    		ut.begin();
    		em.persist(u);
    		
    		ut.commit();
    	} catch(Exception e) {
    		try {
				ut.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
    	}
    	
    	return false;
    }
    
    public void addFlight(UserFlight u) {
    	UserTransaction ut = context.getUserTransaction();
    	
    	try {
    		ut.begin();
    		em.persist(u);
    		ut.commit();
    	} catch(Exception e) {
    		try {
				ut.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
    	}
    }
    
}
