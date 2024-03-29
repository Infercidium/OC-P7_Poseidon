package com.nnk.springboot.domain;

import com.nnk.springboot.constants.Password;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    /**
     * Attribute id corresponding to id generate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Attribute username corresponding to username choice.
     */
    @NotBlank(message = "Username is mandatory")
    private String username;

    /**
     * The password attribute corresponds to the chosen password
     * but with the constraints of 8 characters minimum
     * including a letter in upper case, in lower case,
     * a number and a symbol.
     */
    @NotBlank(message = "Password is mandatory")
    @Pattern(regexp = Password.REGEX,
            message = "A password must contain an uppercase character, "
                    + "a lowercase character, a number, "
                    + "a special character "
                    + "and must be at least 8 characters long.")
    private String password;

    /**
     * Attribute fullname corresponding to fullname choice.
     */
    @NotBlank(message = "FullName is mandatory")
    private String fullname;

    /**
     * Attribute role corresponding to role choice (admin or user).
     */
    @NotBlank(message = "Role is mandatory")
    private String role;

    /**
     * ToString method.
     * @return toString.
     */
    @Override
    public String toString() {
        return "User{"
                + "id = " + id
                + ", username = '" + username + '\''
                + ", password = '" + password + '\''
                + ", fullname = '" + fullname + '\''
                + ", role = '" + role + '\''
                + '}';
    }

    /**
     * Equals method.
     * @param o : element to compare.
     * @return result of the comparison.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getId().equals(user.getId());
    }

    /**
     * HashCode method.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
