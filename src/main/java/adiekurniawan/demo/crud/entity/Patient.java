package adiekurniawan.demo.crud.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="patient")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pid;

    @Column(name = "first_name")
    @JsonAlias("first_name")
    private String firstName;

    @Column(name = "last_name")
    @JsonAlias("last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @JsonAlias("date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "suburb")
    private String suburb;

    @Column(name = "state")
    private String state;

    @Column(name = "postcode")
    @JsonAlias("postcode")
    private String postCode;
}
