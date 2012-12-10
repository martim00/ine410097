package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManager entityManager = Persistence
			.createEntityManagerFactory("teste.agil").createEntityManager();

	public static void save(Object entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(Object entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(Class<?> clazz, long id) {
		try {
			entityManager.getTransaction().begin();
			entityManager.createQuery(
					"delete from " + clazz.getName() + " ent where ent.id = "
							+ id).executeUpdate();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object load(Class<?> clazz, long id) {
		Object entity = null;
		try {
			entityManager.getTransaction().begin();
			entity = entityManager.find(clazz, id);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	public static List<Object> find(Class<?> clazz) {
		List<Object> entities = null;
		try {
			entityManager.getTransaction().begin();
			entities = entityManager.createQuery(
					"select ent from " + clazz.getName() + " ent ")
					.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

}