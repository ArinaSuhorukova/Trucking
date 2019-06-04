package by.itechart.Server.entity;

import by.itechart.Server.dto.CheckpointDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "checkpoint")
public class Checkpoint implements Transformable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 45, message = "Name must be between 2 and 45 characters")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 255, message = "Latitude must be between 2 and 255 characters")
    @Column(name = "latitude")
    private String latitude;

    @Size(min = 2, max = 255, message = "Longitude must be between 2 and 255 characters")
    @Column(name = "longitude")
    private String longitude;

    @NotNull(message = "Date cannot be null")
    @Column (name = "date")
    private LocalDate date;

    /**
     * Several checkpoints may be in the same wayBill.
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "waybill_id")
    private WayBill wayBill;

    @NotNull(message = "Status cannot be null")
    @Column(name = "status")
    private Checkpoint.Status status;

    public enum Status {
        PASSED,
        NOT_PASSED
    }

    @Override
    public CheckpointDto transform() {
        return CheckpointDto.builder()
                .withId(this.id)
                .withDate(this.date)
                .withLatitude(this.latitude)
                .withLongitude(this.longitude)
                .withName(this.name)
                .withStatus(this.status)
                .withWayBill(this.wayBill.transform())
                .build();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(final String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(final String longitude) {
        this.longitude = longitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public WayBill getWayBill() {
        return wayBill;
    }

    public void setWayBill(final WayBill wayBill) {
        this.wayBill = wayBill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkpoint that = (Checkpoint) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(date, that.date) &&
                Objects.equals(wayBill, that.wayBill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, date, wayBill);
    }

    @Override
    public String toString() {
        return "Checkpoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", date=" + date +
                ", wayBill=" + wayBill +
                '}';
    }
}