package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Endereco")
public class Endereco {
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO )
		private Long IdEndereco;
		@Column(name="rua", nullable=false, length=60 )
		private String rua;
		@Column(name="numero", nullable=false, length=6)
		private String numero;
		@Column(name="bairro", nullable=false, length=20 )
		private String bairro;
		@Column(name="complemento", nullable=false, length=10 )
		private String complemento;
		
		public Long getIdEndereco() {
			return IdEndereco;
		}
		public void setIdEndereco(Long idEndereco) {
			IdEndereco = idEndereco;
		}
		public String getRua() {
			return rua;
		}
		public void setRua(String rua) {
			this.rua = rua;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}
		@Override
		public String toString() {
			return "Endereco [IdEndereco=" + IdEndereco + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro
					+ ", complemento=" + complemento + "]";
		}
		
		
}
