package com.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import com.entity.Country;

public class Onetomany {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("jpa");
			entityManager = emf.createEntityManager();

			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();
			
			//Country country = entityManager.getReference(Country.class, 2);


			// entity
			Customer c1 = new Customer();
			c1.setCName("testcomp");
			
			c1.setContactNo("+1-408-575-1317");
			

			Account acc1 = new Account();
			acc1.setAmount(12000);
			acc1.setCustomer(c1);
			acc1.setStatus("pending");

			Account acc2 = new Account();
			acc2.setAmount(15000);
			acc2.setCustomer(c1);
			acc2.setStatus("completed");

			List<Account> accountList = new ArrayList();
			accountList.add(acc1);
			accountList.add(acc2);

			c1.setListAccount(accountList);
			// company.getListInvoice().add(invoice2);

			// save call
			entityManager.persist(c1);
			System.out.println("Customer details successfull....");

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

}
