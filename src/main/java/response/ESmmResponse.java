package response;

public class ESmmResponse {
    public ContentESmm[] contents;

    public ContentESmm[] getContent() {return contents;}
    public void setContents(ContentESmm[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}

    public Object filters;

    public Object getFilters() {return filters;}
    public void setFilters(Object filters) {this.filters = filters;}
}
