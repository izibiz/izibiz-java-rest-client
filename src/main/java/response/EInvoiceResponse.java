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
class Pageable{
    public int page;
    public int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int totalElements;
    public int totalPages;
}

class Content{
    public int id;
    public Object documentType;
    public String issueDate;
    public Object issueTime;
    public String createDate;
    public String uuid;
    public String documentNo;
    public String currency;
    public String direction;
    public String readStatus;
    public DocumentStatus documentStatus;
    public String amount;
    public String taxAmount;
    public int lineCount;
    public String profile;
    public String erpReadFlag;
    public AccountingSupplier accountingSupplier;
    public AccountingCustomer accountingCustomer;
    public String supplierAlias;
    public String customerAlias;
    public String supplierSSN;
    public String customerSSN;
    public String type;
    public String invoiceType;
    public String statusDesc;
    public String note;
    public String responseDescription;
    public String orderReference;
    public String orderReferenceDate;
    public Envelope envelope;
    public String gtbRegistrationNo;
    public String gtbExportDate;
    public String gtbRefNo;
    public int statusCode;
    public String statusCodeDesc;
    public String supplierName;
    public String customerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Object documentType) {
        this.documentType = documentType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Object getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Object issueTime) {
        this.issueTime = issueTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public Object getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(DocumentStatus documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getErpReadFlag() {
        return erpReadFlag;
    }

    public void setErpReadFlag(String erpReadFlag) {
        this.erpReadFlag = erpReadFlag;
    }

    public Object getAccountingSupplier() {
        return accountingSupplier;
    }

    public void setAccountingSupplier(AccountingSupplier accountingSupplier) {
        this.accountingSupplier = accountingSupplier;
    }

    public Object getAccountingCustomer() {
        return accountingCustomer;
    }

    public void setAccountingCustomer(AccountingCustomer accountingCustomer) {
        this.accountingCustomer = accountingCustomer;
    }

    public String getSupplierAlias() {
        return supplierAlias;
    }

    public void setSupplierAlias(String supplierAlias) {
        this.supplierAlias = supplierAlias;
    }

    public String getCustomerAlias() {
        return customerAlias;
    }

    public void setCustomerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
    }

    public String getSupplierSSN() {
        return supplierSSN;
    }

    public void setSupplierSSN(String supplierSSN) {
        this.supplierSSN = supplierSSN;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getOrderReferenceDate() {
        return orderReferenceDate;
    }

    public void setOrderReferenceDate(String orderReferenceDate) {
        this.orderReferenceDate = orderReferenceDate;
    }

    public Object getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = envelope;
    }

    public String getGtbRegistrationNo() {
        return gtbRegistrationNo;
    }

    public void setGtbRegistrationNo(String gtbRegistrationNo) {
        this.gtbRegistrationNo = gtbRegistrationNo;
    }

    public String getGtbExportDate() {
        return gtbExportDate;
    }

    public void setGtbExportDate(String gtbExportDate) {
        this.gtbExportDate = gtbExportDate;
    }

    public String getGtbRefNo() {
        return gtbRefNo;
    }

    public void setGtbRefNo(String gtbRefNo) {
        this.gtbRefNo = gtbRefNo;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCodeDesc() {
        return statusCodeDesc;
    }

    public void setStatusCodeDesc(String statusCodeDesc) {
        this.statusCodeDesc = statusCodeDesc;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}

class DocumentStatus{
    public String value;
    public Object label;
    public String color;
    public Object options;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }
}

class AccountingSupplier{
    public String identifier;
    public String name;
    public Object alias;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAlias() {
        return alias;
    }

    public void setAlias(Object alias) {
        this.alias = alias;
    }
}

class AccountingCustomer{
    public String identifier;
    public String name;
    public Object alias;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAlias() {
        return alias;
    }

    public void setAlias(Object alias) {
        this.alias = alias;
    }
}

class Envelope{
    public Object getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Object identifier) {
        this.identifier = identifier;
    }

    public Object identifier;

}

