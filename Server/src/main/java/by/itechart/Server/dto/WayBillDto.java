package by.itechart.Server.dto;

import by.itechart.Server.entity.WayBill;

import java.time.LocalDate;
import java.util.List;

public class WayBillDto {

    private Integer id;

    private WayBill.Status status;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private List<CheckpointDto> checkpoints;

    private InvoiceDto invoice;

    private WayBillDto() {
    }

    public static Builder builder() {
        return new WayBillDto().new Builder();
    }

    public WayBill.Status getStatus() {
        return status;
    }

    public void setStatus(final WayBill.Status status) {
        this.status = status;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(final LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(final LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public List<CheckpointDto> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(final List<CheckpointDto> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            WayBillDto.this.id = id;
            return this;
        }

        public Builder withCheckpoints(final List<CheckpointDto> checkpoints) {
            WayBillDto.this.checkpoints = checkpoints;
            return this;
        }

        public Builder withStatus(final WayBill.Status status) {
            WayBillDto.this.status = status;
            return this;
        }

        public Builder withDateFrom(final LocalDate dateFrom) {
            WayBillDto.this.dateFrom = dateFrom;
            return this;
        }

        public Builder withDateTo(final LocalDate dateTo) {
            WayBillDto.this.dateTo = dateTo;
            return this;
        }


        public Builder withInvoice(final InvoiceDto invoice) {
            WayBillDto.this.invoice = invoice;
            return this;
        }

        public WayBillDto build() {
            return WayBillDto.this;
        }
    }
}