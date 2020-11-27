package project.back.back.util;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import java.io.File;
import java.io.IOException;



public class MultipartFileUploadClient {

    private static final String API_KEY = "4";
    private static final String SERVER_URL = "http://localhost:8090/api/v1/media/upload";
    public static String response_media_upload;




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

    public void getResponse_media_upload(String response_media_upload) {
        this.response_media_upload = response_media_upload;
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
        System.out.println("Response :\n"+response.getBody());
    }
}
