package com.schroh.springboot.jpa.springboot_jpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="persons") // Mediante esta anotacion hacemos referencia a la tabla
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Si el nombre del atributo es el mismo que en la tabla es redundante incluir la anotacion @Column
    private String lastName;

    @Column(name = "programming_language")
    private String programmingLanguage;

    @Embedded // Se usa en la entidad que contiene el objeto embebido, que es una instancia de la clase con @Embeddable.
    private Audit audit = new Audit();

    public Person(){ // JPA utiliza el constructor vacio, siempre tiene que estar

    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person(Long id, String lastName, String name, String programmingLanguage) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", createAt='" + audit.getCreateAt() + '\'' +
                ", updated='" + audit.getUpdateAt() + '\'' +
                '}';
    }
}
