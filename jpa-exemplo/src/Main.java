import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-lab3-aula");

        EntityManager em = emf.createEntityManager();

        Product p = new Product();
        p.setName("Tenis");
        p.setDescription("Tenis de corrida");

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        Product nome = em.find(Product.class, 1);
        System.out.println(nome.getDescription());

        em.close();
        emf.close();
    }

}
