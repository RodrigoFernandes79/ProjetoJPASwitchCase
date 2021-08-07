package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dAO.ContaDAOimpl;
import dAO.ContaDao;
import dAO.EnderecoDAOImpl;
import dAO.EnderecoDao;
import dAO.PessoaDAOImp;
import dAO.PessoaDao;
import jpaUtil.jpaUtil;
import model.Conta;
import model.Endereco;
import model.Pessoa;



public class Principal {

	public static void main(String[] args) {
		
		
		Scanner tc = new Scanner(System.in);
		System.out.println("====================");
		System.out.println("BANCO DE DADOS FUCTURA");
		System.out.println("====================");
		System.out.println();
		int opcao;
		while(true) {
		System.out.println("~~~~~~~~~~~~~~~~");
		System.out.printf("Digite uma opção:\n1-Cadastrar Pessoa \n2-Alterar Pessoa \n3-Pesquisar Pessoa\n4-Remover Pessoa \n5-Listar todas as Pessoas e seu  Endereco\n6-SAIR\n");
		System.out.println("~~~~~~~~~~~~~~~~");
		opcao = tc.nextInt();
		System.out.printf("VOCÊ ESCOLHEU A OPCÃO %d\n", opcao);
		while(opcao<1||opcao>6) {
			System.out.println("Opção Inválida!!!");
			System.out.println("~~~~~~~~~~~~~~~~");
			System.out.printf("Digite uma opção:\n1-Cadastrar Pessoa \n2-Alterar Pessoa \n3-Pesquisar Pessoa\n4-Remover Pessoa \n5-Listar todas as Pessoas e seu  Endereco\n6-SAIR\n");
			System.out.println("~~~~~~~~~~~~~~~~");
			opcao = tc.nextInt();
		}
		if(opcao==6) {
			System.out.println("VOCÊ ESCOLHEU OPÇÃO SAIR. ");
			System.out.println("OBRIGADO POR UTILIZAR O Banco de Dados FUCTURA!ATÉ A PROXIMA!");
		break;
		}
		
		
		
		switch(opcao) {
				case 1:
					EnderecoDao enderecoDAO = new EnderecoDAOImpl(jpaUtil.getEntityManager());
					
					Endereco end = new Endereco();
					System.out.println("Digite o nome da Rua:");
					tc.nextLine();
					end.setRua(tc.nextLine());
					end.getRua();
					
					System.out.println("Digite o numero Rua:");
					end.setNumero(tc.nextLine());
					end.getNumero();
					System.out.println("Digite o nome do Bairro:");
					end.setBairro(tc.nextLine());
					end.getBairro();
					System.out.println("Digite o nome do Complemento:");
					end.setComplemento(tc.nextLine());
					end.getComplemento();
					enderecoDAO.salvar(end);
					System.out.println("Endereço cadastrado com sucesso! " );
					
					ContaDao contaDao = new ContaDAOimpl(jpaUtil.getEntityManager());
					Conta conta = new Conta();
					System.out.println("Digite o Número da Conta:");
					conta.setNumero(tc.nextLine());
					conta.getNumero();
					System.out.println("Digite o Saldo da Conta:");
					conta.setSaldo(tc.nextLine());
					contaDao.salvar(conta);
					System.out.println("Conta Cadastrada Com Sucesso!");
					
					PessoaDao pessoaDao = new PessoaDAOImp(jpaUtil.getEntityManager());
					Pessoa pessoa = new Pessoa();
					System.out.println("Digite o seu  Nome:");
					pessoa.setNome(tc.nextLine());
					pessoa.getNome();
					System.out.println("Digite a sua Idade:");
					pessoa.setIdade(tc.nextLong());
					pessoa.getIdade();
					tc.nextLine();
					System.out.println("Digite o seu sexo[M / F]:");
					pessoa.setSexo(tc.nextLine());
					pessoa.getSexo();
					System.out.println("Digite o número do seu Cpf:");
					pessoa.setCpf(tc.nextLine());
					pessoa.getCpf();
					System.out.println("Digite o ID do Endereço:");
					pessoa.setIdEndereco(tc.nextLong());
					tc.nextLine();
					System.out.println("Digite o Número da Conta:");
					pessoa.setNumero(tc.nextLine());
					pessoa.getNumero();
					pessoaDao.salvar(pessoa);
					System.out.println("Pessoa cadastrado com sucesso!");
					
					
			
				break;
			case 2:
				//aLTERAR PESSOA :
				
				System.out.println("Qual dado você quer alterar? Digite uma opção:\n 1-Nome \n 2-Idade "
						+ "\n 3-Sexo ");
				PessoaDao pessoaAlt = new PessoaDAOImp(jpaUtil.getEntityManager());
				Pessoa pes=new Pessoa();
				int op;
				op = tc.nextInt();
				while(op<1 || op>3) {
					System.out.println("Opção inválida...Quais dados deseja mudar?\n 1- Nome \n 2- Idade "
							+ "\n 3- Sexo ");
					op= tc.nextInt();
					tc.nextLine();
					}if (op==1) {
						System.out.println("Digite o CPF do Usuário ");
						tc.nextLine();
						pes.setCpf(tc.nextLine());
						String cpf=pes.getCpf();
						pes =pessoaAlt.pesquisar(cpf);
						System.out.println("Digite o novo Nome do usuário:");
						
						pes.setNome(tc.nextLine());
						pessoaAlt.salvar(pes);
		
						System.out.println("O novo nome do usuário é: "+pes.getNome());
						System.out.println(pes.toString());
						System.out.println("Usuário alterado com sucesso");
						
					
					
				}if (op ==2) {
					
					System.out.println("Digite o CPF do Usuário ");
					tc.nextLine();
					pes.setCpf(tc.nextLine());
					String cpf=pes.getCpf();
					pes=pessoaAlt.pesquisar(cpf);
					System.out.println("Digite a nova Idade do usuário:");
					
					pes.setIdade(tc.nextLong());
					pessoaAlt.salvar(pes);
					System.out.println("O novo sexo do usuário é: "+pes.getIdade());
					System.out.println(pes.toString());
					System.out.println("Usuário alterado com sucesso");
					
					
					
				}if (op ==3) {
					
					System.out.println("Digite o CPF do Usuário ");
					tc.nextLine();
					pes.setCpf(tc.nextLine());
					String cpf=pes.getCpf();
					pes = pessoaAlt.pesquisar(cpf);
					System.out.println("Digite o novo Sexo do usuário:");
					
					pes.setSexo(tc.nextLine());
					pessoaAlt.salvar(pes);
					System.out.println("O novo sexo do usuário é: "+pes.getSexo());
					System.out.println(pes.toString());
					System.out.println("Usuário alterado com sucesso");
					
				
				}
			
				break;
				
			case 3:
				//Pesquisar Pessoa
				PessoaDao pessoaFind = new PessoaDAOImp(jpaUtil.getEntityManager());
				Pessoa pess = new Pessoa();
				System.out.println("Digite o CPF do usuário a ser Consultado:");
				tc.nextLine();
				pess.setCpf(tc.nextLine());
				String cpf= pess.getCpf();
				pess =pessoaFind.pesquisar(cpf);
				System.out.println(pess.toString());

				
				break;
			case 4:
				//Remover Pessoa e Endereco	
				PessoaDao pessoaDelete = new PessoaDAOImp(jpaUtil.getEntityManager());
				Pessoa pesDel = new Pessoa();
				System.out.println("Digite o CPF do Usuário ");
				tc.nextLine();
				pesDel.setCpf(tc.nextLine());
				String cpf1=pesDel.getCpf();
				pesDel =pessoaDelete.pesquisar(cpf1);
				pessoaDelete.remover(pesDel);
				System.out.println("Usuário " +pesDel.toString()+ "deletado com sucesso!");
				

				
				break;
			case 5:
				//Listar todas as Pessoas e seu  Endereco
				PessoaDao listaPessoa = new PessoaDAOImp(jpaUtil.getEntityManager());
				
				List<Pessoa> pessoas=listaPessoa.recuperarTodos();
				for (Pessoa p :pessoas) {
				System.out.println(p);
				}

				
				break;
				
	}
		}
		jpaUtil.close();

		}
	}


	

			

			
			

	


