package db;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import models.User;

public class UserDB {
    public static User getById(int id) {
		EntityManager em = DBUtil.createEntityManager();
		
		try {
            User user = em.find(User.class, id);
            return user;
        }
		catch (NoResultException e) {
			return null;
		}
		finally {
            em.close();
        }
    }
    
    public static User getByName(String name) {

    	EntityManager em = DBUtil.createEntityManager();
    	String qString = "SELECT u from User u " +
                "WHERE u.name = :name";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("name", name);

		try {
		   User u = q.getSingleResult();
		   return u;
		}
		catch (NoResultException e) {
			return null;
		}
		finally {
			em.close();
		}
	}
}
