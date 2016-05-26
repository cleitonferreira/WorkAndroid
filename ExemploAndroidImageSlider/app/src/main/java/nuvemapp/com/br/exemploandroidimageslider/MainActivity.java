package nuvemapp.com.br.exemploandroidimageslider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener, BaseSliderView.OnSliderClickListener, BaseSliderView.ImageLoadListener {
    private ListView lvEffects;

    private String[] images = {
            "https://raw.githubusercontent.com/cleitonferreira/WorkAndroid/master/%23Arquivos/IMG/game_of_thrones.jpg",
            "https://raw.githubusercontent.com/cleitonferreira/WorkAndroid/master/%23Arquivos/IMG/house.jpg"};

    private String[] effects = {"Accordion",
            "Background2Foreground",
            "CubeIn",
            "Default",
            "DepthPage",
            "Fade",
            "FlipHorizontal",
            "FlipPage",
            "Foreground2Background",
            "RotateDown",
            "RotateUp",
            "Stack",
            "Tablet",
            "ZoomIn",
            "ZoomOut",
            "ZoomOutSlide"};

    private SliderLayout.Transformer[] effectsId = {
            SliderLayout.Transformer.Accordion,
            SliderLayout.Transformer.Background2Foreground,
            SliderLayout.Transformer.CubeIn,
            SliderLayout.Transformer.Default,
            SliderLayout.Transformer.DepthPage,
            SliderLayout.Transformer.Fade,
            SliderLayout.Transformer.FlipHorizontal,
            SliderLayout.Transformer.FlipPage,
            SliderLayout.Transformer.Foreground2Background,
            SliderLayout.Transformer.RotateDown,
            SliderLayout.Transformer.RotateUp,
            SliderLayout.Transformer.Stack,
            SliderLayout.Transformer.Tablet,
            SliderLayout.Transformer.ZoomIn,
            SliderLayout.Transformer.ZoomOut,
            SliderLayout.Transformer.ZoomOutSlide};

    private SliderLayout slImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SLIDERLAYOUT
        slImages = (SliderLayout) findViewById(R.id.slImages);

        // Imagens carregadas da web (GitHub)
        TextSliderView aux1 = new TextSliderView(MainActivity.this);

        aux1.description("Image Web 1");
        aux1.image(images[0]);
        aux1.setOnSliderClickListener(MainActivity.this);
        aux1.setOnImageLoadListener(MainActivity.this);
        slImages.addSlider(aux1);

        aux1 = new TextSliderView(MainActivity.this);
        aux1.description("Image Web 2");
        aux1.image(images[1]);
        aux1.setOnSliderClickListener(MainActivity.this);
        aux1.setOnImageLoadListener(MainActivity.this);
        slImages.addSlider(aux1);

        // Imagens carregadas do aplicação (drawable)
        DefaultSliderView aux2 = new DefaultSliderView(MainActivity.this);

        aux2.image(R.drawable.image_1);
        aux2.setOnSliderClickListener(MainActivity.this);
        aux2.description("Image Drawable 1");
        slImages.addSlider(aux2);

        aux2 = new DefaultSliderView(MainActivity.this);
        aux2.image(R.drawable.image_2);
        aux2.setOnSliderClickListener(MainActivity.this);
        aux2.description("Image Drawable 2");
        slImages.addSlider(aux2);

        aux2 = new DefaultSliderView(MainActivity.this);
        aux2.image(R.drawable.image_3);
        aux2.setOnSliderClickListener(MainActivity.this);
        aux2.description("Image Drawable 3");
        slImages.addSlider(aux2);

        slImages.setPresetTransformer(effectsId[0]);
        //slImages.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        slImages.setCustomIndicator((PagerIndicator)findViewById(R.id.custom_indicator));
        //slImages.setDuration(4000);
        //slImages.setSliderTransformDuration(8000, null);
        slImages.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);

        PagerIndicator p = (PagerIndicator)findViewById(R.id.custom_indicator);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LOG", "ID: "+v.getId());
            }
        });

        // LISTVIEW
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, effects);
        lvEffects = (ListView) findViewById(R.id.lvEffects);
        lvEffects.setAdapter(adapter);
        lvEffects.setOnItemClickListener(this);
    }


    // LISTENER
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("LOG", "onItemClick()");
        Toast.makeText(MainActivity.this, effects[position], Toast.LENGTH_SHORT).show();
        slImages.setPresetTransformer(effectsId[position]);
    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {
        Log.i("LOG", "onSliderClick(" + baseSliderView.getDescription() + ")");
        slImages.startAutoCycle();
    }

    @Override
    public void onStart(BaseSliderView baseSliderView) {
        Log.i("LOG", "onStart(" + baseSliderView.getDescription() + ")");
    }

    @Override
    public void onEnd(boolean b, BaseSliderView baseSliderView) {
        Log.i("LOG", "onEnd(" + baseSliderView.getDescription() + ")");
    }
}
