package by.itechart.server.entity;

import by.itechart.server.dto.WayBillDto;
import by.itechart.server.transformers.ToDtoTransformer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "waybill")
public class WayBill implements ToDtoTransformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    @Column(name = "status")
    private Status status;

    /**
     * One waybill can only belong to one invoice.
     * In one invoice can be only one waybill.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @NotNull(message = "Date from cannot be null")
    @Past(message = "Wrong date from")
    @Column(name = "date_from")
    private LocalDate dateFrom;

    @NotNull(message = "Date to cannot be null")
    @Column(name = "date_to")
    private LocalDate dateTo;

    /**
     * In one wayBill may be several checkpoints.
     */
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "wayBill",
            cascade = CascadeType.ALL)
    private List<Checkpoint> checkpoints = new ArrayList<>();

    @Override
    public WayBillDto transformToDto() {
        return WayBillDto.builder()
                .withId(this.id)
                .withCheckpoints(this.checkpoints.stream().map(Checkpoint::transformToDto).collect(Collectors.toList()))
                .withDateFrom(this.dateFrom)
                .withDateTo(this.dateTo)
                .withStatus(this.status)
                .withInvoice(this.invoice.transformToDto())
                .build();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(final Invoice invoice) {
        this.invoice = invoice;
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

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WayBill wayBill = (WayBill) o;
        return Objects.equals(id, wayBill.id) &&
                Objects.equals(status, wayBill.status) &&
                Objects.equals(invoice, wayBill.invoice) &&
                Objects.equals(dateFrom, wayBill.dateFrom) &&
                Objects.equals(dateTo, wayBill.dateTo) &&
                Objects.equals(checkpoints, wayBill.checkpoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, invoice, dateFrom, dateTo, checkpoints);
    }

    @Override
    public String toString() {
        return "WayBill{" +
                "id=" + id +
                ", status=" + status +
                ", invoice=" + invoice +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", checkpoints=" + checkpoints +
                '}';
    }

    public enum Status {
        STARTED,
        FINISHED,
        EXECUTED
    }
}