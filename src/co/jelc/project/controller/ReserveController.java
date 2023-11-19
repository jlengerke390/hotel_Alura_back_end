package co.jelc.project.controller;

import co.jelc.project.factory.ConnectionFactory;
import co.jelc.project.models.Reserve;
import co.jelc.project.persistence.JDBCReserveDAO;

public class ReserveController {
	
	private JDBCReserveDAO jdbcReserveDAO;
	
	public ReserveController() {
		this.jdbcReserveDAO = new JDBCReserveDAO(new ConnectionFactory().recoverConnection());
	}
	
	public void save(Reserve reserve) {
		jdbcReserveDAO.save(reserve);
	}

}
