package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity //persystencja, utrwalanie w bazie danych
@Table(name = "TASKS") //narzucamy jak chcemy nazywać tabelę
@Access(AccessType.PROPERTY)
public final class Task {

    private int id;
    private String description;
    private Date created;
    private int duration;
//Hibernate podczas odtwarzania stanu obiektów (czyli odczytywania ich z bazy danych) używa bezparametrowego konstruktora – dlatego jest on potrzebny w klasie.
    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name="CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name="DURATION")
    public int getDuration() {
        return duration;
    }
    //Jeżeli zdecydowaliśmy się na oznaczanie adnotacjami akcesorów (czyli getterów) zamiast pól, to konieczne jest również utworzenie zestawu setterów.
    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}