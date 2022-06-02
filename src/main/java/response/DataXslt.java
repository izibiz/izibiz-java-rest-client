package response;

import java.util.Base64;

public class DataXslt {
    Long id;
    Long accountId;
    String name;
    String description;
    String isMaster;
    Base64 content;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(String isMaster) {
        this.isMaster = isMaster;
    }

    public Base64 getContent() {
        return content;
    }

    public void setContent(Base64 content) {
        this.content = content;
    }
}
