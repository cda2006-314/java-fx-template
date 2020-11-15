package project.back.back.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WEBSITETHEME_HAS_API", schema = "dbo" )
@IdClass(WebsitethemeHasApiPK.class)
public class WebsitethemeHasApi {
    private int websitethemeId;
    private int apiId;

    @Id
    @Column(name = "WEBSITETHEME_ID", nullable = false, precision = 0)
    public int getWebsitethemeId() {
        return websitethemeId;
    }

    public void setWebsitethemeId(int websitethemeId) {
        this.websitethemeId = websitethemeId;
    }

    @Id
    @Column(name = "API_ID", nullable = false, precision = 0)
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
        WebsitethemeHasApi that = (WebsitethemeHasApi) o;
        return websitethemeId == that.websitethemeId &&
                apiId == that.apiId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(websitethemeId, apiId);
    }
}
