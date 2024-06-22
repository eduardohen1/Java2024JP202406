package br.com.ehmf.AppProdutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ehmf.AppProdutos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query(value = "select tp.id, tp.codigo_barras, tp.nome, tp.preco, te.quantidade from tb_produto tp inner join tb_estoque te on tp.id  = te.produto_id",
		   nativeQuery = true)
	List<Object[]> findProdutoAndQuantidade();
	
	
}
