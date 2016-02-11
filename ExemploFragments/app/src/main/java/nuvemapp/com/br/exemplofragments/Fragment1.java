package nuvemapp.com.br.exemplofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by XPredator on 10/02/2016.
 */
public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.layout_frag_1, null);

        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText("Fragment 1");

        return view;
    }

    public void alteraTextView(String texto) {
        TextView tv = (TextView) getView().findViewById(R.id.textView);
        tv.setText(texto);
    }


}
