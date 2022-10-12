package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

   /* public User(int ids, String emails, String pword, String fName, String lName) {
        this.id = ids;
        this.email=emails;
        this.password=pword;
        this.firstName=fName;
        this.lastName=lName;
    }

    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
   // @ManyToMany
   // private List<User> likes;
}
