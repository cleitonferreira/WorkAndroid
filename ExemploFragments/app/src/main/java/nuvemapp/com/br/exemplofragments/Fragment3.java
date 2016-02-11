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
public class Fragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(R.layout.layout_frag_3, null);

        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText("Fragment 3");

        return view;
    }

}
