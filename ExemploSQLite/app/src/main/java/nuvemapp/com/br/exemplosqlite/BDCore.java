package nuvemapp.com.br.exemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by XPredator on 14/02/2016.
 */
public class BDCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "teste";
    private static final int VERSAO_BD = 6;//se mudar a versão do BD, o Banco de Dados é deletado e criado novamente

    public BDCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        bd.execSQL("drop table usuario;");
        onCreate(bd);
    }
}
