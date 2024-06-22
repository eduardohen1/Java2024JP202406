package br.com.ehmf.AppProdutos.dto;

public record ProdutoSimplesDTO(
		Long id, 
		String codigoBarras, 
		Double preco,
		Double precoVarejo,
		Integer quantidade) { }
