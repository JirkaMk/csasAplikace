
package com.csas.moje_csas_aplikace_backend.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "pageNumber",
    "pageCount",
    "nextPage",
    "pageSize",
    "totalItemCount",
    "items"
})
public class ATM {

    @JsonProperty("pageNumber")
    private Long pageNumber;
    @JsonProperty("pageCount")
    private Long pageCount;
    @JsonProperty("nextPage")
    private Long nextPage;
    @JsonProperty("pageSize")
    private Long pageSize;
    @JsonProperty("totalItemCount")
    private Long totalItemCount;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("pageNumber")
    public Long getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("pageCount")
    public Long getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty("nextPage")
    public Long getNextPage() {
        return nextPage;
    }

    @JsonProperty("nextPage")
    public void setNextPage(Long nextPage) {
        this.nextPage = nextPage;
    }

    @JsonProperty("pageSize")
    public Long getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageSize")
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("totalItemCount")
    public Long getTotalItemCount() {
        return totalItemCount;
    }

    @JsonProperty("totalItemCount")
    public void setTotalItemCount(Long totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
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
        return new ToStringBuilder(this).append("pageNumber", pageNumber).append("pageCount", pageCount).append("nextPage", nextPage).append("pageSize", pageSize).append("totalItemCount", totalItemCount).append("items", items).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pageCount).append(nextPage).append(items).append(additionalProperties).append(totalItemCount).append(pageSize).append(pageNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ATM) == false) {
            return false;
        }
        ATM rhs = ((ATM) other);
        return new EqualsBuilder().append(pageCount, rhs.pageCount).append(nextPage, rhs.nextPage).append(items, rhs.items).append(additionalProperties, rhs.additionalProperties).append(totalItemCount, rhs.totalItemCount).append(pageSize, rhs.pageSize).append(pageNumber, rhs.pageNumber).isEquals();
    }

}
