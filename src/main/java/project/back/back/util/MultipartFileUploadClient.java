package project.back.back.util;

import com.google.gson.Gson;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.MultiValueMap;
import project.back.back.model.Picture;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


public class MultipartFileUploadClient {

    private static final String API_KEY = "4";
    private static final String SERVER_URL = "http://localhost:8090/api/v1/media/upload";
    public static String response_media_upload;
    public String id;
    public String data;
    public String filename;

public static void main(String []args){
    MultipartFileUploadClient mp =  new MultipartFileUploadClient();
  //  mp.sendFile("C:\\Users\\Charlène\\Downloads\\outils-de-cuisine.png");
mp.sendFile("C:\\Users\\Charlène\\Desktop\\Projet groupe n-Tiers\\Web Angular\\fonts\\Epilogue.zip");

}
    /**
     * Provide url image to send
     * @param urlImage
     * @return
     */

    public String give_UrlFile(String urlImage){
        return urlImage;
    }

    /**
     * We use this method for print the new id of the media in our GUI JavaFX
     *
     * @return id_media
     */
    public String getResponse_media_upload() {
        return response_media_upload;
    }


    public void sendFile(String filepath){

        // Open a file that is going to be sent

        File file = new File(filepath);
        FileSystemResource fileSystemResource = new FileSystemResource(file);

        // Setup headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.add("api-key", API_KEY);

        // Body building - including the file above
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", fileSystemResource);

        // Request processing
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        String serverUrl = SERVER_URL;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.postForEntity(serverUrl, requestEntity, String.class);

        // Displays the response
        System.out.println("Response code: " + response.getStatusCode());
        response_media_upload = response.getBody();
        String idPicture = response_media_upload.substring(25,49);
        System.out.println("test"  + idPicture);
        System.out.println("Response :\n"+response.getBody() + "\n");

    }


}
