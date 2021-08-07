package dAO;

import java.util.List;

import model.Endereco;
//Criando uma interface EnderecoDao:
public interface EnderecoDao {
	public void salvar(Endereco endereco);
	public void alterar(Endereco endereco);
	public void remover(Endereco endereco);
	public Endereco pesquisar(Long id);
	public List<Endereco> recuperarTodos();
	
}
