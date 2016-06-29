package nuvemapp.com.br.exemplomaterialdesign.service;

import android.content.Intent;
import android.widget.RemoteViewsService;

import nuvemapp.com.br.exemplomaterialdesign.adapters.CarWidgetFactoryAdapter;


public class CarWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new CarWidgetFactoryAdapter(this, intent);
    }
}
