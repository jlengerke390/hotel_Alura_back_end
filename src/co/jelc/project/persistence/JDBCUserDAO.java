package co.jelc.project.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUserDAO implements UserDao {
	
	private final Connection con;

	public JDBCUserDAO(Connection con) {
		this.con = con;
		
	}
	@Override
	public boolean validateByCredentials(String username, String password){
		boolean credentialIsValid = false;
		String sql = "SELECT * FROM user WHERE name= ? AND password= ?";
		try{
			final PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
		
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				credentialIsValid = true;
			}			
		} catch (SQLException e) {
			throw new RuntimeException("Error while processing the result set: " + e.getMessage(), e );
		}finally{
			if(credentialIsValid) {				
				try {	
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException("Error while trying to close the session: " + e.getMessage(), e);
				}
			}
		}	
		return credentialIsValid;
	}
	
}
