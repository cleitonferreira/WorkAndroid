package nuvemapp.com.br.exemploactionbartabs;

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

        TextView tv = new TextView(getActivity());
        tv.setText("Fragment 1 em ação");

        return tv;
    }

}
