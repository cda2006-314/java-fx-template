package project.back.back.services;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import project.back.back.model.MediaFile;
import project.back.back.repository.MediaFileRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Service
public class MediaFileService {

    @Autowired
    private MediaFileRepository mediaFileRepository;
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFsOperations gridFsOperations;

    public MediaFile getByID(String id) throws IllegalStateException, IOException {

        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        // File is not in DB
        if(file == null){
            return null;
        }
        // File has no metadata
        if(file.getMetadata() == null){
            return null;
        }
        // File has no contentType metadata
        if(file.getMetadata().get("_contentType") == null){
            return null;
        }

        MediaFile mediaFile = new MediaFile();
        mediaFile.setName(file.getFilename());
        for(String key : file.getMetadata().keySet()){
            mediaFile.getMetadata().put(key, file.getMetadata().get(key).toString());
        }
        mediaFile.setInputStream(gridFsOperations.getResource(file).getInputStream());

        return mediaFile;
    }

    public String save(MediaFile mediaFile){

        String filename = mediaFile.getName();
        InputStream inputStream = mediaFile.getInputStream();
        Map<String,String> metadata = mediaFile.getMetadata();
        String contentType = (metadata.get("contentType") == null ? null : metadata.get("contentType"));

        return gridFsTemplate.store(inputStream, filename, contentType, metadata).toString();
    }

}
