package nuvemapp.com.br.exemplogallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by XPredator on 02/02/2016.
 */
public class AdapterImgs extends BaseAdapter {

    private Context ctx;
    private int[] imgs;

    public AdapterImgs(Context ctx, int[] imgs){
        this.ctx = ctx;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(ctx);
        ll.setOrientation(LinearLayout.VERTICAL);
        Gallery.LayoutParams lp = new Gallery.LayoutParams(Gallery.LayoutParams.MATCH_PARENT, Gallery.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);

        TextView tv = new TextView(ctx);
        tv.setText("Widget "+(position + 1));
        ll.addView(tv);

        ImageView iv = new ImageView(ctx);
        lp = new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT);
        iv.setLayoutParams(lp);
        iv.setImageResource(imgs[position]);
        ll.addView(iv);

        return(ll);
    }
}
