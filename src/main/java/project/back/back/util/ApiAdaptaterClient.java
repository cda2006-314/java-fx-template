package project.back.back.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
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
        sendFile("src/main/resources/application.properties");

        /*
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
        */
    }

    private static void sendFile(String filepath){

        // Open a file that is going to be sent
        File file = new File(filepath);
        FileSystemResource fileSystemResource = new FileSystemResource(file);

        // Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("api-key", "49a8z4e98a4ze");

        // Body building - including the file above
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileSystemResource);

        // Request processing
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serverUrl = "http://localhost:8090/api/v1/media/upload";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);

        // Displays the response
        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response :\n"+response.getBody());
    }
}
