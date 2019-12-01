package com.example.calculate;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

public class Money {


    //得到实时汇率
    public double moneyCon(String scur, String tcur) throws IOException {

        URL u = new URL("http://api.k780.com/?app=finance.rate&scur=" + scur + "&tcur=" + tcur +
                "&appkey=46553&sign=9dcd71a4d88a843a65fbc4201e7fe0fc&format=json");
        InputStream in = u.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[] = out.toByteArray();
        String str = new String(b, "utf-8");
        int i = str.lastIndexOf("rate");
        int j = str.lastIndexOf("update");
        return Double.parseDouble(str.substring(i+7,j-3));
    }


}
