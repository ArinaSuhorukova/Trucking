package by.itechart.Server.dto;

import by.itechart.Server.entity.Invoice;

import java.time.LocalDate;

public class InvoiceDto {

    private int id;

    private Invoice.Status status;

    private String number;

    private LocalDate dateOfIssue;

    private LocalDate dateOfCheck;

    private UserDto dispatcherFrom;

    private UserDto dispatcherTo;

    private UserDto manager;

    private RequestDto request;


    private InvoiceDto() {
    }

    public static Builder builder() {
        return new InvoiceDto().new Builder();
    }

    public Invoice.Status getStatus() {
        return status;
    }

    public void setStatus(final Invoice.Status status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(final LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(final LocalDate dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDto getDispatcherFrom() {
        return dispatcherFrom;
    }

    public void setDispatcherFrom(final UserDto dispatcherFrom) {
        this.dispatcherFrom = dispatcherFrom;
    }

    public UserDto getDispatcherTo() {
        return dispatcherTo;
    }

    public void setDispatcherTo(final UserDto dispatcherTo) {
        this.dispatcherTo = dispatcherTo;
    }

    public UserDto getManager() {
        return manager;
    }

    public void setManager(final UserDto manager) {
        this.manager = manager;
    }

    public RequestDto getRequest() {
        return request;
    }

    public void setRequest(final RequestDto request) {
        this.request = request;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            InvoiceDto.this.id = id;
            return this;
        }

        public Builder withStatus(final Invoice.Status status) {
            InvoiceDto.this.status = status;
            return this;
        }

        public Builder withNumber(final String number) {
            InvoiceDto.this.number = number;
            return this;
        }

        public Builder withDateOfIssue(final LocalDate dateOfIssue) {
            InvoiceDto.this.dateOfIssue = dateOfIssue;
            return this;
        }

        public Builder withDateOfCheck(final LocalDate dateOfCheck) {
            InvoiceDto.this.dateOfCheck = dateOfCheck;
            return this;
        }

        public Builder withDispatcherFrom(final UserDto dispatcherFrom) {
            InvoiceDto.this.dispatcherFrom = dispatcherFrom;
            return this;
        }

        public Builder withDispatcherTo(final UserDto dispatcherTo) {
            InvoiceDto.this.dispatcherTo = dispatcherTo;
            return this;
        }

        public Builder withManager(final UserDto manager) {
            InvoiceDto.this.manager = manager;
            return this;
        }

        public Builder withRequest(final RequestDto request) {
            InvoiceDto.this.request = request;
            return this;
        }

        public InvoiceDto build() {
            return InvoiceDto.this;
        }
    }

}