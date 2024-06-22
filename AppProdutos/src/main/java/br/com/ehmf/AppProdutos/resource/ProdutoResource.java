package br.com.ehmf.AppProdutos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppProdutos.dto.ProdutoDTO;
import br.com.ehmf.AppProdutos.dto.ProdutoSimplesDTO;
import br.com.ehmf.AppProdutos.model.Produto;
import br.com.ehmf.AppProdutos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/produtos") //http://localhost:8081/api/produtos
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
	/*
	@GetMapping("produto") //http://localhost:8081/api/produtos/produto
	public ResponseEntity<Produto> getProduto() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigoBarras("123456");
		produto.setNome("Produto 1");
		produto.setPreco(55.0);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("salvar") //http://localhost:8081/api/produtos/salvar
	public ResponseEntity<Produto> save2(){
		Produto produto = new Produto();		
		produto.setCodigoBarras("123456");
		produto.setNome("Produto 1");
		produto.setPreco(55.0);
		
		//estou indo na minha classe de serviço:
		Produto produtoResposta = produtoService.save(produto);
		if(produtoResposta == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoResposta);		
		
	}
	*/
	// ----------------------------------------------------
	
	@Operation(summary = "Busca todos os registros de Produto")
	@GetMapping //http://localhost:8081/api/produtos
	public ResponseEntity<List<Produto>> findAllProdutos(){
		List<Produto> produtos = produtoService.findAll();
		if(produtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtos);
	}
	
	@Operation(summary = "Busca registros por ID de Produtos")
	@GetMapping("/{id}") // http://localhost:8081/api/produtos/2
	public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
		Optional<Produto> produto = produtoService.findById(id);
		if(produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	
	@Operation(summary = "Grava o registro de Produto")
	@PostMapping //http://localhost:8081/api/produtos
	public ResponseEntity<Produto> save(@RequestBody Produto produto){
		Produto newProduto = produtoService.save(produto);
		if(newProduto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(newProduto);
	}
	
	@Operation(summary = "Atualiza o registro de produto. Validação por ID")
	@PutMapping //http://localhost:8081/api/produtos
	public ResponseEntity<Produto> update(@RequestBody Produto produto){
		Produto updProduto = produtoService.update(produto);
		if(updProduto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updProduto);
	}
	
	@Operation(summary = "Exclui o registro de produto por ID")
	@DeleteMapping("/{id}") //http://localhost:8081/api/produtos/2
	public ResponseEntity<?> delete(@PathVariable Long id){
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //status code 204
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em estoque")
	@GetMapping("/produtoAndQte") //http://localhost:8081/api/produtos/produtoAndQte 
	public ResponseEntity<List<ProdutoDTO>> findProdutoAndQuantidade(){
		List<ProdutoDTO> produtoDtos = produtoService.findProdutoAndQuantidade();
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em estoque filtrado por quantidade menor que o parâmetro")
	@GetMapping("/produtoAndQte/{qte}") //http://localhost:8081/api/produtos/produtoAndQte/ 
	public ResponseEntity<List<ProdutoDTO>> findProdutoAndQuantidadeMenor(@PathVariable Integer qte){
		List<ProdutoDTO> produtoDtos = produtoService.findProdutoAndQuantidadeMenor(qte);
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em estoque com o preço de varejo")
	@GetMapping("/produtoAndQteVarejo") //http://localhost:8081/api/produtos/produtoAndQteVarejo 
	public ResponseEntity<List<ProdutoSimplesDTO>> findProdutoAndQuantidadeVarejo(){
		List<ProdutoSimplesDTO> produtoDtos = produtoService.findProdutosPrecoVarejo();
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
	
}
