package co.jelc.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDateConverter {
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.sql.Date toDate(String date) throws ParseException{
		return new java.sql.Date(SDF.parse(date).getTime());
	}

}
