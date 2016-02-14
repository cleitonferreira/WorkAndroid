package nuvemapp.com.br.exemplosqlite;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class ListUsersActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_users);

        BD bd = new BD(this);

        List<Usuario> list = bd.buscar();
        setListAdapter(new UsuarioAdapter(this, list));
    }
}
