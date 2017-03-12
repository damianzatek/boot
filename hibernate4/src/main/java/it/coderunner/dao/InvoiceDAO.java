package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public interface InvoiceDAO {

	void save(Invoice p);

	void upDate(Invoice p);

	List<Invoice> list();
	
	Invoice selectById(int id);

}
