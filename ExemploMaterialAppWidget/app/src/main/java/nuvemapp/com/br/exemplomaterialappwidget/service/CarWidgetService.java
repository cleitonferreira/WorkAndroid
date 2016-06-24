package nuvemapp.com.br.exemplomaterialappwidget.service;

import android.content.Intent;
import android.widget.RemoteViewsService;

import nuvemapp.com.br.exemplomaterialappwidget.adapters.CarWidgetFactoryAdapter;


public class CarWidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new CarWidgetFactoryAdapter(this, intent);
    }
}
