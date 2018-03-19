
package com.csas.moje_csas_aplikace_backend.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    "id",
    "location",
    "type",
    "state",
    "name",
    "address",
    "city",
    "postCode",
    "country",
    "region",
    "cashWithdrawal",
    "district",
    "email",
    "phones",
    "moreBuildings",
    "managerName",
    "courierCode",
    "branchNum",
    "equipment",
    "manager",
    "outages"
})

@Entity
public class Item implements Serializable{

	@Id
	@JsonProperty("id")
    private Long id;
    
	@OneToOne
	@JsonProperty("location")   
    private Location location;
    @JsonProperty("type")
    private String type;
    @JsonProperty("state")
    private String state;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;
    
    @OneToOne
    @JsonProperty("cashWithdrawal")
    private CashWithdrawal cashWithdrawal;
    @JsonProperty("district")
    private String district;
    @JsonProperty("email")
    private String email;
    
	@ElementCollection
	@CollectionTable(name="phones", joinColumns=@JoinColumn(name="id"))
    @JsonProperty("phones")
    private List<String> phones = null;
    @JsonProperty("moreBuildings")
    private Boolean moreBuildings;
    @JsonProperty("managerName")
    private String managerName;
    @JsonProperty("courierCode")
    private String courierCode;
    @JsonProperty("branchNum")
    private String branchNum;
    
	@ElementCollection
	@CollectionTable(name="equipmentTable", joinColumns=@JoinColumn(name="id"))
    @JsonProperty("equipment")
    private List<Equipment> equipment = null;
    
    @OneToOne
    @JsonProperty("manager")
    private Manager manager;
    
	@ElementCollection
	@CollectionTable(name="outagesTable", joinColumns=@JoinColumn(name="id"))    
    @JsonProperty("outages")
    private List<Outage> outages = null;
    
    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("postCode")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("postCode")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("cashWithdrawal")
    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    @JsonProperty("cashWithdrawal")
    public void setCashWithdrawal(CashWithdrawal cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    @JsonProperty("district")
    public String getDistrict() {
        return district;
    }

    @JsonProperty("district")
    public void setDistrict(String district) {
        this.district = district;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phones")
    public List<String> getPhones() {
        return phones;
    }

    @JsonProperty("phones")
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @JsonProperty("moreBuildings")
    public Boolean getMoreBuildings() {
        return moreBuildings;
    }

    @JsonProperty("moreBuildings")
    public void setMoreBuildings(Boolean moreBuildings) {
        this.moreBuildings = moreBuildings;
    }

    @JsonProperty("managerName")
    public String getManagerName() {
        return managerName;
    }

    @JsonProperty("managerName")
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @JsonProperty("courierCode")
    public String getCourierCode() {
        return courierCode;
    }

    @JsonProperty("courierCode")
    public void setCourierCode(String courierCode) {
        this.courierCode = courierCode;
    }

    @JsonProperty("branchNum")
    public String getBranchNum() {
        return branchNum;
    }

    @JsonProperty("branchNum")
    public void setBranchNum(String branchNum) {
        this.branchNum = branchNum;
    }

    @JsonProperty("equipment")
    public List<Equipment> getEquipment() {
        return equipment;
    }

    @JsonProperty("equipment")
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @JsonProperty("manager")
    public Manager getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @JsonProperty("outages")
    public List<Outage> getOutages() {
        return outages;
    }

    @JsonProperty("outages")
    public void setOutages(List<Outage> outages) {
        this.outages = outages;
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
        return new ToStringBuilder(this).append("id", id).append("location", location).append("type", type).append("state", state).append("name", name).append("address", address).append("city", city).append("postCode", postCode).append("country", country).append("region", region).append("cashWithdrawal", cashWithdrawal).append("district", district).append("email", email).append("phones", phones).append("moreBuildings", moreBuildings).append("managerName", managerName).append("courierCode", courierCode).append("branchNum", branchNum).append("equipment", equipment).append("manager", manager).append("outages", outages).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(manager).append(courierCode).append(location).append(managerName).append(branchNum).append(postCode).append(state).append(outages).append(equipment).append(type).append(phones).append(country).append(city).append(id).append(email).append(address).append(additionalProperties).append(name).append(cashWithdrawal).append(moreBuildings).append(district).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(region, rhs.region).append(manager, rhs.manager).append(courierCode, rhs.courierCode).append(location, rhs.location).append(managerName, rhs.managerName).append(branchNum, rhs.branchNum).append(postCode, rhs.postCode).append(state, rhs.state).append(outages, rhs.outages).append(equipment, rhs.equipment).append(type, rhs.type).append(phones, rhs.phones).append(country, rhs.country).append(city, rhs.city).append(id, rhs.id).append(email, rhs.email).append(address, rhs.address).append(additionalProperties, rhs.additionalProperties).append(name, rhs.name).append(cashWithdrawal, rhs.cashWithdrawal).append(moreBuildings, rhs.moreBuildings).append(district, rhs.district).isEquals();
    }

}
