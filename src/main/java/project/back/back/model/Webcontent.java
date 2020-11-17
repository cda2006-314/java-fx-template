package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Webcontent {
    private int webcontentId;
    private String webcontentLabel;

    @Id
    @Column(name = "WEBCONTENT_ID", nullable = false, precision = 0)
    public int getWebcontentId() {
        return webcontentId;
    }

    public void setWebcontentId(int webcontentId) {
        this.webcontentId = webcontentId;
    }

    @Basic
    @Column(name = "WEBCONTENT_LABEL", nullable = false, length = 1000)
    public String getWebcontentLabel() {
        return webcontentLabel;
    }

    public void setWebcontentLabel(String webcontentLabel) {
        this.webcontentLabel = webcontentLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Webcontent that = (Webcontent) o;
        return webcontentId == that.webcontentId &&
                Objects.equals(webcontentLabel, that.webcontentLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(webcontentId, webcontentLabel);
    }
}