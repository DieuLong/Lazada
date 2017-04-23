package com.philong.lazada.connectinternet;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Long on 23/04/2017.
 */

public class DownloadJSON extends AsyncTask<String, Void, String> {

    private String duongDan;
    private List<HashMap<String, String>> attrs;
    private StringBuilder stringBuilder;
    private boolean method;

    public DownloadJSON(String duongDan){
        this.duongDan = duongDan;
        method = true;
    }

    public DownloadJSON(String duongDan, List<HashMap<String, String>> attrs){
        this.duongDan = duongDan;
        this.attrs = attrs;
        method = false;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            String dulieu = "";
            URL url = new URL(duongDan);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(!method) {
                dulieu = methodPOST(connection);
            }else{
                dulieu = methodGET(connection);
            }
            return dulieu;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String methodGET(HttpURLConnection connection){
        String dulieu = "";

        InputStream ips = null;
        try {
            connection.connect();
            ips = connection.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader buffer = new BufferedReader(ipsr);
            stringBuilder = new StringBuilder();
            String line = "";
            while((line = buffer.readLine()) != null){
                stringBuilder.append(line);
            }
            buffer.close();
            ipsr.close();
            ips.close();
            dulieu =  stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dulieu;
    }

    private String methodPOST(HttpURLConnection connection){
        String dulieu = "";
        String key = "";
        String value = "";
        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            Uri.Builder builder = new Uri.Builder();
            int count = attrs.size();
            for (int i = 0; i < count ; i++) {
                for (Map.Entry<String, String> values : attrs.get(i).entrySet()) {
                    key = values.getKey();
                    value = values.getValue();
                }
                builder.appendQueryParameter(key, value);
            }
            String query = builder.build().getEncodedQuery();
            OutputStream ops = connection.getOutputStream();
            OutputStreamWriter opsw = new OutputStreamWriter(ops);
            BufferedWriter buffw = new BufferedWriter(opsw);
            buffw.write(query);
            buffw.flush();
            buffw.close();
            opsw.close();
            ops.close();
            dulieu = methodGET(connection);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dulieu;
    }
}
