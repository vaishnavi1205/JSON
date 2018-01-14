package com.swishsoftwaresolutions.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DELL on 12/9/2017.
 */

public class HTTPUrlConnection{

    public static String getData(String uri){
        HttpURLConnection connection =null;
        BufferedReader reader = null;
        String web = "";
        try{
            URL url = new URL(uri);
            connection = (HttpURLConnection)url.openConnection();
            connection.setReadTimeout(1000);
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);
            InputStream input = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));
            String data = null;

            while((data=reader.readLine())!=null){
                web+=data+"\n";
            }
            return web;
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            connection.disconnect();
        }

      return web;
    }
}
