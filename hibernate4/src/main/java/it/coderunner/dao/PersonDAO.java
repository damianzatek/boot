package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Person;

public interface PersonDAO {

	Person save(Person p);

	Person selectById(int nrID);
	
	List<Person> list();
	
}
