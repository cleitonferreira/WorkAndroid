package nuvemapp.com.br.exemplologinfacebookcompartilhamentosharedialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphUser;
import com.facebook.model.OpenGraphAction;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.FacebookDialog.PendingCall;
import com.facebook.widget.LoginButton;
import com.facebook.widget.ProfilePictureView;

public class MainActivity2 extends Activity {
    private UiLifecycleHelper uiHelper;
    private FacebookDialog.Callback callback = new FacebookDialog.Callback(){
        @Override
        public void onComplete(PendingCall pendingCall, Bundle data) {
            boolean success = FacebookDialog.getNativeDialogDidComplete(data);
            Log.i("Script", "Success? "+success);
        }

        @Override
        public void onError(PendingCall pendingCall, Exception error, Bundle data) {
            Log.i("Script", "ERROR: "+error.toString());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        uiHelper = new UiLifecycleHelper(this, null);
        uiHelper.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        uiHelper.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }


    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        uiHelper.onSaveInstanceState(bundle);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data, callback);
    }

    // SHARE
    public void shareContent(View view){
			if(FacebookDialog.canPresentShareDialog(this, FacebookDialog.ShareDialogFeature.SHARE_DIALOG)){
				FacebookDialog sd = new FacebookDialog.ShareDialogBuilder(this)
					.setName("GoWalk")
					.setCaption("Caption: Ficou fácil passear com seu Dog")
					.setDescription("Description: Ficou fácil passear com seu Dog")
					.setLink("http://www.gowalk.com.br")
					.setPicture("https://s-media-cache-ak0.pinimg.com/236x/05/04/4f/05044f91d9e48b9b5461671d63102a75.jpg")
					.build();

				uiHelper.trackPendingDialogCall(sd.present());
			}

//        if(FacebookDialog.canPresentOpenGraphActionDialog(this, FacebookDialog.OpenGraphActionDialogFeature.OG_ACTION_DIALOG)){
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog2);
//            List<Bitmap> bitmaps = new ArrayList<Bitmap>();
//            bitmaps.add(bitmap);
//
//            OpenGraphAction action = GraphObject.Factory.create(OpenGraphAction.class);
//            action.setProperty("testephoto", "http://samples.ogp.me/273600789643939");
//
//            FacebookDialog sd = new FacebookDialog.OpenGraphActionDialogBuilder(this, action, "exemplologindados:meutest", "testephoto")
//                    .setImageAttachmentsForAction(bitmaps, true)
//                    .build();
//
//            uiHelper.trackPendingDialogCall(sd.present());
//        }
    }
}
