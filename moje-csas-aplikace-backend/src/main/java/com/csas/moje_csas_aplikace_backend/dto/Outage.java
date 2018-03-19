
package com.csas.moje_csas_aplikace_backend.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outageDate",
    "outageType",
    "publicNoteCs"
})

@Entity
public class Outage implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
	private int id; 
    
    @JsonProperty("outageDate")
    private String outageDate;
    @JsonProperty("outageType")
    private String outageType;
    @JsonProperty("publicNoteCs")
    private String publicNoteCs;

    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @ManyToOne
    private Item item;

    public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
    @JsonProperty("outageDate")
    public String getOutageDate() {
        return outageDate;
    }

    @JsonProperty("outageDate")
    public void setOutageDate(String outageDate) {
        this.outageDate = outageDate;
    }

    @JsonProperty("outageType")
    public String getOutageType() {
        return outageType;
    }

    @JsonProperty("outageType")
    public void setOutageType(String outageType) {
        this.outageType = outageType;
    }

    @JsonProperty("publicNoteCs")
    public String getPublicNoteCs() {
        return publicNoteCs;
    }

    @JsonProperty("publicNoteCs")
    public void setPublicNoteCs(String publicNoteCs) {
        this.publicNoteCs = publicNoteCs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("outageDate", outageDate).append("outageType", outageType).append("publicNoteCs", publicNoteCs).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(publicNoteCs).append(outageType).append(outageDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Outage) == false) {
            return false;
        }
        Outage rhs = ((Outage) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(publicNoteCs, rhs.publicNoteCs).append(outageType, rhs.outageType).append(outageDate, rhs.outageDate).isEquals();
    }

}
