import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Domain {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        Model model1=new Model();
        model1.setInfo("First model");
        model1.setTarget("Training purpose");

        Model model2 = new Model();
        model2.setInfo("Second model");
        model2.setTarget("Training purpose");

        entityManagerFactory = Persistence.createEntityManagerFactory("Persistant_manager");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(model1);
        manager.persist(model2);
        manager.getTransaction().commit();
        manager.close();

        EntityManager reader = entityManagerFactory.createEntityManager();
        reader.getTransaction().begin();
        reader.createQuery("from Model", Model.class)
                .getResultList()
                .forEach(g -> System.out.println(String.format("%s, %s!", g.getInfo(), g.getTarget())));
        reader.getTransaction().commit();
        reader.close();
    }
}
