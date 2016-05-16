package facade;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	private static final String connectionClass = "org.postgresql.Driver";
	private static final String connectionDriverUrl = "jdbc:postgresql://localhost:5432/vava";
	private static final String connectionLogin = "postgres";
	private static final String connectionPW = "Pg123456";
	
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
    
    public void addFlight(UserFlight uf, Flight f, User u) {
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
    
    public void addRec(int userID, Flight f) {
    	 Connection con = null;
    	 PreparedStatement ps = null, p1=null, select=null;
    	 Integer f_id = null;
		try {
			Class.forName(connectionClass);
			con = DriverManager.getConnection(connectionDriverUrl,connectionLogin,connectionPW);
			con.setAutoCommit(false);
			/*select = con.prepareStatement("select * from let");*/
			/*ResultSet rs = select.executeQuery();*/
			
			/*String id = null;
			if (rs.next()) {
				id = rs.getString("f_id");
			}
			System.out.println("Server FLIGHT ID: " + id);*/
			Integer id = null;
		    p1 = con.prepareStatement
					("insert into let(flight_from, flight_to, flight_number, flight_date) "
							+ "values(?,?,?,?)");
			p1.setString(1, f.getAirportFrom());
			p1.setString(2, f.getAirportTo());
			p1.setString(3, f.getFlightNumber());
			p1.setString(4, f.getDate());
			int i = p1.executeUpdate();
			System.out.println("SERVER: rows affected: " + i);
			select = con.prepareStatement("select currval('let_f_id_seq')");
			ResultSet rs= select.executeQuery();
			
			if (rs.next()) 
				id = Integer.valueOf(rs.getString("currval"));
			System.out.println("ID: " + id);
			/*select = con.prepareStatement("select f_id from let where flight_from = ?"
					+ "	and flight_to=? and flight_date=? and flight_number=? returning f_id");
			select.setString(1, f.getAirportFrom());
			select.setString(2, f.getAirportTo());
			select.setString(3, f.getFlightNumber());
			select.setString(4, f.getDate());
			
			ResultSet rs = select.executeQuery();*/
			
			
			/*if (rs.next()) {
				id = rs.getString("f_id");
			}*/
			ps = con.prepareStatement
			        ("insert into pouzivatel_let(userko_u_id,flight_f_id) values(?,?)");
			
			ps.setInt(1, userID);
			ps.setInt(2, id);
			ps.executeUpdate();
			con.commit();
			        
		} catch (Exception e) {
	    	  
	          if (con != null) {
	              try {
	                  System.err.println("Transaction is being rolled back");
	                  con.rollback();
	              } catch(SQLException excep) {
	                 
	              }
	            }
	          }
	      
	      try {
			ps.close();
			p1.close();
			select.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    
}
