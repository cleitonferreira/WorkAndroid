package nuvemapp.com.br.exemploonscrolllistener.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by viniciusthiengo on 2/1/15.
 */
public class CustomApplication extends Application {
    private RequestQueue requestQueue;
    private ImageLoaderConfiguration config;
    private ImageLoader imageLoader;


    @Override
    public void onCreate(){
        super.onCreate();

        requestQueue = Volley.newRequestQueue(this);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
            .threadPoolSize(5) // default
            .denyCacheImageMultipleSizesInMemory()
            .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
            .memoryCacheSize(2 * 1024 * 1024)
            .diskCacheSize(50 * 1024 * 1024)
            .diskCacheFileCount(100)
            .writeDebugLogs()
            .build();

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
    }


    public RequestQueue getRequestQueue(){
        return(requestQueue);
    }


    public ImageLoader getImageLoader(){
        return(imageLoader);
    }
}
