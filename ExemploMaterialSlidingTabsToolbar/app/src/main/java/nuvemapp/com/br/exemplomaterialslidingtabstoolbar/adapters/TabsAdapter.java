package nuvemapp.com.br.exemplomaterialslidingtabstoolbar.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.R;
import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.fragments.CarFragment;
import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.fragments.LuxuryCarFragment;
import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.fragments.OldCarFragment;
import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.fragments.PopularCarFragment;
import nuvemapp.com.br.exemplomaterialslidingtabstoolbar.fragments.SportCarFragment;

public class TabsAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles = {"TODOS", "LUXO", "SPORT", "COLECIONADOR", "POPULAR"};
    private int[] icons = new int[]{R.drawable.car_1, R.drawable.car_1, R.drawable.car_2, R.drawable.car_3, R.drawable.car_4};
    private int heightIcon;


    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);

        mContext = c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int)( 24 * scale + 0.5f );
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if(position == 0){ // ALL CARS
            frag = new CarFragment();
        }
        else if(position == 1){ // LUXURY CAR
            frag = new LuxuryCarFragment();
        }
        else if(position == 2){ // SPORT CAR
            frag = new SportCarFragment();
        }
        else if(position == 3){ // OLD CAR
            frag = new OldCarFragment();
        }
        else if(position == 4){ // POPULAR CAR
            frag = new PopularCarFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        /*Drawable d = mContext.getResources().getDrawable( icons[position] );
        d.setBounds(0, 0, heightIcon, heightIcon);

        ImageSpan is = new ImageSpan( d );

        SpannableString sp = new SpannableString(" ");
        sp.setSpan( is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );


        return ( sp );*/
        return ( titles[position] );
    }
}
