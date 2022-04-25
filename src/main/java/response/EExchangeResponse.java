package response;

public class EExchangeResponse {
    public ContentEExchange[] contents;

    public ContentEExchange[] getContent() {return contents;}
    public void setContents(ContentEExchange[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}
}
