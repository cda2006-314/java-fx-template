package project.back.back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Api {
    private int apiId;
    private String apiLabel;
    private String apiDescription;
    private String apiContenu;
    private Collection<WebsitethemeHasApi> websitethemeHasApisByApiId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "API_ID", nullable = false, precision = 0)
    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    @Basic
    @Column(name = "API_LABEL", nullable = false, length = 100)
    public String getApiLabel() {
        return apiLabel;
    }

    public void setApiLabel(String apiLabel) {
        this.apiLabel = apiLabel;
    }

    @Basic
    @Column(name = "API_CONTENU", nullable = true, length = 1000)
    public String getApiContenu() {
        return apiContenu;
    }

    public void setApiContenu(String apiContenu) {
        this.apiContenu = apiContenu;
    }

    @Basic
    @Column(name = "API_DESCRIPTION", nullable = false, length = 1000)
    public String getApiDescription() {
        return apiDescription;
    }

    public void setApiDescription(String apiDescription) {
        this.apiDescription = apiDescription;
    }
    @Override
    public String toString() {
        return apiLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Api api = (Api) o;
        return apiId == api.apiId &&
                Objects.equals(apiLabel, api.apiLabel) &&
                Objects.equals(apiDescription, api.apiDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiId, apiLabel, apiDescription);
    }

    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(mappedBy = "apiByApiId")
    @JsonIgnore
    public Collection<WebsitethemeHasApi> getWebsitethemeHasApisByApiId() {
        return websitethemeHasApisByApiId;
    }

    public void setWebsitethemeHasApisByApiId(Collection<WebsitethemeHasApi> websitethemeHasApisByApiId) {
        this.websitethemeHasApisByApiId = websitethemeHasApisByApiId;
    }
}
