package project.back.back.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parameter {
    private String parameterKey;
    private String parameterValue;

    @Id
    @Column(name = "PARAMETER_KEY", nullable = false, length = 256)
    public String getParameterKey() {
        return parameterKey;
    }

    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
    }

    @Basic
    @Column(name = "PARAMETER_VALUE", nullable = false, length = 8000)
    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(parameterKey, parameter.parameterKey) &&
                Objects.equals(parameterValue, parameter.parameterValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterKey, parameterValue);
    }
}
