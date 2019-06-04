package by.itechart.Server.entity;

import by.itechart.Server.dto.RequestDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Gorlach Dmitry
 */

@Entity
@Table(name = "request")
public class Request implements Transformable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * One request can have one car.
     * The same car can be in different requests in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    /**
     *  One request can have one driver.
     *  The same driver can be in different requests in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private User driver;

    /**
     *One request can have only one clientCompanyFrom.
     * The same clientCompanyFrom can be in different requests in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_company_from")
    private ClientCompany clientCompanyFrom;

    /**
     *One request can have only one clientCompanyTo.
     * The same clientCompanyTo can be in different requests in various dates.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_company_to")
    private ClientCompany clientCompanyTo;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "request",
            cascade =  CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @NotNull(message = "Status cannot be null")
    @Column(name = "status")
    private Request.Status status;

    @Override
    public RequestDto transform() {
        return RequestDto.builder()
                .withId(this.id)
                .withCar(this.car.transform())
                .withClientCompanyFrom(this.clientCompanyFrom.transform())
                .withClientCompanyTo(this.clientCompanyTo.transform())
                .withDriver(this.driver.transform())
                .withStatus(this.status)
                .withProducts(this.products.stream().map(Product::transform).collect(Collectors.toList()))
                .build();
    }

    public enum Status {
        NOT_VIEWED,
        REJECTED,
        ISSUED
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(final Car car) {
        this.car = car;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(final User driver) {
        this.driver = driver;
    }

    public ClientCompany getClientCompanyFrom() {
        return clientCompanyFrom;
    }

    public void setClientCompanyFrom(final ClientCompany clientCompanyFrom) {
        this.clientCompanyFrom = clientCompanyFrom;
    }

    public ClientCompany getClientCompanyTo() {
        return clientCompanyTo;
    }

    public void setClientCompanyTo(final ClientCompany clientCompanyTo) {
        this.clientCompanyTo = clientCompanyTo;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id) &&
                Objects.equals(car, request.car) &&
                Objects.equals(driver, request.driver) &&
                Objects.equals(clientCompanyFrom, request.clientCompanyFrom) &&
                Objects.equals(clientCompanyTo, request.clientCompanyTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, driver, clientCompanyFrom, clientCompanyTo);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", car=" + car +
                ", driver=" + driver +
                ", clientCompanyFrom=" + clientCompanyFrom +
                ", clientCompanyTo=" + clientCompanyTo +
                '}';
    }
}
