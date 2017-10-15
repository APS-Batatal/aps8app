package unicluster.unip.br.aps8.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LineDAO extends SQLiteOpenHelper {
	public LineDAO(Context context) {
		super(context,"APS8", null, 2);
	}
	
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		String sql = "CREATE TABLE AP";
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

	}
}
