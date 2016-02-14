package nuvemapp.com.br.exemplosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewUserActivity extends AppCompatActivity {

    private Usuario usuario = new Usuario();
    private EditText nomeEt;
    private EditText emailEt;
    private EditText senhaEt;
    private Button salvarBt;
    private Button editarBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        nomeEt = (EditText) findViewById(R.id.nome);
        emailEt = (EditText) findViewById(R.id.email);
        senhaEt = (EditText) findViewById(R.id.senha);
        salvarBt = (Button) findViewById(R.id.salvar);
        editarBt = (Button) findViewById(R.id.editar);

        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                usuario.setId(bundle.getLong("id"));
                usuario.setNome(bundle.getString("nome"));
                usuario.setEmail(bundle.getString("email"));

                nomeEt.setText(usuario.getNome());
                emailEt.setText(usuario.getEmail());

                senhaEt.setVisibility(View.GONE);
                salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);

            }
        }

    }

    public void salvarUsuario(View view) {
        usuario.setNome(nomeEt.getText().toString());
        usuario.setEmail(emailEt.getText().toString());
        usuario.setSenha(senhaEt.getText().toString());

        // inserir no BD SQLite
        BD bd = new BD(this);
        bd.inserir(usuario);

        Toast.makeText(this, "Usuário inserido com sucesso.", Toast.LENGTH_SHORT).show();
    }

    public void editarUsuario(View view) {
        usuario.setNome(nomeEt.getText().toString());
        usuario.setEmail(emailEt.getText().toString());

        // atualizar no BD SQLite
        BD bd = new BD(this);
        bd.atualizar(usuario);

        Toast.makeText(this, "Usuário \""+usuario.getNome()+"\" atualizado com sucesso.", Toast.LENGTH_SHORT).show();
    }
}
