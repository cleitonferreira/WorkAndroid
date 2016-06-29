package nuvemapp.com.br.exemplomaterialdesign.network;

import org.json.JSONArray;

import nuvemapp.com.br.exemplomaterialdesign.domain.WrapObjToNetwork;


public interface Transaction {
    WrapObjToNetwork doBefore();

    void doAfter(JSONArray jsonArray);
}
