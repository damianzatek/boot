package it.coderunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public class SpringHibernateMain {
	@Autowired
	private PersonDAO dao;
	private InvoiceDAO daoInvoice;

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);
		InvoiceDAO invoiceDAO = context.getBean(InvoiceDAO.class);

		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");
		personDAO.save(person);
		System.out.println("Person::" + person);
		personDAO.list().forEach(System.out::println);
		
		
		Invoice invoice = new Invoice();
		invoice.setData_faktury("13.12.2017");
		invoice.setNr_faktury("112/we/13");
		invoice.setPodatek(23);
		invoice.setPerson(person);
		invoice.setWartosc_netto(1222);
	
		
		
		invoiceDAO.save(invoice);
		
		Person p2=personDAO.selectById(1);
		p2.setName("Tomek");
		System.out.println(p2);
		
		Invoice inv = invoiceDAO.selectById(2);
		System.out.println(inv.getWartosc_netto());
		inv.setWartosc_netto(3000);
		invoiceDAO.upDate(inv);
		inv = invoiceDAO.selectById(2);
		System.out.println(inv.getWartosc_netto());
		
//		invoiceDAO.upDate(invoice2, 1000);
		
//		System.out.println("Invoice::" + invoice);
//		invoiceDAO.list().forEach(System.out::println);
		context.close();

	}

}
