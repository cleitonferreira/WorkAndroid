package nuvemapp.com.br.exemplovolleyimageloader;

import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.widget.ListView;

import nuvemapp.com.br.exemplovolleyimageloader.adapter.PostAdapter;
import nuvemapp.com.br.exemplovolleyimageloader.cdp.Post;


public class ProfileActivity extends Activity {
    private ListView lvPosts;
    private ArrayList<Post> list;
    private RequestQueue rq;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        list = getIntent().getParcelableArrayListExtra("posts");

        rq = Volley.newRequestQueue(ProfileActivity.this);

        imageLoader = new ImageLoader(rq, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(10);

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }
        });

        lvPosts = (ListView) findViewById(R.id.lvPosts);
        lvPosts.setAdapter(new PostAdapter(ProfileActivity.this, list, imageLoader));
    }
}
