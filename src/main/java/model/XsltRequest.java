package model;

public class XsltRequest {
    String name;
    String description;
    String content;

    public XsltRequest(String name, String description, String content) {
        this.name = name;
        this.description = description;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
