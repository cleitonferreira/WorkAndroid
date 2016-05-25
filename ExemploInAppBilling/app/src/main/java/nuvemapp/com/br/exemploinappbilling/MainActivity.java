package nuvemapp.com.br.exemploinappbilling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import nuvemapp.com.br.exemploinappbilling.application.MyApplication;
import nuvemapp.com.br.exemploinappbilling.util.IabHelper;
import nuvemapp.com.br.exemploinappbilling.util.IabResult;
import nuvemapp.com.br.exemploinappbilling.util.Inventory;
import nuvemapp.com.br.exemploinappbilling.util.Purchase;

public class MainActivity extends Activity {

    private IabHelper mHelper;

    // CONSTANTS
    private static final String[] PRODUCT_IDS = new String[]{"produto_teste_1",
            "produto_teste_2", "produto_teste_3", "produto_teste_4", "produto_teste_5", "produto_teste_6", "produto_teste_7"};
    private static final String base64EncodedPublicKey = ""; //fornecido pela google pela play store

    // VIEWS
    private ImageView ivProduct1;
    private ImageView ivProduct2;
    private ImageView ivProduct3;
    private ImageView ivProduct4;
    private ImageView ivProduct5;
    private ImageView ivProduct6;
    private ImageView ivProduct7;

    // VAR. LISTENERS
    private IabHelper.QueryInventoryFinishedListener mQueryInventoryFinishedListener = new IabHelper.QueryInventoryFinishedListener(){
        @Override
        public void onQueryInventoryFinished(IabResult result, Inventory inv) {
            Log.i("Script", "onQueryInventoryFinished()");

            if(result.isFailure()){
                Log.i("Script", "onQueryInventoryFinished() : FAIL : "+result);
            }
            else if(inv != null){
                for(int i = 0; i < PRODUCT_IDS.length; i++){
                    if(inv.hasDetails(PRODUCT_IDS[i])){
                        Log.i("Script", inv.getSkuDetails(PRODUCT_IDS[i]).getSku().toUpperCase());
                        Log.i("Script", "Sku: "+inv.getSkuDetails(PRODUCT_IDS[i]).getSku());
                        Log.i("Script", "Title: "+inv.getSkuDetails(PRODUCT_IDS[i]).getTitle());
                        Log.i("Script", "Type: "+inv.getSkuDetails(PRODUCT_IDS[i]).getType());
                        Log.i("Script", "Price: "+inv.getSkuDetails(PRODUCT_IDS[i]).getPrice());
                        Log.i("Script", "Description: "+inv.getSkuDetails(PRODUCT_IDS[i]).getDescription());
                        Log.i("Script", "Status purchase: "+(inv.hasPurchase(PRODUCT_IDS[i]) ? "COMPRADO" : "NÃO COMPRADO"));
                        enableImageView(inv.hasPurchase(PRODUCT_IDS[i]), PRODUCT_IDS[i]);
                        Log.i("Script", "-------------------------------------");
                    }
                }
            }
        }
    };


    private IabHelper.OnIabPurchaseFinishedListener mIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener(){
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase info) {
            Log.i("Script", "onIabPurchaseFinished()");

            if(result.isFailure()){
                Log.i("Script", "onIabPurchaseFinished() : FAIL : "+result);
                return;
            }
            else if(info.getSku().equalsIgnoreCase(PRODUCT_IDS[0])){
                mHelper.consumeAsync(info, mConsumeFinishedListener);
            }

            Log.i("Script", info.getSku().toUpperCase());
            Log.i("Script", "Order ID: "+info.getOrderId());
            Log.i("Script", "DeveloperPayload: "+info.getDeveloperPayload());
        }
    };

    private IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener(){

        @Override
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            Log.i("Script", "onConsumeFinished()");

            if(result.isFailure()){
                Log.i("Script", "onConsumeFinished() : FAIL : "+result);
            }
            else{
                Log.i("Script", "onConsumeFinished("+purchase.getSku()+") : SUCCESS");
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivProduct1 = (ImageView) findViewById(R.id.ivProduct1);
        ivProduct2 = (ImageView) findViewById(R.id.ivProduct2);
        ivProduct3 = (ImageView) findViewById(R.id.ivProduct3);
        ivProduct4 = (ImageView) findViewById(R.id.ivProduct4);
        ivProduct5 = (ImageView) findViewById(R.id.ivProduct5);
        ivProduct6 = (ImageView) findViewById(R.id.ivProduct6);
        ivProduct7 = (ImageView) findViewById(R.id.ivProduct7);

        mHelper = ((MyApplication) getApplication()).getmHelper();

        if(mHelper == null){
            mHelper = new IabHelper(MainActivity.this, base64EncodedPublicKey);
            ((MyApplication) getApplication()).setmHelper(mHelper);

            mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                @Override
                public void onIabSetupFinished(IabResult result) {
                    Log.i("Script", "onIabSetupFinished()");

                    if(result.isFailure()){
                        Log.i("Script", "onIabSetupFinished() : FAIL : "+result);
                    }
                    else{
                        Log.i("Script", "onIabSetupFinished() : SUCCESS");

                        List<String> productsIds = new ArrayList<String>();
                        for(int i = 0; i < PRODUCT_IDS.length; i++){
                            productsIds.add(PRODUCT_IDS[i]);
                        }

                        mHelper.queryInventoryAsync(true, productsIds, mQueryInventoryFinishedListener);
                    }
                }
            });
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Log.i("Script", "onActivityResult("+requestCode+")");

        if(requestCode == 1002 && resultCode == RESULT_OK){
            if(mHelper != null && !mHelper.handleActivityResult(requestCode, resultCode, data)){
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();

        if(mHelper != null){
            mHelper.dispose();
        }
        mHelper = null;
        ((MyApplication) getApplication()).setmHelper(null);
    }




    // UTIL
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    private void enableImageView(boolean status, String productId){
        if(status){
            if(productId.equalsIgnoreCase(PRODUCT_IDS[0])){
                ivProduct1.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[1])){
                ivProduct2.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[2])){
                ivProduct3.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[3])){
                ivProduct4.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[4])){
                ivProduct5.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[5])){
                ivProduct6.setVisibility(View.VISIBLE);
            }
            else if(productId.equalsIgnoreCase(PRODUCT_IDS[6])){
                ivProduct7.setVisibility(View.VISIBLE);
            }
        }
    }




    // LISTENER
    public void buy(View view){
        Log.i("Script", "buy()");

        if(mHelper == null){
            return;
        }

        if(view.getId() == R.id.btProduct1){
            mHelper.launchPurchaseFlow(MainActivity.this, PRODUCT_IDS[0], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct2){
            mHelper.launchPurchaseFlow(MainActivity.this, PRODUCT_IDS[1], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct3 && mHelper.subscriptionsSupported()){
            mHelper.launchSubscriptionPurchaseFlow(MainActivity.this, PRODUCT_IDS[2], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct4){
            mHelper.launchPurchaseFlow(MainActivity.this, PRODUCT_IDS[3], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct5){
            mHelper.launchPurchaseFlow(MainActivity.this, PRODUCT_IDS[4], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct6 && mHelper.subscriptionsSupported()){
            mHelper.launchSubscriptionPurchaseFlow(MainActivity.this, PRODUCT_IDS[5], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
        else if(view.getId() == R.id.btProduct7 && mHelper.subscriptionsSupported()){
            mHelper.launchSubscriptionPurchaseFlow(MainActivity.this, PRODUCT_IDS[6], 1002, mIabPurchaseFinishedListener, "token-"+randInt(1000, 9999));
        }
    }


    public void bought(View view){
        Log.i("Script", "bought()");

        if(mHelper == null){
            return;
        }

        mHelper.queryInventoryAsync(mQueryInventoryFinishedListener);
    }
}
