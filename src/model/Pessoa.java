package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Pessoa")
public class Pessoa {
	
	@Id
	@Column(name="cpf", nullable=false, length=20)
	private String cpf;
	@Column(name="nome", nullable=false, length=30)
	private String nome;
	@Column(name="idade", nullable=false)
	private Long idade;
	@Column(name="sexo", nullable=false, length=5)
	private String sexo;
	@Column(name="Id_Endereco")
	private  Long IdEndereco;
	@Column(name="numero_conta")
	private String numero;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdade() {
		return idade;
	}
	public void setIdade(Long idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getIdEndereco() {
		return IdEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		IdEndereco = idEndereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", IdEndereco="
				+ IdEndereco + ", numero da Conta=" + numero + "]";
	}
	
	
	
	
}
