package by.itechart.Server.dto;


public class AddressDto {
    private int id;

    private String city;

    private String street;

    private Integer building;

    private Integer flat;

    private String latitude;

    private String longitude;

    private AddressDto() {
    }

    public static Builder builder() {
        return new AddressDto().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            AddressDto.this.id = id;
            return this;
        }

        public Builder withCity(final String city) {
            AddressDto.this.city = city;
            return this;
        }

        public Builder withStreet(final String street) {
            AddressDto.this.street = street;
            return this;
        }

        public Builder withBuilding(final Integer building) {
            AddressDto.this.building = building;
            return this;
        }

        public Builder withFlat(final Integer flat) {
            AddressDto.this.flat = flat;
            return this;
        }

        public Builder withLatitude(final String latitude) {
            AddressDto.this.latitude = latitude;
            return this;
        }

        public Builder withLongtitude(final String longitude) {
            AddressDto.this.longitude = longitude;
            return this;
        }

        public AddressDto build() {
            return AddressDto.this;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(final Integer building) {
        this.building = building;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(final Integer flat) {
        this.flat = flat;
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
}