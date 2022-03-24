package response;

public class EInvoiceResponse {

    public Content[] contents;
    public Content[] getContent() {return contents;}
    public void setContents(Content[] contents) {this.contents = contents;}

    public Pageable pageable;
    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}

    public Object filters;
    public Object getFilters() {return filters;}
    public void setFilters(Object filters) {this.filters = filters;}

}

