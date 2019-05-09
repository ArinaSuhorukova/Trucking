package by.itechart.Server.entity;

import by.itechart.Server.dto.ClientCompanyDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client_company")
public class ClientCompany implements Transformable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters")
    @Column(name = "name")
    private String name;

    /**
     * One clientCompany can be in different waybills.
     */
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "clientCompany")
           // cascade =  CascadeType.ALL)
    private List<WayBill> waybills = new ArrayList<>();

    @Override
    public ClientCompanyDto transform() {
        return ClientCompanyDto.builder()
                .withName(this.name)
                .build();
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

    public List<WayBill> getWaybills() {
        return waybills;
    }

    public void setWaybills(List<WayBill> waybills) {
        this.waybills = waybills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCompany that = (ClientCompany) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(waybills, that.waybills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, waybills);
    }

    @Override
    public String toString() {
        return "ClientCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waybills=" + waybills +
                '}';
    }
}