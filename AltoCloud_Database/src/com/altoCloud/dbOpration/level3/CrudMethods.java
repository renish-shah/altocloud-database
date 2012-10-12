/**
 * 
 */
package com.altoCloud.dbOpration.level3;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.altoCloud.common.HibernateUtil;

/**
 * @author RENISH
 * 
 */
public class CrudMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void addBook(String bookName, String authorName, int bookCost) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		BookDetails bd = new BookDetails();
		bd.setBookName(bookName);
		bd.setAuthorName(authorName);
		bd.setBookCost(bookCost);
		session.save(bd);
		session.getTransaction().commit();
	}

	// Using persistence object to delete a row from the database.
	public void deleteBook(String bookName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List list = session.createQuery(
				"from BookDetails where bookName='" + bookName + "'").list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			BookDetails bd = (BookDetails) itr.next();
			System.out.println("delete : " + bd);
			session.delete(bd);
		}
		session.getTransaction().commit();
	}

	// Using Criteria API to update the book cost
	public void updateBook(String bookName, int bookCost) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria cri = session.createCriteria(BookDetails.class);
		cri = cri.add(Restrictions.eq("bookName", bookName));
		List list = cri.list();
		BookDetails bd = (BookDetails) list.iterator().next();
		bd.setBookCost(bookCost);
		session.update(bd);
		session.getTransaction().commit();
	}

	// Using HQL - Hibernate Query Language
	public void getBookDetails(String bookName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from BookDetails where bookName=:bn");
		q.setString("bn", bookName);
		List list = q.list();
		System.out.println("Getting Book Details using HQL. \n" + list);

		// The above query can also be achieved with Criteria & Restrictions
		// API.
		Criteria cri = session.createCriteria(BookDetails.class);
		cri = cri.add(Restrictions.eq("bookName", bookName));
		list = cri.list();
		System.out
				.println("Getting Book Details using Criteria API. \n" + list);

		session.getTransaction().commit();
	}

	// Aggregate function.
	public void countBook() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List list = session.createQuery("select count(*) from BookDetails")
				.list();
		System.out.println("Aggregate function count \n" + list);
		session.getTransaction().commit();
	}

	// Native SQL Query
	public void listBooks() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List list = session.createSQLQuery("select * from BookStore")
				.addEntity(BookDetails.class).list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			BookDetails bd = (BookDetails) itr.next();
			System.out.println(bd);
		}
		session.getTransaction().commit();

	}

}
