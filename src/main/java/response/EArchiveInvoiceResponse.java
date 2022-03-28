package response;

public class EArchiveInvoiceResponse {
    public ContentEArchiveInvoice[] contents;

    public ContentEArchiveInvoice[] getContent() {return contents;}
    public void setContents(ContentEArchiveInvoice[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}

    public Object filters;

    public Object getFilters() {return filters;}
    public void setFilters(Object filters) {this.filters = filters;}
}
