package br.com.ehmf.AppProdutos.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@OneToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "id") //nome do campo // referencia do campo da tabela Produto (id)
	private Produto produto;
	//select * from produto p inner join estoque e on p.id = e.id_produto
	
	// -------------------------------
	public Estoque() {}
	public Estoque(Long id, Integer quantidade, Produto produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
		
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id = " + this.id + ", " + 
	            "quantidade = " + this.quantidade + "]";
	}
}
