package br.com.ehmf.AppProdutos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ehmf.AppProdutos.model.Produto;
import br.com.ehmf.AppProdutos.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos") //http://localhost:8081/api/produtos
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
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
	public ResponseEntity<Produto> save(){
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
	
}
