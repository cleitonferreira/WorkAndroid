package nuvemapp.com.br.exemplomaterialappwidget.network;

import org.json.JSONArray;

import nuvemapp.com.br.exemplomaterialappwidget.domain.WrapObjToNetwork;

public interface Transaction {
    WrapObjToNetwork doBefore();

    void doAfter(JSONArray jsonArray);
}
