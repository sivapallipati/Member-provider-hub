package com.adalitek.mph.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "EMAIL")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "PASSWORD")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Column(name = "First_Name")
    @NotEmpty(message = "*Please provide your name")
    private String Confirmpassword;
    @Column(name = "Confirm_Password")
    @NotEmpty(message = "*Please provide confirm_password")
    private String name;
    @Column(name = "Last_Name")
    @Length(max = 10, message = "*Your password must have at least 10 digits")
    @NotEmpty(message = "*Please provide your last name")
    private String mobile;
    @Column(name ="mobile_no")
    @NotEmpty(message="*Please provide your Mobile no")
    private String lastName;
    @Column(name = "ACTIVE")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;

}