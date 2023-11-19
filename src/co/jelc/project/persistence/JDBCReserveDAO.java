package co.jelc.project.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import co.jelc.project.models.Reserve;
import co.jelc.project.utils.StringToDateConverter;

public class JDBCReserveDAO implements ReserveDAO{
	
	private final Connection con;

	public JDBCReserveDAO(Connection con) {
		this.con = con;
		
	}

	@Override
	public void save(Reserve reserve) {
		try(con){
			PreparedStatement statement = con.prepareStatement("INSERT INTO RESERVE"
					+ "(Check_In, Check_out, Value,Payment_method)"
					+ "VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				try {
					sendDataToDataBase(reserve, statement);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
			
			
		}catch(SQLException e) {
			throw new RuntimeException("Error while trying to save the information in data base "+ e.getMessage());
		}
		
	}

	private void sendDataToDataBase(Reserve reserve, PreparedStatement statement) throws SQLException, ParseException {
		
		java.sql.Date sqlCheckIn = StringToDateConverter.toDate(reserve.getCheckIn());
		java.sql.Date sqlCheckOut = StringToDateConverter.toDate(reserve.getCheckOut());
		
		
		statement.setDate(1, sqlCheckIn);
		statement.setDate(2, sqlCheckOut);
		statement.setDouble(3, reserve.getValue());
		statement.setString(4, reserve.getPaymentMethod());
		
		statement.execute();
		
		final ResultSet resultSet = statement.getGeneratedKeys();

		try(resultSet){
			while(resultSet.next()) {
				reserve.setId(resultSet.getInt(1));
				System.out.println(String.format("Fue insertado el producto de ID %s", reserve));
			}
		}
		
		
	}

}
