package unicluster.unip.br.aps8.utils;

import java.sql.Date;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Diego on 22/10/2017.
 */

public class Utils {
	public static Date parseDate(String date) {
		try {
			return (Date) new SimpleDateFormat("yy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String stripAccents(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
