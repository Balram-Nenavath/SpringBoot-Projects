package spring.example.junit.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dept")
@Data
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;
}
