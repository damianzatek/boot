package it.coderunner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Invoice p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> list() {
		Session session = this.sessionFactory.openSession();
		List<Invoice> invoiceList = session.createQuery("from Invoice").list();
		session.close();
		return invoiceList;
	}

	@Override
	public Invoice selectById(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Invoice invoice = (Invoice) session.get(Invoice.class, id);
		tx.commit();
		session.close();
		return invoice;
	}

	@Override
	public void upDate(Invoice p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(p);
		tx.commit();
		session.close();
	}

}
