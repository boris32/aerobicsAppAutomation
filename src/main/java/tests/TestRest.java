package tests;

import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Created by Boris on 11/1/2018.
 */
public class TestRest {



    boolean parsingComplete = true;

    @Test
    public void testRest() throws ClientProtocolException, IOException {

        //String html = "html";

        String urlString = "https://jsonplaceholder.typicode.com/todos/1";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            InputStream stream = conn.getInputStream();

            String data = convertStreamToString(stream);

            JSONObject jsonReceived = new JSONObject(data);

            //THESE VALUES ARE ON TOP LEVEL - IF IT WEREN'T, WE'D NEED TO GET AS MANY JSON OBJECTS AS THERE ARE LEVELS ABOVE THEM
            String title = jsonReceived.getString("title");
            int userId = jsonReceived.getInt("userId");
            boolean completed = jsonReceived.getBoolean("completed");



            stream.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static String convertStreamToString(java.io.InputStream is) {
            return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
    }





}
