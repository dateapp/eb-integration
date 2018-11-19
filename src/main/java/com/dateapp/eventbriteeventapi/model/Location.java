
package com.dateapp.eventbriteeventapi.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "augmented_location",
    "within",
    "longitude",
    "address"
})
public class Location {

    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("augmented_location")
    private AugmentedLocation augmentedLocation;
    @JsonProperty("within")
    private String within;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("address")
    private String address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("augmented_location")
    public AugmentedLocation getAugmentedLocation() {
        return augmentedLocation;
    }

    @JsonProperty("augmented_location")
    public void setAugmentedLocation(AugmentedLocation augmentedLocation) {
        this.augmentedLocation = augmentedLocation;
    }

    @JsonProperty("within")
    public String getWithin() {
        return within;
    }

    @JsonProperty("within")
    public void setWithin(String within) {
        this.within = within;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
