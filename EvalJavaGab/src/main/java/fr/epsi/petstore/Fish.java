package fr.epsi.petstore;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "fish")
public class Fish extends Animal {
    @Enumerated( EnumType.STRING )
    @Column(name = "livingEnv")
    private FishLivEnv livingEnv;
    public Fish() {

    }
    public Fish(Date birth, String couleur, PetStore petStores, FishLivEnv livingEnv) {
        super(birth, couleur, petStores);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
