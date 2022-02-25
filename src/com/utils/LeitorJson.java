package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LeitorJson<T> {

    public String leitor (String urlCon){
       
        String linha;
        HttpURLConnection connection;
        StringBuffer buffer = null;
        
        try{
            URL url = new URL(urlCon);
            connection = (HttpURLConnection) url.openConnection();
            InputStream input = connection.getInputStream();
        
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }catch(IOException ioEx){
            ioEx.printStackTrace();
        }
       
    
        return "";
    }
    
}
