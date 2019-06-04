package by.itechart.Server.entity;

import by.itechart.Server.dto.ConfirmationTokenDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken implements Transformable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date createDate;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public ConfirmationToken() {
    }

    public ConfirmationToken(User user){
        this.user = user;
        createDate = new Date();
        confirmationToken = String.valueOf(Math.random());
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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }


    @Override
    public ConfirmationTokenDto transform() {
        return ConfirmationTokenDto.builder()
                .withConfirmationToken(this.confirmationToken)
                .withCreateDate(this.createDate)
                .withId(this.id)
                .withUser(this.user.transform())
                .build();
    }
}
