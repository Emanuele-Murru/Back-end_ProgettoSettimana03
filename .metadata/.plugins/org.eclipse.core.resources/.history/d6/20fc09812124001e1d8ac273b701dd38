package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("Catalogo");
		} catch (Throwable e) {
			System.err.println("Creazione dell'EntityManagerFactory fallito" + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}