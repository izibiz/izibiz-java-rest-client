package response;

public class DataSeries {
    Long id;
    Long accountId;
    Long lasId;
    String prefix;
    Long yearPrefix;
    Long prevLastId;
    Long prevYearPrefix;
    String isMaster;
    String isActive;
    String lastIssueDate;
    String subType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getLasId() {
        return lasId;
    }

    public void setLasId(Long lasId) {
        this.lasId = lasId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Long getYearPrefix() {
        return yearPrefix;
    }

    public void setYearPrefix(Long yearPrefix) {
        this.yearPrefix = yearPrefix;
    }

    public Long getPrevLastId() {
        return prevLastId;
    }

    public void setPrevLastId(Long prevLastId) {
        this.prevLastId = prevLastId;
    }

    public Long getPrevYearPrefix() {
        return prevYearPrefix;
    }

    public void setPrevYearPrefix(Long prevYearPrefix) {
        this.prevYearPrefix = prevYearPrefix;
    }

    public String getMaster() {
        return isMaster;
    }

    public void setMaster(String master) {
        isMaster = master;
    }

    public String getActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }

    public String getLastIssueDate() {
        return lastIssueDate;
    }

    public void setLastIssueDate(String lastIssueDate) {
        this.lastIssueDate = lastIssueDate;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
