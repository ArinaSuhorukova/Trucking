package by.itechart.Server.entity;

import by.itechart.Server.dto.CarDto;
import by.itechart.Server.dto.RequestDto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "car")
public class Car implements Transformable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    @NotNull(message = "Car type cannot be null")
    @Column(name = "car_type")
    private CarType carType;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Consumption cannot be null")
    @Column(name = "consumption")
    private Integer consumption;

    @Enumerated
    @NotNull(message = "Status cannot be null")
    @Column(name = "status")
    private Status status;

    /**
     * One car can be in different requests in various dates.
     */
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Request> requests;

    @Override
    public CarDto transform() {
        return CarDto.builder()
                .withId(this.id)
                .withCarType(this.carType)
                .withConsumption(this.consumption)
                .withName(this.name)
                .withStatus(this.status)
                .withRequests(this.requests.stream().map(Request::transform).collect(Collectors.toList()))
                .build();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(final CarType carType) {
        this.carType = carType;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(final Integer consumption) {
        this.consumption = consumption;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(final List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                carType == car.carType &&
                Objects.equals(name, car.name) &&
                Objects.equals(consumption, car.consumption) &&
                status == car.status &&
                Objects.equals(requests, car.requests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carType, name, consumption, status, requests);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carType=" + carType +
                ", name='" + name + '\'' +
                ", consumption=" + consumption +
                ", status=" + status +
                ", requests=" + requests +
                '}';
    }

    public enum Status {
        AVAILABLE,
        UNAVAILABLE
    }

    public enum CarType {
        TILT, FRIDGE, TANKER
    }
}