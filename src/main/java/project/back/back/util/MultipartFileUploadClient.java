package project.back.back.util;

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
    public static String id_media;

    public static void main(String[] args) throws IOException {
      String  urlImage = give_UrlFile("src/main/resources/project/front/javafx/IMG/system.png");
        sendFile(urlImage);
    }


    /**
     * Provide url image to send
     * @param urlImage
     * @return
     */

    public static String give_UrlFile(String urlImage){
        return urlImage;
    }

    /**
     * We use this method for print the new id of the media in our GUI JavaFX
     *
     * @return id_media
     */
    public String getId_media() {
        return id_media;
    }

    public void setId_media(String id_media) {
        this.id_media = id_media;
    }

    private static void sendFile(String filepath){

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
        id_media = response.getBody();
        System.out.println("Response :\n"+response.getBody());
    }
}
