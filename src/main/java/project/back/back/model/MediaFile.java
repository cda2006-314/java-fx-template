package project.back.back.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document
public class MediaFile {

    public final static String METADATA_CONTENT_TYPE = "_contentType";

    @Id
    private String id;
    private String name;
    private long size;
    private String md5;
    private Date date;
    private InputStream inputStream;
    private Map<String, String> metadata;


    public MediaFile(){
        metadata = new HashMap<String, String>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public void setContentType(String contentType){
        metadata.put(METADATA_CONTENT_TYPE, contentType);
    }
    public String getContentType(){
        return metadata.get(METADATA_CONTENT_TYPE);
    }
}
