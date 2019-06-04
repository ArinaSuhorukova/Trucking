package by.itechart.Server.entity;

import by.itechart.Server.dto.UserDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User implements Transformable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 45, message = "Name must be between 2 and 45 characters")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 45, message = "Patronymic must be between 2 and 45 characters")
    @Column(name = "patronymic")
    private String patronymic;

    @NotNull(message = "Surname cannot be null")
    @Size(min = 2, max = 45, message = "Surname must be between 2 and 45 characters")
    @Column(name = "surname")
    private String surname;

    @NotNull(message = "Passport number cannot be null")
    @Size(min = 2, max = 45, message = "Passport number must be between 2 and 45 characters")
    @Column(name = "passport_number")
    private String passportNumber;

    @NotNull(message = "Passport issued cannot be null")
    @Size(min = 2, max = 45, message = "Passport number must be between 2 and 45 characters")
    @Column(name = "passport_issued")
    private String passportIssued;

    @Past(message = "Wrong date of birth")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Email
    @Column(name = "email")
    private String email;

    @Size(min = 2, max = 45, message = "Login number must be between 2 and 45 characters")
    @Column(name = "login")
    private String login;

    @Size(min = 2, message = "Password number must be between 2 and 45 characters")
    @Column(name = "password")
    private String password;

    @Enumerated
    @Column(name = "user_role")
    private Role role;

    /**
    * One user can have only one address.
    */  
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;
    /**
     * One manager can check several invoices.
     */
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Invoice> checkedByManagerInvoices;

    /**
     * One dispatcherFrom can issue several invoices.
     */
    @OneToMany(mappedBy = "dispatcherFrom", cascade = CascadeType.ALL)
    private List<Invoice> issuedByDispatcherFromInvoices;

    /**
     * One dispatcherTo can issue several invoices.
     */
    @OneToMany(mappedBy = "dispatcherTo", cascade = CascadeType.ALL)
    private List<Invoice> issuedByDispatcherToInvoices;

    /**
     * One driver can be choosed in several requests.
     */
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Request> requests;

    /**
     *One user can belong to only one clientCompany.
     * The same clientCompany may have many users.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_company_id")
    private ClientCompany clientCompany;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    public enum Role {
        SYSADMIN,
        ADMIN,
        MANAGER,
        DISPATCHER,
        DRIVER,
        OWNER
    }

    @Override
    public UserDto transform() {
        return UserDto.builder()
                .withId(this.id)
                .withEnabled(this.isEnabled)
                .withDateOfBirth(this.dateOfBirth)
                .withLogin(this.login)
                .withPassword(this.password)
                .withName(this.name)
                .withPassportNumber(this.passportNumber)
                .withPassportIssued(this.passportIssued)
                .withPatronymic(this.patronymic)
                .withSurname(this.surname)
                .withRole(this.role.ordinal())
                .withEmail(this.email)
                .withAddressDto(this.address.transform())
                .withClientCompany(this.clientCompany.transform())
                .withRequests(this.requests.stream().map(Request::transform).collect(Collectors.toList()))
                .build();
    }

    public User() {
        super();
        this.isEnabled = false;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(final String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssued() {
        return passportIssued;
    }

    public void setPassportIssued(String passportIssued) {
        this.passportIssued = passportIssued;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public List<Invoice> getIssuedByDispatcherFromInvoices() {
        return issuedByDispatcherFromInvoices;
    }

    public void setIssuedByDispatcherFromInvoices(List<Invoice> issuedByDispatcherFromInvoices) {
        this.issuedByDispatcherFromInvoices = issuedByDispatcherFromInvoices;
    }

    public List<Invoice> getIssuedByDispatcherToInvoices() {
        return issuedByDispatcherToInvoices;
    }

    public void setIssuedByDispatcherToInvoices(List<Invoice> issuedByDispatcherToInvoices) {
        this.issuedByDispatcherToInvoices = issuedByDispatcherToInvoices;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<Invoice> getCheckedByManagerInvoices() {
        return checkedByManagerInvoices;
    }

    public void setCheckedByManagerInvoices(List<Invoice> checkedByManagerInvoices) {
        this.checkedByManagerInvoices = checkedByManagerInvoices;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public ClientCompany getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(passportNumber, user.passportNumber) &&
                Objects.equals(passportIssued, user.passportIssued) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                role == user.role &&
                Objects.equals(address, user.address) &&
                Objects.equals(requests, user.requests) &&
                Objects.equals(issuedByDispatcherFromInvoices, user.issuedByDispatcherFromInvoices) &&
                Objects.equals(issuedByDispatcherToInvoices, user.issuedByDispatcherToInvoices) &&
                Objects.equals(isEnabled, user.isEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, patronymic, surname, passportNumber, passportIssued, dateOfBirth, email, login, password, role, address, requests, issuedByDispatcherFromInvoices, issuedByDispatcherToInvoices, isEnabled);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportIssued='" + passportIssued + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", address=" + address +
                ", requests=" + requests +
                ", issuedByDispatcherFromInvoices=" + issuedByDispatcherFromInvoices +
                ", issuedByDispatcherToInvoices=" + issuedByDispatcherToInvoices +
                ", isEnabled=" + isEnabled +
                '}';
    }
}