package response;

public class ECheckResponse {
    public ContentECheck[] contents;

    public ContentECheck[] getContent() {return contents;}
    public void setContents(ContentECheck[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}

    public Object filters;

    public Object getFilters() {return filters;}
    public void setFilters(Object filters) {this.filters = filters;}
}
