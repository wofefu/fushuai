package fushuai.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * date转成String
	 * @param date
	 * @param patten
	 * @return
	 */
	public static String toDateString(Date date,String patten){
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		return sdf.format(date);
	}
	
	/**
	 * String转成date
	 * @param dateStr
	 * @param patten
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String dateStr,String patten){
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * String转String
	 * @param dateStr
	 * @param oldPatten
	 * @param newPatten
	 * @return
	 * @throws ParseException
	 */
	public static String strToString(String dateStr,String oldPatten,String newPatten) {
		Date date = toDate(dateStr,oldPatten);
		return toDateString(date, newPatten);
	}
	
	/**
	 * String转Timestamp
	 */
	public static Timestamp toTimestamp(String dateStr,String patten){
		Date date = toDate(dateStr, patten);
		return new Timestamp(date.getTime());
	}
	

}
