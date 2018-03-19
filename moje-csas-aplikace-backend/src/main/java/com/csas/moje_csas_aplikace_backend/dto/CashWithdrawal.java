
package com.csas.moje_csas_aplikace_backend.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limit",
    "excessDeadline"
})

@Entity
public class CashWithdrawal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
	private int id; 
	@JsonProperty("limit")
    private Long limit;
    @JsonProperty("excessDeadline")
    private String excessDeadline;
    
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
   @OneToOne
    private Item item;

    public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @JsonProperty("excessDeadline")
    public String getExcessDeadline() {
        return excessDeadline;
    }

    @JsonProperty("excessDeadline")
    public void setExcessDeadline(String excessDeadline) {
        this.excessDeadline = excessDeadline;
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
        return new ToStringBuilder(this).append("limit", limit).append("excessDeadline", excessDeadline).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(limit).append(excessDeadline).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CashWithdrawal) == false) {
            return false;
        }
        CashWithdrawal rhs = ((CashWithdrawal) other);
        return new EqualsBuilder().append(limit, rhs.limit).append(excessDeadline, rhs.excessDeadline).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
