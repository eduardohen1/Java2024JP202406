package br.com.ehmf.model;

import br.com.ehmf.exception.LimiteCreditoExcedidoException;

public class ContaBancaria {
	
	private double limitePix = 1000.0; //exemplo de limite
	
	public ContaBancaria(double limitePix) {
		this.limitePix = limitePix;
	}
	
	public void fazerPix(double quantia) throws LimiteCreditoExcedidoException {
		if(quantia > this.limitePix) {
			throw new LimiteCreditoExcedidoException(quantia-this.limitePix);
		}else {
			System.out.println("Pix realizado com sucesso!");
		}
	}
	
}
