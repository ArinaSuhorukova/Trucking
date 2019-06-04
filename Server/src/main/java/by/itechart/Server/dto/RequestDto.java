package by.itechart.Server.dto;

import by.itechart.Server.entity.Request;

import java.util.List;


public class RequestDto {
    private Integer id;

    private Request.Status status;

    private CarDto car;

    private UserDto driver;

    private ClientCompanyDto clientCompanyFrom;

    private ClientCompanyDto clientCompanyTo;

    private List<ProductDto> products;

    public static Builder builder() {
        return new RequestDto().new Builder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;

    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(final CarDto car) {
        this.car = car;
    }

    public UserDto getDriver() {
        return driver;
    }

    public void setDriver(final UserDto driver) {
        this.driver = driver;
    }

    public ClientCompanyDto getClientCompanyFrom() {
        return clientCompanyFrom;
    }

    public void setClientCompanyFrom(final ClientCompanyDto clientCompanyFrom) {
        this.clientCompanyFrom = clientCompanyFrom;
    }

    public ClientCompanyDto getClientCompanyTo() {
        return clientCompanyTo;
    }

    public void setClientCompanyTo(final ClientCompanyDto clientCompanyTo) {
        this.clientCompanyTo = clientCompanyTo;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(final List<ProductDto> products) {
        this.products = products;
    }

    public Request.Status getStatus() {
        return status;
    }

    public void setStatus(final Request.Status status) {
        this.status = status;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            RequestDto.this.id = id;
            return this;
        }

        public Builder withStatus(final Request.Status status) {
            RequestDto.this.status = status;
            return this;
        }

        public Builder withCar(final CarDto car) {
            RequestDto.this.car = car;
            return this;
        }

        public Builder withDriver(final UserDto driver) {
            RequestDto.this.driver = driver;
            return this;
        }

        public Builder withClientCompanyFrom(final ClientCompanyDto clientCompanyFrom) {
            RequestDto.this.clientCompanyFrom = clientCompanyFrom;
            return this;
        }

        public Builder withClientCompanyTo(final ClientCompanyDto clientCompanyTo) {
            RequestDto.this.clientCompanyTo = clientCompanyTo;
            return this;
        }

        public Builder withProducts(final List<ProductDto> products) {
            RequestDto.this.products = products;
            return this;
        }

        public RequestDto build() {
            return RequestDto.this;
        }
    }
}
