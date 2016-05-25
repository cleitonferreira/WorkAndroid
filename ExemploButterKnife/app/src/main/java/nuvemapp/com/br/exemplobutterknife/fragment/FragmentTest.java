package nuvemapp.com.br.exemplobutterknife.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;
import nuvemapp.com.br.exemplobutterknife.R;

public class FragmentTest extends Fragment {
    @InjectView(R.id.btToastMessage) protected Button btToastMessage;
    @InjectViews({R.id.etName, R.id.etEmail}) protected List<EditText> listEt;

    /*protected EditText etName;
    protected EditText etEmail;*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_test, container, false);

        ButterKnife.inject(FragmentTest.this, view);

        /*btToastMessage = (Button) view.findViewById(R.id.btToastMessage);
        btToastMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Toast printado", Toast.LENGTH_SHORT).show();
            }
        });

        etName = (EditText) view.findViewById(R.id.etName);
        etEmail = (EditText) view.findViewById(R.id.etEmail);*/

        for(int i = 0, tam = listEt.size(); i < tam; i++){
            Log.i("LOG", "Hint: "+listEt.get(i).getHint().toString());
        }


        return(view);
    }


    @OnClick(R.id.btToastMessage)
    public void callToast(){
        Toast.makeText(getActivity(), "Toast printado", Toast.LENGTH_SHORT).show();
    }
}
