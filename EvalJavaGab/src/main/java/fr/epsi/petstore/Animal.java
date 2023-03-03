package fr.epsi.petstore;

import jakarta.persistence.*;

import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "couleur")
    private String couleur;
    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStores;

    public Animal() {
    }

    public Animal(Date birth, String couleur, PetStore petStores) {
        this.birth = birth;
        this.couleur = couleur;
        this.petStores = petStores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStores() {
        return petStores;
    }

    public void setPetStores(PetStore petStores) {
        this.petStores = petStores;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", petStores=" + petStores +
                '}';
    }
}
