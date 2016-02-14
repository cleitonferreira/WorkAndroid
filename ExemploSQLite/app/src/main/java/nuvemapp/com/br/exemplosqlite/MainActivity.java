package nuvemapp.com.br.exemplosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getActivity(View view){
        Button bt = (Button) view;
        Intent intent;

        if(bt.getText().toString().equalsIgnoreCase("Novo usuário")){
            intent = new Intent(this, NewUserActivity.class);
        }
        else{
            intent = new Intent(this, ListUsersActivity.class);
        }

        startActivity(intent);
    }
}
