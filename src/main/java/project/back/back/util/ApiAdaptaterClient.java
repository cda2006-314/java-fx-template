package project.back.back.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiAdaptaterClient {

    private static final String JSON_URL = "http://localhost:8090/api/v1/media/upload";
    private static final String API_KEY = "4";
    private String imageUrl;
    private Image image;
    static BufferedImage bimg;
    byte[] bytes;
    static String boundary = "--WebAppBoundary";
    private static String filename;

    public static void main(String[] args) {
        try {

            URL url = new URL(JSON_URL);//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Api-Key", API_KEY);
            conn.setRequestProperty("Content-Disposition", "form-data");
            conn.setRequestProperty("name", "file");
            conn.setRequestProperty("filename", filename);
            conn.setRequestProperty("Content-Type", "image/png");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}
