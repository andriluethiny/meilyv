package ch.noseryoung.meilyv.domain.user;

import ch.noseryoung.meilyv.core.generic.ExtendedAuditEntity;
import ch.noseryoung.meilyv.domain.order.Order;
import ch.noseryoung.meilyv.domain.rank.Rank;
import ch.noseryoung.meilyv.domain.role.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends ExtendedAuditEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name= "is_non_locked")
    private boolean isNonLocked = true;

    @Column(name = "age")
    private Integer age;

    @Column(name = "seeds")
    private Integer seeds;

    @JsonBackReference(value = "user_orders")
    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rank_id", referencedColumnName = "id", nullable = false)
    private Rank rank;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(UUID id, String firstName, String lastName, String userName, String email, String password, boolean isNonLocked, Integer age, Integer seeds, Set<Order> orders, Rank rank, Set<Role> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.isNonLocked = isNonLocked;
        this.age = age;
        this.seeds = seeds;
        this.orders = orders;
        this.rank = rank;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isNonLocked() {
        return isNonLocked;
    }

    public User setNonLocked(boolean nonLocked) {
        isNonLocked = nonLocked;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public User setSeeds(Integer seeds) {
        this.seeds = seeds;
        return this;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Rank getRank() {
        return rank;
    }

    public User setRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}