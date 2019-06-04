package by.itechart.Server.dto;

import java.util.Date;


public class ConfirmationTokenDto {

    private Integer id;

    private String confirmationToken;

    private Date createDate;

    private UserDto user;

    public static Builder builder() {
        return new ConfirmationTokenDto().new Builder();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(final String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(final int id) {
            ConfirmationTokenDto.this.id = id;
            return this;
        }

        public Builder withUser (final UserDto user){
            ConfirmationTokenDto.this.user = user;
            return this;
        }

        public Builder withCreateDate(final Date createDate) {
            ConfirmationTokenDto.this.createDate = createDate;
            return this;
        }

        public Builder withConfirmationToken(final String confirmationToken) {
            ConfirmationTokenDto.this.confirmationToken = confirmationToken;
            return this;
        }


        public ConfirmationTokenDto build() {
            return ConfirmationTokenDto.this;
        }
    }
}
