package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import beans.Provider;
import beans.Service;
import beans.User;
import util.ConnectionFactory;

public class ServiceDAO {
	public int iOne(Service service){

        Connection connection = ConnectionFactory.openConnection();			// Connection to the database
        ResultSet rsInserting = null;
        PreparedStatement pstInserting = null;								// PreparedStatement to process the SQL

        int generatedId = -1;												// Generated ID to be returned
        
        try {
            
        	pstInserting = connection.prepareStatement(""
            		+ " INSERT INTO `service`("
            		+ " id_service, name, fee) "
            		+ " VALUES "
            		+ " (?, ?, ?)"
            		, Statement.RETURN_GENERATED_KEYS);						// SQL itself being prepared

        	pstInserting.setInt(1, service.getIdService());					// Replacing each ? with the correct value
        	pstInserting.setString(2, service.getName());
        	pstInserting.setDouble(3, service.getFee());
            pstInserting.executeUpdate();									// SQL being executed
            
            rsInserting = pstInserting.getGeneratedKeys();					// Generated ID being retrieved
            
            if (rsInserting.next()) {
            	generatedId = rsInserting.getInt(1);						// Assigning generated ID to the returning variable
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());								// Error Treatment
            return -1;														// Method finished UNsuccessfully
        }
        
        ConnectionFactory.closeConnection(connection, pstInserting);		// Closing connection to the DBMS
        return generatedId;													// Method finished successfully
	}
	
    public ArrayList<Service> sAll()
    {
        Connection connection = ConnectionFactory.openConnection(); 		// Connection to the database
        ResultSet rsListing = null;											// ResultSet to receive the selected data
        PreparedStatement pstListing = null;								// PreparedStatement to process the SQL
        ArrayList<Service> serviceList = new ArrayList();

        try {
            
        	pstListing = connection.prepareStatement(""
        			+ "SELECT * "
        			+ "FROM service;");										// SQL itself being prepared 
        	
            rsListing = pstListing.executeQuery();							// SQL being executed and results being assigned to ResultSet
            
            if (rsListing.next()) 
            {
            	serviceList.add
            	(
            		new Service
            		(
            			rsListing.getInt("id_service"),
            			rsListing.getString("name"),
            			rsListing.getDouble("fee"),
            			null
            		)
            	);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());									// Error Treatment
            return null;
        }
        
        ConnectionFactory.closeConnection(
        		connection, pstListing, rsListing);								// Closing connection to the DBMS
        
        return serviceList;
    }
}
