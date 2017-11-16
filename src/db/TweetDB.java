package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import models.Tweet;

public class TweetDB {
    public static Tweet getById(int id) {
		EntityManager em = DBUtil.createEntityManager();
		
		try {
            Tweet tweet = em.find(Tweet.class, id);
            return tweet;
        } finally {
            em.close();
        }
    }
    
    public static void insert(Tweet tweet) {
		EntityManager em = DBUtil.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try {
            em.persist(tweet);
            trans.commit();
        }
		catch (Exception e) {
			trans.rollback();
		}
		finally {
            em.close();
        }
    }
    
    public static void update(Tweet tweet) {
		EntityManager em = DBUtil.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try {
            em.merge(tweet);
            trans.commit();
        }
		catch (Exception e) {
			trans.rollback();
		}
		finally {
            em.close();
        }
    }
    
    public static List<Tweet> getAll() {
		EntityManager em = DBUtil.createEntityManager();
		String qString = "SELECT t from Tweet t";
		TypedQuery<Tweet> q = em.createQuery(qString, Tweet.class);

		try {
			List<Tweet> invoices = q.getResultList();
			if (invoices == null)
				invoices = new ArrayList<Tweet>();
		   
			return invoices;
        } finally {
            em.close();
        }
    }
}
