package assignment.pcms.ui.catalog;

import java.sql.Time;
import java.util.Date;

public class Catalog {
    private String referenceNumber;
    private String catalogTitle;
    private String catalogDescription;
    private String seasonPeriod;
    private String creator;
    private Date dateCreated;

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getCatalogTitle() {
        return catalogTitle;
    }

    public void setCatalogTitle(String catalogTitle) {
        this.catalogTitle = catalogTitle;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public String getSeasonPeriod() {
        return seasonPeriod;
    }

    public void setSeasonPeriod(String seasonPeriod) {
        this.seasonPeriod = seasonPeriod;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Time getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Time timeCreated) {
        this.timeCreated = timeCreated;
    }

    private Time timeCreated;

}
