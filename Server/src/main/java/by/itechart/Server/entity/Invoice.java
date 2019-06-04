package by.itechart.Server.entity;

import by.itechart.Server.dto.InvoiceDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice implements Transformable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Status cannot be null")
    @Column(name = "status")
    private Status status;

    @NotNull(message = "Number cannot be null")
    @Size(min = 2, max = 45, message = "Number must be between 2 and 45 characters")
    @Column(name = "number")
    private String number;

    @Past(message = "Wrong date of issue")
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Past(message = "Wrong date of check")
    @Column(name = "date_of_check")
    private LocalDate dateOfCheck;

    /**
     *One invoice can be issued by one dispatcherFrom.
     * The same dispatcherFrom can be in different invoices in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatcher_from_id")
    private User dispatcherFrom;

    /**
     *One invoice can be issued by one dispatcherTo.
     * The same dispatcherTo can be in different invoices in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatcher_to_id")
    private User dispatcherTo;
    /**
     * One invoice can be checked by one manager.
     * The same manager can check many different invoices.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    /**
     * One invoice can have only one request.
     */
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    private Request request;


    public enum Status {
        COMPLETED,
        CHECKED,
        CHECKED_BY_DRIVER,
        DELIVERED
    }

    @Override
    public InvoiceDto transform() {
        return InvoiceDto.builder()
                .withId(this.id)
                .withDateOfCheck(this.dateOfCheck)
                .withDateOfIssue(this.dateOfIssue)
                .withNumber(this.number)
                .withStatus(this.status)
                .withDispatcherFrom(this.dispatcherFrom.transform())
                .withDispatcherTo(this.dispatcherTo.transform())
                .withManager(this.manager.transform())
                .withRequest(this.request.transform())
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

    public User getDispatcherFrom() {
        return dispatcherFrom;
    }

    public void setDispatcherFrom(final User dispatcherFrom) {
        this.dispatcherFrom = dispatcherFrom;
    }

    public User getDispatcherTo() {
        return dispatcherTo;
    }

    public void setDispatcherTo(final User dispatcherTo) {
        this.dispatcherTo = dispatcherTo;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(final User manager) {
        this.manager = manager;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
                status == invoice.status &&
                Objects.equals(number, invoice.number) &&
                Objects.equals(dateOfIssue, invoice.dateOfIssue) &&
                Objects.equals(dateOfCheck, invoice.dateOfCheck) &&
                Objects.equals(dispatcherFrom, invoice.dispatcherFrom) &&
                Objects.equals(dispatcherTo, invoice.dispatcherTo) &&
                Objects.equals(manager, invoice.manager) &&
                Objects.equals(request, invoice.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, number, dateOfIssue, dateOfCheck, dispatcherFrom, dispatcherTo, manager, request);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", status=" + status +
                ", number='" + number + '\'' +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfCheck=" + dateOfCheck +
                ", dispatcherFrom=" + dispatcherFrom +
                ", dispatcherTo=" + dispatcherTo +
                ", manager=" + manager +
                ", request=" + request +
                '}';
    }
}