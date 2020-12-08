package project.back.back.controller;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.back.back.model.MediaFile;
import project.back.back.services.MediaFileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@RestController
@RequestMapping("/api/v2/media")
public class MediaFileController {

    @Autowired
    private MediaFileService mediaFileService;

    @GetMapping("/download/{id}")
    public void download(@PathVariable("id") String fileID, HttpServletResponse response) throws IOException {

        // Looking for the file in DB
        MediaFile mediaFile = mediaFileService.getByID(fileID);
        if (mediaFile == null || mediaFile.getInputStream() == null){
            return;
        }
        // Get your file stream from wherever.
        InputStream myStream = mediaFile.getInputStream();

        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "attachment;filename="+mediaFile.getName());
        response.setContentType(mediaFile.getContentType());

        // Copy the stream to the response's output stream.
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }

/*
    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {

        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }

        MediaFile mediaFile = new MediaFile();

        mediaFile.setInputStream(file.getInputStream());
        mediaFile.setName(file.getOriginalFilename());
        mediaFile.setContentType(file.getContentType());
        mediaFile.setSize(file.getSize());
        mediaFile.setDate(new Date());

        // Saves the media and returns the ID into this MediaFile
        mediaFile.setId(mediaFileService.save(mediaFile));

        // Converts the member into JSON

        String response = mediaFile.getId();

        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
*/
    @GetMapping("/display/{id}")
    public void display(@PathVariable("id") String imageID, HttpServletResponse response) throws IOException {

        // Looking for the file in DB
        MediaFile mediaFile = mediaFileService.getByID(imageID);
        if (mediaFile == null || mediaFile.getInputStream() == null){
            return;
        }
        // Get your file stream from wherever.
        InputStream myStream = mediaFile.getInputStream();

        // Set the content type
        response.setContentType(mediaFile.getContentType());

        // Copy the stream to the response's output stream.
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }


}
