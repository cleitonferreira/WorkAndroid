package nuvemapp.com.br.exemplouniversalimageloader;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import nuvemapp.com.br.exemplouniversalimageloader.domain.Post;


public class MainActivity extends Activity {
    private ListView lvPosts;
    private List<Post> list;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Post>();
        list.add(new Post("Title 1", "http://www.thiengo.com.br/img/post/facebook/650-366/q4aic15alrfrea79ds087i421606cb3d59db4501674a47300b5bd9c51a.jpeg"));
        list.add(new Post("Title 2", "http://www.thiengo.com.br/img/post/facebook/650-366/a7uoasn46kvvd9ro48nvc6vsq17532f9e2d260f8d4d07a54f3d4ceffa2.jpeg"));
        list.add(new Post("Title 3", "http://www.thiengo.com.br/img/post/facebook/650-366/pl1glfklo5q3n0uke59ekburr117ca73aacaac6d8e678c4a7de17e1123.jpeg"));
        list.add(new Post("Title 4", "http://www.thiengo.com.br/img/post/facebook/650-366/c5r6g1dkkf76alongebve8ajp21043a09819152f24ce0246600d352a63.jpeg"));
        list.add(new Post("Title 5", "http://www.thiengo.com.br/img/post/facebook/650-366/ns2rbfda6ova5o9k3kncosuv71daf8c6358bc7e7101a5c644eee544401.jpeg"));
        list.add(new Post("Title 6", "http://www.thiengo.com.br/img/post/facebook/650-366/nv93rg8g73c8ma2kp142ul05660b39e14277b3a1e931350bf0b6b20277.jpeg"));
        list.add(new Post("Title 7", "http://www.thiengo.com.br/img/post/facebook/650-366/qhpo03c2nukp44jog7lbc1kgt76f83d7a7127ef2167b751fcf0f031dc0.jpeg"));
        list.add(new Post("Title 8", "http://www.thiengo.com.br/img/post/facebook/650-366/qm8dg3vv2094db3k94uf352h64d579fb312890d852c3b585412b6b9468.jpeg"));
        list.add(new Post("Title 9", "http://www.thiengo.com.br9/img/post/facebook/650-366/bmvlq3fuung107tf9u5geqj097ba01f2c3429d17ad97b95fc615713fd2.jpeg"));
        list.add(new Post("Title 10", ""));
        list.add(new Post("Title 11", "http://www.villopim.com.br/android/universal-image-loader/teste.png"));


        DisplayImageOptions mDisplayImageOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.empty) // quando não existir o caminho da imagem
                .showImageOnFail(R.drawable.fail) // quando falhar o carregamento da imagem
                .showImageOnLoading(R.drawable.loading) // carregamento da imagem
                .cacheInMemory(true)
                .cacheOnDisk(true)
                //.displayer(new FadeInBitmapDisplayer(1000))
                .build();

        ImageLoaderConfiguration conf = new ImageLoaderConfiguration.Builder(MainActivity.this)
                .defaultDisplayImageOptions(mDisplayImageOptions)
                .memoryCacheSize(50 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)
                .threadPoolSize(5)
                .writeDebugLogs()
                .build();
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(conf);

        PauseOnScrollListener mPauseOnScrollListener = new PauseOnScrollListener(mImageLoader, true, true);

        lvPosts = (ListView) findViewById(R.id.lvPosts);
        lvPosts.setAdapter(new AdapterListView(MainActivity.this, list, mImageLoader));
        lvPosts.setOnScrollListener(mPauseOnScrollListener);
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
		/*
		mImageLoader.clearMemoryCache(); // tirar o cache da memória
		mImageLoader.clearDiskCache(); // tirar o cache do disco
		*/
        mImageLoader.stop();
    }
}
