package nuvemapp.com.br.exemplogcmnotification.network;

import org.json.JSONObject;

import nuvemapp.com.br.exemplogcmnotification.domain.WrapObjToNetwork;

public interface Transaction {
    WrapObjToNetwork doBefore();

    void doAfter(JSONObject jsonObject);
}
