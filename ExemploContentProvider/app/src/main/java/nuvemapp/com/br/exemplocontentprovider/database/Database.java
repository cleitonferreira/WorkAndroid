package nuvemapp.com.br.exemplocontentprovider.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	public static final String DB_NAME = "alunos";
	public static final int DB_VERSION_CODE = 9;
	
	protected Context context;
	protected SQLiteDatabase database;
	
	
	public Database(Context context){
		super(context, DB_NAME, null, DB_VERSION_CODE);
		this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+AlunoDB.DB_TABLE_ALUNO+"("
				+ AlunoDB.DB_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
				+ AlunoDB.DB_COL_DATA+" TEXT NOT NULL,"
				+ AlunoDB.DB_COL_NOME+" TEXT NOT NULL,"
				+ AlunoDB.DB_COL_MATRICULA+" TEXT NOT NULL,"
				+ AlunoDB.DB_COL_IDADE+" INTEGER NOT NULL,"
				+ AlunoDB.DB_COL_TURMA+" TEXT NOT NULL,"
				+ AlunoDB.DB_COL_FALTAS+" INTEGER NOT NULL"
				+ ");");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
		try{
			db.execSQL("DROP TABLE "+AlunoDB.DB_TABLE_ALUNO+";");
		}
		catch(SQLiteAbortException e){ e.printStackTrace(); }
		catch(SQLException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(Exception e){ e.printStackTrace(); }
		onCreate(db);
	}
	
	public void close() {
		if(database != null){
			database.close();
		}
	}
}
