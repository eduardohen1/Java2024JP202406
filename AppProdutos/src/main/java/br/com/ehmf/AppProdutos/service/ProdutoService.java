package br.com.ehmf.AppProdutos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.dto.ProdutoDTO;
import br.com.ehmf.AppProdutos.model.Produto;
import br.com.ehmf.AppProdutos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		
		if(produto.getNome() == null) {
			System.out.println("Nome do produto vazio.");
			return null;
		}
		if(produto.getCodigoBarras() == null) {
			System.out.println("Código de barras do produto vazio");
			return null;
		}	
		
		//gravar:
		try {
			return produtoRepository.save(produto); //vai para o banco de dados "INSERT"
		}catch(Exception e) {
			System.out.println("ERR: Erro ao inserir produto " + 
					produto.toString() + ": " + e.getMessage());
			return null;
		}
		
	}
	
	public List<Produto> findAll(){
		return produtoRepository.findAll(); //select * from produto
	}
	
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id); //select * from produto where id = ?
	}
	
	public Produto update(Produto produto) {
		//pesquisar se o produto existe
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		
		//se o produto existir, atualizo:
		if(findProduto.isPresent()) {
			//criar um novo objeto do produto  
			// e lançar os dados do objeto de parâmetro neste novo obj e grava
			Produto updProduto = findProduto.get(); //setId
			updProduto.setCodigoBarras(produto.getCodigoBarras());
			updProduto.setNome(produto.getNome());
			updProduto.setPreco(produto.getPreco());
			//retornar o objeto gravado
			return produtoRepository.save(updProduto); //"UPDATE"
		}		
		//retornar o objeto gravado
		return produtoRepository.save(produto);  //"INSERT"
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public List<ProdutoDTO> findProdutoAndQuantidade(){
		
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidade();
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		for(Object[] obj : listResult) {
			ProdutoDTO pDTO = returnBDProdutoDTO(obj);
		}
		
		return null;
		
	}
	
	/**
	 * Conversão de objeto recebido do banco de dados para DTO de produtos
	 * @param resultado objeto do BD
	 * @return objeto ProdutoDTO
	 */
	private ProdutoDTO returnBDProdutoDTO(Object[] resultado) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if(resultado != null) {
			produtoDTO.setId(((Long)resultado[0]).longValue()   );
			produtoDTO.setCodigoBarras((String)resultado[1]);
			produtoDTO.setNome((String)resultado[2]);
			produtoDTO.setPreco(((Double)resultado[3]).doubleValue());
			produtoDTO.setQuantidade(((Integer)resultado[4]).intValue());
		}
		return produtoDTO;
	}
	
}
