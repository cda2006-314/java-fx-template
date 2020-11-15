package project.back.back.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WebsitethemeHasApiPK implements Serializable {
    private int websitethemeId;
    private int apiId;

    @Column(name = "WEBSITETHEME_ID", nullable = false, precision = 0)
    @Id
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Column(name = "API_ID", nullable = false, precision = 0)
    @Id
    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebsitethemeHasApiPK that = (WebsitethemeHasApiPK) o;
        return websitethemeId == that.websitethemeId &&
                apiId == that.apiId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, apiId);
    }
}
