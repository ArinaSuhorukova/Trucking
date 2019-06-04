package by.itechart.Server.dto;

import by.itechart.Server.entity.Checkpoint;

import java.time.LocalDate;

/**
 * @author Arina Suhorukova
 */
public class CheckpointDto {

    private Integer id;

    private WayBillDto wayBill;

    private String name;

    private String latitude;

    private String longitude;

    private LocalDate date;

    private Checkpoint.Status status;

    private CheckpointDto() {
    }

    public static Builder builder() {
        return new CheckpointDto().new Builder();
    }

    public Checkpoint.Status getStatus() {
        return status;
    }

    public void setStatus(final Checkpoint.Status status) {
        this.status = status;
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

    public class Builder {
        private Builder() {
        }

        public Builder withId(final Integer id) {
            CheckpointDto.this.id = id;
            return this;
        }

        public Builder withWayBill(final WayBillDto wayBill) {
            CheckpointDto.this.wayBill = wayBill;
            return this;
        }

        public Builder withName(final String name) {
            CheckpointDto.this.name = name;
            return this;
        }

        public Builder withLatitude(final String latitude) {
            CheckpointDto.this.latitude = latitude;
            return this;
        }

        public Builder withLongitude(final String longitude) {
            CheckpointDto.this.longitude = longitude;
            return this;
        }

        public Builder withDate(final LocalDate date) {
            CheckpointDto.this.date = date;
            return this;
        }

        public Builder withStatus(final Checkpoint.Status status) {
            CheckpointDto.this.status = status;
            return this;
        }

        public CheckpointDto build() {
            return CheckpointDto.this;
        }
    }
}