package dAO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import model.Pessoa;

public class PessoaDAOImp implements PessoaDao {
	private EntityManager em;
	
	

	public PessoaDAOImp(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Pessoa pessoa) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pessoa);
		tx.commit();
		
	}

	@Override
	public void alterar(Pessoa pessoa) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.merge(pessoa);
		tx.commit();
		
	}

	@Override
	public void remover(Pessoa pessoa) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(pessoa);
		tx.commit();
		
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		Pessoa pessoa=new Pessoa();
		pessoa = em.getReference(Pessoa.class,cpf);
		return pessoa;
	}

	@Override
	public List<Pessoa> recuperarTodos() {
		Query query =em.createQuery("from Pessoa p");
		List<Pessoa>pessoas=query.getResultList();
		return pessoas;
	}

}
