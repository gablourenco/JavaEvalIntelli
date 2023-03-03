package fr.epsi;

import jakarta.persistence.*;
import fr.epsi.petstore.*;

import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address("7","rue je sais pas","44000","NANTES");
        em.persist(address);
        Address address2 = new Address("8","rue je sais toujours pas","77000","Seine-et-Marne");
        em.persist(address2);
        Address address3 = new Address("11","rue je sais finalement", "16000","Charente");
        em.persist(address3);

        PetStore petStore = new PetStore("animal magasin ?","Jean Michel");
        em.persist(petStore);
        PetStore petStore2 = new PetStore("clébard shop","René");
        em.persist(petStore2);
        PetStore petStore3 = new PetStore("Tchoukel shop","LULU");
        em.persist(petStore3);

        Cat cat = new Cat(new Date(01/02/2020),"noir",petStore2,"fefe4");
        em.persist(cat);
        Cat cat2 = new Cat(new Date(04/04/2019),"blanc",petStore,"jiji7");
        em.persist(cat2);
        Cat cat3 = new Cat(new Date(01/07/2017),"orange",petStore3,"dada4");
        em.persist(cat3);

        Fish fish = new Fish(new Date(01/04/1999),"bleue",petStore2,FishLivEnv.FRESH_WATER);
        em.persist(fish);
        Fish fish2 = new Fish(new Date(01/04/2021),"marron",petStore,FishLivEnv.SEA_WATER);
        em.persist(fish2);
        Fish fish3 = new Fish(new Date(01/04/2020),"jaune",petStore3,FishLivEnv.SEA_WATER);
        em.persist(fish3);

        Product product = new Product("4","san pelegrino","boisson",4.10);
        em.persist(product);
        Product product2 = new Product("7","coca","boisson",1.90);
        em.persist(product2);
        Product product3 = new Product("9","cookie","gateau",1.99);
        em.persist(product3);

        em.getTransaction().commit();

        TypedQuery<Animal> findAllQuery = em.createQuery("from Product where Product = '3'",Animal.class);
        System.out.println(findAllQuery.getResultList());

        em.close();
        emf.close();
    }
}