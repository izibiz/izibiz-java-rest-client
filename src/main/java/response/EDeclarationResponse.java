package response;

public class EDeclarationResponse {
    public ContentEDeclaration[] contents;

    public ContentEDeclaration[] getContent() {return contents;}
    public void setContents(ContentEDeclaration[] contents) {this.contents = contents;}

    public Pageable pageable;

    public Pageable getPageable() {return pageable;}
    public void setPageable(Pageable pageable) {this.pageable = pageable;}


}
