package dAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Endereco;

public class EnderecoDAOImpl implements EnderecoDao {
	
	private EntityManager em;

	public EnderecoDAOImpl(EntityManager em) {
		
		this.em = em;
		
	
	}

	@Override
	public void salvar(Endereco endereco) {
		EntityTransaction tx =em.getTransaction();
		tx.begin();
		em.persist(endereco);
		tx.commit();
		
	}

	

	@Override
	public Endereco pesquisar(Long id) {
		Endereco endereco =em.find(Endereco.class, id);
		return endereco;
	}

	@Override
	public List<Endereco> recuperarTodos() {
		Query query =em.createQuery("from Endereco e");
		List<Endereco>enderecos=query.getResultList();
		return enderecos;
	}

	@Override
	public void alterar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

	
}
