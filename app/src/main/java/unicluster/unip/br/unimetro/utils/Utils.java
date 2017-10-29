package unicluster.unip.br.unimetro.utils;

import java.text.Normalizer;
import java.util.Date;

/**
 * Created by Diego on 22/10/2017.
 */

public class Utils {
	public static Date parseDate(String date) {
		return new Date(Long.parseLong(date));
	}

	public static String stripAccents(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
