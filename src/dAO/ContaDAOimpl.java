package dAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Conta;

public class ContaDAOimpl  implements ContaDao{
 private EntityManager em;

@Override
public void salvar(Conta conta) {
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(conta);
	tx.commit();
	
	
}

public ContaDAOimpl(EntityManager em) {
	
	this.em = em;
}
 
 
 
}
