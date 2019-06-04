package by.itechart.Server.dto;

import by.itechart.Server.entity.Product;

public class ProductDto {
    private int id;

    private String name;

    private String type;

    private Integer amount;

    private Integer price;

    private Product.Status status;

    private Integer lostAmount;

    private RequestDto request;

    private ProductDto() {
    }

    public static Builder builder() {
        return new ProductDto().new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(final Integer amount) {
        this.amount = amount;
    }

    public Integer getLostAmount() {
        return lostAmount;
    }

    public void setLostAmount(final Integer lostAmount) {
        this.lostAmount = lostAmount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public Product.Status getStatus() {
        return status;
    }

    public void setStatus(final Product.Status status) {
        this.status = status;
    }

    public RequestDto getRequest() {
        return request;
    }

    public void setRequest(final RequestDto request) {
        this.request = request;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withRequest(final RequestDto request) {
            ProductDto.this.request = request;
            return this;
        }

        public Builder withId(final int id) {
            ProductDto.this.id = id;
            return this;
        }

        public Builder withLostAmount(final int lostAmount) {
            ProductDto.this.lostAmount = lostAmount;
            return this;
        }


        public Builder withName(final String name) {
            ProductDto.this.name = name;
            return this;
        }

        public Builder withType(final String type) {
            ProductDto.this.type = type;
            return this;
        }

        public Builder withAmount(final Integer amount) {
            ProductDto.this.amount = amount;
            return this;
        }

        public Builder withPrice(final Integer price) {
            ProductDto.this.price = price;
            return this;
        }

        public Builder withStatus(final Product.Status status) {
            ProductDto.this.status = status;
            return this;
        }

        public ProductDto build() {
            return ProductDto.this;
        }
    }

}