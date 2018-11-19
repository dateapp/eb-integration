
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
    "name",
    "description",
    "id",
    "url",
    "vanity_url",
    "start",
    "end",
    "organization_id",
    "created",
    "changed",
    "capacity",
    "capacity_is_custom",
    "status",
    "currency",
    "listed",
    "shareable",
    "online_event",
    "tx_time_limit",
    "hide_start_date",
    "hide_end_date",
    "locale",
    "is_locked",
    "privacy_setting",
    "is_series",
    "is_series_parent",
    "is_reserved_seating",
    "show_pick_a_seat",
    "show_seatmap_thumbnail",
    "show_colors_in_seatmap_thumbnail",
    "source",
    "is_free",
    "version",
    "logo_id",
    "organizer_id",
    "venue_id",
    "category_id",
    "subcategory_id",
    "format_id",
    "resource_uri",
    "is_externally_ticketed",
    "logo"
})
public class Event {

    @JsonProperty("name")
    private Name name;
    @JsonProperty("description")
    private Description description;
    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("vanity_url")
    private String vanityUrl;
    @JsonProperty("start")
    private Start start;
    @JsonProperty("end")
    private End end;
    @JsonProperty("organization_id")
    private String organizationId;
    @JsonProperty("created")
    private String created;
    @JsonProperty("changed")
    private String changed;
    @JsonProperty("capacity")
    private Object capacity;
    @JsonProperty("capacity_is_custom")
    private Object capacityIsCustom;
    @JsonProperty("status")
    private String status;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("listed")
    private Boolean listed;
    @JsonProperty("shareable")
    private Boolean shareable;
    @JsonProperty("online_event")
    private Boolean onlineEvent;
    @JsonProperty("tx_time_limit")
    private Integer txTimeLimit;
    @JsonProperty("hide_start_date")
    private Boolean hideStartDate;
    @JsonProperty("hide_end_date")
    private Boolean hideEndDate;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("is_locked")
    private Boolean isLocked;
    @JsonProperty("privacy_setting")
    private String privacySetting;
    @JsonProperty("is_series")
    private Boolean isSeries;
    @JsonProperty("is_series_parent")
    private Boolean isSeriesParent;
    @JsonProperty("is_reserved_seating")
    private Boolean isReservedSeating;
    @JsonProperty("show_pick_a_seat")
    private Boolean showPickASeat;
    @JsonProperty("show_seatmap_thumbnail")
    private Boolean showSeatmapThumbnail;
    @JsonProperty("show_colors_in_seatmap_thumbnail")
    private Boolean showColorsInSeatmapThumbnail;
    @JsonProperty("source")
    private String source;
    @JsonProperty("is_free")
    private Boolean isFree;
    @JsonProperty("version")
    private String version;
    @JsonProperty("logo_id")
    private String logoId;
    @JsonProperty("organizer_id")
    private String organizerId;
    @JsonProperty("venue_id")
    private String venueId;
    @JsonProperty("category_id")
    private String categoryId;
    @JsonProperty("subcategory_id")
    private String subcategoryId;
    @JsonProperty("format_id")
    private String formatId;
    @JsonProperty("resource_uri")
    private String resourceUri;
    @JsonProperty("is_externally_ticketed")
    private Boolean isExternallyTicketed;
    @JsonProperty("logo")
    private Logo logo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("description")
    public Description getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Description description) {
        this.description = description;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("vanity_url")
    public String getVanityUrl() {
        return vanityUrl;
    }

    @JsonProperty("vanity_url")
    public void setVanityUrl(String vanityUrl) {
        this.vanityUrl = vanityUrl;
    }

    @JsonProperty("start")
    public Start getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Start start) {
        this.start = start;
    }

    @JsonProperty("end")
    public End getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(End end) {
        this.end = end;
    }

    @JsonProperty("organization_id")
    public String getOrganizationId() {
        return organizationId;
    }

    @JsonProperty("organization_id")
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("changed")
    public String getChanged() {
        return changed;
    }

    @JsonProperty("changed")
    public void setChanged(String changed) {
        this.changed = changed;
    }

    @JsonProperty("capacity")
    public Object getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Object capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("capacity_is_custom")
    public Object getCapacityIsCustom() {
        return capacityIsCustom;
    }

    @JsonProperty("capacity_is_custom")
    public void setCapacityIsCustom(Object capacityIsCustom) {
        this.capacityIsCustom = capacityIsCustom;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("listed")
    public Boolean getListed() {
        return listed;
    }

    @JsonProperty("listed")
    public void setListed(Boolean listed) {
        this.listed = listed;
    }

    @JsonProperty("shareable")
    public Boolean getShareable() {
        return shareable;
    }

    @JsonProperty("shareable")
    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    @JsonProperty("online_event")
    public Boolean getOnlineEvent() {
        return onlineEvent;
    }

    @JsonProperty("online_event")
    public void setOnlineEvent(Boolean onlineEvent) {
        this.onlineEvent = onlineEvent;
    }

    @JsonProperty("tx_time_limit")
    public Integer getTxTimeLimit() {
        return txTimeLimit;
    }

    @JsonProperty("tx_time_limit")
    public void setTxTimeLimit(Integer txTimeLimit) {
        this.txTimeLimit = txTimeLimit;
    }

    @JsonProperty("hide_start_date")
    public Boolean getHideStartDate() {
        return hideStartDate;
    }

    @JsonProperty("hide_start_date")
    public void setHideStartDate(Boolean hideStartDate) {
        this.hideStartDate = hideStartDate;
    }

    @JsonProperty("hide_end_date")
    public Boolean getHideEndDate() {
        return hideEndDate;
    }

    @JsonProperty("hide_end_date")
    public void setHideEndDate(Boolean hideEndDate) {
        this.hideEndDate = hideEndDate;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("is_locked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("is_locked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("privacy_setting")
    public String getPrivacySetting() {
        return privacySetting;
    }

    @JsonProperty("privacy_setting")
    public void setPrivacySetting(String privacySetting) {
        this.privacySetting = privacySetting;
    }

    @JsonProperty("is_series")
    public Boolean getIsSeries() {
        return isSeries;
    }

    @JsonProperty("is_series")
    public void setIsSeries(Boolean isSeries) {
        this.isSeries = isSeries;
    }

    @JsonProperty("is_series_parent")
    public Boolean getIsSeriesParent() {
        return isSeriesParent;
    }

    @JsonProperty("is_series_parent")
    public void setIsSeriesParent(Boolean isSeriesParent) {
        this.isSeriesParent = isSeriesParent;
    }

    @JsonProperty("is_reserved_seating")
    public Boolean getIsReservedSeating() {
        return isReservedSeating;
    }

    @JsonProperty("is_reserved_seating")
    public void setIsReservedSeating(Boolean isReservedSeating) {
        this.isReservedSeating = isReservedSeating;
    }

    @JsonProperty("show_pick_a_seat")
    public Boolean getShowPickASeat() {
        return showPickASeat;
    }

    @JsonProperty("show_pick_a_seat")
    public void setShowPickASeat(Boolean showPickASeat) {
        this.showPickASeat = showPickASeat;
    }

    @JsonProperty("show_seatmap_thumbnail")
    public Boolean getShowSeatmapThumbnail() {
        return showSeatmapThumbnail;
    }

    @JsonProperty("show_seatmap_thumbnail")
    public void setShowSeatmapThumbnail(Boolean showSeatmapThumbnail) {
        this.showSeatmapThumbnail = showSeatmapThumbnail;
    }

    @JsonProperty("show_colors_in_seatmap_thumbnail")
    public Boolean getShowColorsInSeatmapThumbnail() {
        return showColorsInSeatmapThumbnail;
    }

    @JsonProperty("show_colors_in_seatmap_thumbnail")
    public void setShowColorsInSeatmapThumbnail(Boolean showColorsInSeatmapThumbnail) {
        this.showColorsInSeatmapThumbnail = showColorsInSeatmapThumbnail;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("is_free")
    public Boolean getIsFree() {
        return isFree;
    }

    @JsonProperty("is_free")
    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("logo_id")
    public String getLogoId() {
        return logoId;
    }

    @JsonProperty("logo_id")
    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    @JsonProperty("organizer_id")
    public String getOrganizerId() {
        return organizerId;
    }

    @JsonProperty("organizer_id")
    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }

    @JsonProperty("venue_id")
    public String getVenueId() {
        return venueId;
    }

    @JsonProperty("venue_id")
    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    @JsonProperty("category_id")
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("category_id")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("subcategory_id")
    public String getSubcategoryId() {
        return subcategoryId;
    }

    @JsonProperty("subcategory_id")
    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @JsonProperty("format_id")
    public String getFormatId() {
        return formatId;
    }

    @JsonProperty("format_id")
    public void setFormatId(String formatId) {
        this.formatId = formatId;
    }

    @JsonProperty("resource_uri")
    public String getResourceUri() {
        return resourceUri;
    }

    @JsonProperty("resource_uri")
    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    @JsonProperty("is_externally_ticketed")
    public Boolean getIsExternallyTicketed() {
        return isExternallyTicketed;
    }

    @JsonProperty("is_externally_ticketed")
    public void setIsExternallyTicketed(Boolean isExternallyTicketed) {
        this.isExternallyTicketed = isExternallyTicketed;
    }

    @JsonProperty("logo")
    public Logo getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(Logo logo) {
        this.logo = logo;
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
