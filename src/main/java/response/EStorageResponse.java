package response;

public class EStorageResponse {
    public ContentEStorage[] contents;

    public ContentEStorage[] getContent() {return contents;}
    public void setContents(ContentEStorage[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}

    public Object filters;

    public Object getFilters() {return filters;}
    public void setFilters(Object filters) {this.filters = filters;}
}
