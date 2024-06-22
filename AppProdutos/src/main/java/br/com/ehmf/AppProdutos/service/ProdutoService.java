package br.com.ehmf.AppProdutos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ehmf.AppProdutos.dto.ProdutoDTO;
import br.com.ehmf.AppProdutos.dto.ProdutoSimplesDTO;
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
			listProdutoDTO.add(pDTO);
		}
		
		return listProdutoDTO;
		
	}
	
	/**
	 * Consulta em banco de dados, onde retorna o Produto com sua respectiva 
	 * quantidade que seja <span>menor</span> que o parâmetro passado
	 * @param qte quantidade a ser comparada
	 * @return lista de ProdutoDTO
	 */
	public List<ProdutoDTO> findProdutoAndQuantidadeMenor(Integer qte){
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidadeMenor(qte);
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		//converter obj de banco de dados para ProdutoDTO
		for(Object[] obj : listResult) {
			ProdutoDTO pDTO = returnBDProdutoDTO(obj);
			listProdutoDTO.add(pDTO);
		}
		
		return listProdutoDTO;
	}
	
	public List<ProdutoSimplesDTO> findProdutosPrecoVarejo(){
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidade();
		List<ProdutoSimplesDTO> listProdutoSimplesDTOs = new ArrayList<ProdutoSimplesDTO>();
		
		//Converter obj de bd para ProdutoSimplesDTO
		for(Object[] obj : listResult) {
			ProdutoSimplesDTO pDTO = returnDBProdutoSimplesDTO(obj);
			listProdutoSimplesDTOs.add(pDTO);
		}
		return listProdutoSimplesDTOs;
		
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
	
	private ProdutoSimplesDTO returnDBProdutoSimplesDTO(Object[] resultado) {
		if(resultado != null) {
			ProdutoSimplesDTO produtoSimplesDTO = new ProdutoSimplesDTO(
					((Long)resultado[0]).longValue(), 
					(String)resultado[1], 
					((Double)resultado[3]).doubleValue(), 
					(((Double)resultado[3]).doubleValue() * 1.02),
					((Integer)resultado[4]).intValue()); //o preço de varejo é 2% a mais
			return produtoSimplesDTO;
		}else {
			return null;
		}
	}
	
}
