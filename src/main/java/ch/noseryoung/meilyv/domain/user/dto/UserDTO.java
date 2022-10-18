package ch.noseryoung.meilyv.domain.user.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;
import ch.noseryoung.meilyv.domain.rank.dto.RankDTO;
import ch.noseryoung.meilyv.domain.role.dto.RoleDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public class UserDTO extends ExtendedDTO {
    private String firstName;

    private String lastName;

    private String userName;

    @Email
    @NotNull
    private String email;

    private boolean isNonLocked;

    @NotNull
    @Min(value = 0)
    private Integer age;

    @NotNull
    @Min(value = 0)
    private Integer seeds;

    private RankDTO rank;

    private Set<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(UUID id, String firstName, String lastName, String userName, String email, boolean isNonLocked, Integer age, Integer seeds, RankDTO rank, Set<RoleDTO> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.isNonLocked = isNonLocked;
        this.age = age;
        this.seeds = seeds;
        this.rank = rank;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isNonLocked() {
        return isNonLocked;
    }

    public UserDTO setNonLocked(boolean nonLocked) {
        isNonLocked = nonLocked;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public UserDTO setSeeds(Integer seeds) {
        this.seeds = seeds;
        return this;
    }

    public RankDTO getRank() {
        return rank;
    }

    public UserDTO setRank(RankDTO rank) {
        this.rank = rank;
        return this;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public UserDTO setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
        return this;
    }
}