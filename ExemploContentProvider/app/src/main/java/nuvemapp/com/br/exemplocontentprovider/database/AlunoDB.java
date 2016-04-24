package nuvemapp.com.br.exemplocontentprovider.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteQueryBuilder;

public class AlunoDB extends Database {
	public static final String DB_TABLE_ALUNO = "aluno";
	public static final String DB_COL_ID = "_id";
	public static final String DB_COL_DATA = "_data";
	public static final String DB_COL_NOME = "nome";
	public static final String DB_COL_MATRICULA = "matricula";
	public static final String DB_COL_IDADE = "idade";
	public static final String DB_COL_TURMA = "turma";
	public static final String DB_COL_FALTAS = "faltas";
	
	
	public AlunoDB(Context context) {
		super(context);
		try{
			database = getWritableDatabase();
		}
		catch(SQLiteAbortException e){ e.printStackTrace(); }
		catch(SQLException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(Exception e){ e.printStackTrace(); }
	}
	
	
	public long insert(ContentValues values){
		try{
			long aux = database.insert(DB_TABLE_ALUNO, null, values);
			return(aux);
		}
		catch(SQLiteAbortException e){ e.printStackTrace(); }
		catch(SQLException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(Exception e){ e.printStackTrace(); }
		return(0);
	}
	
	
	public int update(ContentValues values, String selection, String[] selectionArgs){
		try{
			return(database.update(DB_TABLE_ALUNO, values, selection, selectionArgs));
		}
		catch(SQLiteAbortException e){ e.printStackTrace(); }
		catch(SQLException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(Exception e){ e.printStackTrace(); }
		return(0);
	}
	
	
	public int delete(String selection, String[] selectionArgs){
		try{
			return(database.delete(DB_TABLE_ALUNO, selection, selectionArgs));
		}
		catch(SQLiteAbortException e){ e.printStackTrace(); }
		catch(SQLException e){ e.printStackTrace(); }
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(Exception e){ e.printStackTrace(); }
		return(0);
	}
	
	
	public Cursor query(SQLiteQueryBuilder queryBuilder, String[] projection, String selection, String[] selectionArgs, String orderBy){
		if(queryBuilder == null){
			queryBuilder = new SQLiteQueryBuilder();
			queryBuilder.setTables(DB_TABLE_ALUNO);
		}
		
		Cursor c = queryBuilder.query(database, projection, selection, selectionArgs, null, null, orderBy);
		return(c);
	}
}
