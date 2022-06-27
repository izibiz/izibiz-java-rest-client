package model;

public class XsltRequest {
    String documentAction;
    Boolean compressed;
    String assignNumber;
    String seriPrefix;
    String content;

    public String getDocumentAction() {
        return documentAction;
    }

    public void setDocumentAction(String documentAction) {
        this.documentAction = documentAction;
    }

    public Boolean getCompressed() {
        return compressed;
    }

    public void setCompressed(Boolean compressed) {
        this.compressed = compressed;
    }

    public String getAssignNumber() {
        return assignNumber;
    }

    public void setAssignNumber(String assignNumber) {
        this.assignNumber = assignNumber;
    }

    public String getSeriPrefix() {
        return seriPrefix;
    }

    public void setSeriPrefix(String seriPrefix) {
        this.seriPrefix = seriPrefix;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
