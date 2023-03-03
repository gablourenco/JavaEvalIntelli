package fr.epsi.petstore;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Petstore")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "managerName")
    private String managerName;
    @ManyToMany
    @JoinTable(name = "petstore_product",
            joinColumns = @JoinColumn(name = "id_petstore"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<Product> products = new HashSet<>();

    @OneToMany
    @JoinTable(name = "petstore_animal",
            joinColumns = @JoinColumn(name = "id_petstore"),
            inverseJoinColumns = @JoinColumn(name = "id_animal"))
    private Set<Animal> animals = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;


    public PetStore() {

    }
    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                '}';
    }
}
