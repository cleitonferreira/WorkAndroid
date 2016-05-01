package nuvemapp.com.br.exemplodropboxdownloadupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxFileInfo;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.ProgressListener;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxServerException;
import com.dropbox.client2.session.AppKeyPair;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
    final static private String APP_KEY = "mru2yqfck789795";
    final static private String APP_SECRET = "if8wgqzeuccjpfr";

    final static private String ACCOUNT_PREFS_NAME = "prefs_dropbox";
    final static private String ACCESS_TOKEN = "ACCESS_TOKEN";

    private ListView listView;
    private Button btLogin;
    private Button btLogout;
    private Button btList;

    private Button btUploadFile;
    private Button btUpdateFile;
    private Button btDownloadFile;
    private Button btDeleteFile;
    private Button btDeleteFolder;
    private ImageView ivImg;

    private List<Entry> list;

    private DropboxAPI<AndroidAuthSession> dropboxApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Entry>();

        AndroidAuthSession session = buildSession();
        dropboxApi = new DropboxAPI<AndroidAuthSession>(session);

        listView = (ListView) findViewById(R.id.listView);
        btLogin = (Button) findViewById(R.id.btLogin);
        btLogout = (Button) findViewById(R.id.btLogout);
        btList = (Button) findViewById(R.id.btList);

        btUploadFile = (Button) findViewById(R.id.btUploadFile);
        btUpdateFile = (Button) findViewById(R.id.btUpdateFile);
        btDownloadFile = (Button) findViewById(R.id.btDownloadFile);
        btDeleteFile = (Button) findViewById(R.id.btDeleteFile);
        btDeleteFolder = (Button) findViewById(R.id.btDeleteFolder);
        ivImg = (ImageView) findViewById(R.id.ivImg);

        enableViews(dropboxApi.getSession().isLinked());
    }

    @Override
    public void onResume() {
        super.onResume();
        AndroidAuthSession session = dropboxApi.getSession();

        if (session.authenticationSuccessful()) {
            session.finishAuthentication();

            saveLogged(session);
            enableViews(true);
        }
    }


    // UTIL
    public void enableViews(boolean status) {
        if (status) {
            btLogin.setVisibility(View.GONE);
            btLogout.setVisibility(View.VISIBLE);
            btList.setVisibility(View.VISIBLE);
            btUploadFile.setVisibility(View.VISIBLE);
            btUpdateFile.setVisibility(View.VISIBLE);
            btDownloadFile.setVisibility(View.VISIBLE);
            btDeleteFile.setVisibility(View.VISIBLE);
            btDeleteFolder.setVisibility(View.VISIBLE);
        } else {
            btDownloadFile.setVisibility(View.GONE);
            btUpdateFile.setVisibility(View.GONE);
            btUploadFile.setVisibility(View.GONE);
            btList.setVisibility(View.GONE);
            btLogout.setVisibility(View.GONE);
            btDeleteFile.setVisibility(View.GONE);
            btDeleteFolder.setVisibility(View.GONE);
            btLogin.setVisibility(View.VISIBLE);
        }
    }

    public AndroidAuthSession buildSession() {
        AppKeyPair akp = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(akp);
        loadSession(session);

        return (session);
    }

    public void loadSession(AndroidAuthSession session) {
        SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        String token = sp.getString(ACCESS_TOKEN, null);

        if (token == null || token.length() == 0) {
            return;
        } else {
            session.setOAuth2AccessToken(token);
        }
    }

    public void saveLogged(AndroidAuthSession session) {
        String token = session.getOAuth2AccessToken();
        if (token != null) {
            SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString(ACCESS_TOKEN, token);
            edit.commit();
        }
    }

    public void getDocs(Entry entry) throws DropboxException {
        list.add(entry);
        List<Entry> eList = entry.contents;
        if (eList != null) {
            for (Entry e : eList) {
                //list.add(e);
                e = dropboxApi.metadata(e.path, 0, null, true, null);
                getDocs(e);
            }
        }
    }


    // VIEWs METHODS
    public void login(View view) {
        dropboxApi.getSession().startOAuth2Authentication(MainActivity.this);
    }


    public void logout(View view) {
        dropboxApi.getSession().unlink();

        SharedPreferences sp = getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        edit.commit();

        enableViews(false);
    }


    public void loadList(View view) {
        Log.i("Script", "List file(s)");
        new Thread() {
            public void run() {

                try {
                    Entry e = dropboxApi.metadata("/Android", 0, null, true, null);
                    getDocs(e);
                } catch (DropboxException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        listView.setAdapter(new AdapterDropbox(MainActivity.this, list));
                    }
                });
            }
        }.start();
    }


    public void downloadFile(View view) {
        btDownloadFile.setText("Carregando...");
        btDownloadFile.setEnabled(false);

        new Thread() {
            public void run() {
                File file = null;
                try {
                    DropboxProgressListener dpl = new DropboxProgressListener(btDownloadFile);

                    file = new File(Environment.getExternalStorageDirectory(), "Pictures/image_download.jpg");
                    FileOutputStream os = new FileOutputStream(file);
                    DropboxFileInfo info = dropboxApi.getFile("/Android/img.jpg", null, os, dpl);
                    Log.i("Script", "Revision HASH: " + info.getMetadata().rev);
                } catch (DropboxException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                final String path = file == null ? null : file.getAbsolutePath();
                runOnUiThread(new Runnable() {
                    public void run() {
                        btDownloadFile.setText("Download File");
                        btDownloadFile.setEnabled(true);
                        ivImg.setImageBitmap(BitmapFactory.decodeFile(path));
                    }
                });
            }
        }.start();
    }


    public void uploadFile(View view) {
        btUploadFile.setText("Enviando...");
        btUploadFile.setEnabled(false);

        new Thread() {
            public void run() {
                try {
                    try {
                        dropboxApi.metadata("/Android", 0, null, false, null);
                    } catch (DropboxServerException e) {
                        dropboxApi.createFolder("/Android");
                    }

                    DropboxProgressListener dpl = new DropboxProgressListener(btUploadFile);

                    File file = new File(Environment.getExternalStorageDirectory(), "Pictures/image_download.jpg");
                    FileInputStream is = new FileInputStream(file);
                    Entry reponse = dropboxApi.putFile("/Android/image_upload.jpg", is, file.length(), null, dpl);
                    Log.i("Script", "Revision HASH (uploadFile): " + reponse.rev);
                } catch (DropboxException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    public void run() {
                        btUploadFile.setText("Upload File");
                        btUploadFile.setEnabled(true);
                    }
                });
            }
        }.start();
    }


    public void updateFile(View view) {
        btUpdateFile.setText("Atualizando...");
        btUpdateFile.setEnabled(false);

        new Thread() {
            public void run() {
                try {
                    DropboxProgressListener dpl = new DropboxProgressListener(btUpdateFile);

                    File file = new File(Environment.getExternalStorageDirectory(), "Pictures/image_download.jpg");
                    FileInputStream is = new FileInputStream(file);
                    Entry reponse = dropboxApi.putFileOverwrite("/Android/imagem_update.jpg", is, file.length(), dpl);
                    Log.i("Script", "Revision HASH (updateFile): " + reponse.rev);
                } catch (DropboxException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    public void run() {
                        btUpdateFile.setText("Update File");
                        btUpdateFile.setEnabled(true);
                    }
                });
            }
        }.start();
    }


    public void deleteFile(View view) {
        new Thread() {
            public void run() {
                try {
                    dropboxApi.delete("/Android/avatar1.png");
                    Log.i("Script", "deleteFile() ");
                } catch (DropboxException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public void deleteFolder(View view) {
        new Thread() {
            public void run() {
                try {
                    dropboxApi.delete("/Android");
                    Log.i("Script", "deleteFolder() ");
                } catch (DropboxException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public class DropboxProgressListener extends ProgressListener {
        private Button bt;

        public DropboxProgressListener(Button bt) {
            super();
            this.bt = bt;
        }

        @Override
        public void onProgress(long now, long total) {
            final long val = (long) (((double) now / (double) total) * 100);

            runOnUiThread(new Runnable() {
                public void run() {
                    bt.setText(bt.getText() + " (" + val + "%)");
                }
            });
        }

        @Override
        public long progressInterval() {
            return (100);
        }
    }
}
