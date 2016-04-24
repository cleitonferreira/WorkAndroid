package nuvemapp.com.br.exemplocontentprovider;

/**
 * Created by XPredator on 23/04/2016.
 */
import java.io.FileNotFoundException;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

import nuvemapp.com.br.exemplocontentprovider.database.AlunoDB;
import nuvemapp.com.br.exemplocontentprovider.domain.AlunosContract;

public class AlunosProvider extends ContentProvider {

    private AlunoDB alunoDb;

    private static UriMatcher uriAlunos;

    static {
        uriAlunos = new UriMatcher(UriMatcher.NO_MATCH);

        // content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos
        uriAlunos.addURI(AlunosContract.AUTHORITY, "alunos/", AlunosContract.ALUNOS);

        // content://nuvemapp.com.br.exemplocontentprovider.aluno.provider/alunos/2
        uriAlunos.addURI(AlunosContract.AUTHORITY, "alunos/#", AlunosContract.ALUNOS_ID);
    }


    @Override
    public boolean onCreate() {
        alunoDb = new AlunoDB(getContext());
        return(true);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS:
                sortOrder = sortOrder == null ? AlunoDB.DB_COL_ID+" ASC" : sortOrder;
                break;
            case AlunosContract.ALUNOS_ID:
                String aux = AlunoDB.DB_COL_ID+" = "+uri.getLastPathSegment();
                selection = selection == null ? aux : selection+" AND "+aux;
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }

        Cursor cursor = alunoDb.query(null, projection, selection, selectionArgs, sortOrder);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS:
                return("vnd.android.cursor.dir/vnd.exemplocontentprovider.alunos");
            case AlunosContract.ALUNOS_ID:
                return("vnd.android.cursor.item/vnd.exemplocontentprovider.alunos");
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }
    }

    @Override
    public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS:
                break;
            case AlunosContract.ALUNOS_ID:
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }
        return(new String[]{mimeTypeFilter});
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS:
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }

        Long id = alunoDb.insert(values);
        uri = Uri.withAppendedPath(uri, ""+id);

        return(uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS_ID:
                String aux = AlunoDB.DB_COL_ID+" = "+uri.getLastPathSegment();
                selection = selection == null ? aux : selection+" AND "+aux;
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }

        int qtd = alunoDb.delete(selection, selectionArgs);

        return(qtd);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS_ID:
                String aux = AlunoDB.DB_COL_ID+" = "+uri.getLastPathSegment();
                selection = selection == null ? aux : selection+" AND "+aux;
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }


        int qtd = alunoDb.update(values, selection, selectionArgs);

        return(qtd);
    }


    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException{
        switch(uriAlunos.match(uri)){
            case AlunosContract.ALUNOS_ID:
                break;
            default:
                throw new IllegalArgumentException("Uri inválida: "+uri);
        }

        return(openFileHelper(uri, mode));
    }

}

