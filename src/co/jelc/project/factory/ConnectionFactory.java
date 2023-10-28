package co.jelc.project.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class ConnectionFactory {
	
	private DataSource datasource;
	
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimezone=UTC");
		//pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("1004");
		pooledDataSource.setMaxPoolSize(10);
		
		this.datasource = pooledDataSource;
	}
	
	public Connection recoverConnection() {
		try {
			return this.datasource.getConnection();
		}catch(SQLException e) {
			System.out.println("Connection Failed");
			throw new RuntimeException(e);
		}
	}

}
