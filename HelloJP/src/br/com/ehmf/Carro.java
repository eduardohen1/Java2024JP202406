package br.com.ehmf;

public class Carro {
	
	//atributos - características
	private String cor;
	private String marca;
	private String modelo;
	private String cambio; //automático ou manual
	
	//construtor
	public Carro(String cor, String marca, 
			     String modelo) {
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.cambio = "Manual";
	}
	
	//sobrecarga de métodos
	public Carro(String cor, String marca, 
			     String modelo, String cambio) {
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.cambio = cambio;
	}
	
	public Carro(String cor, String marca, 
		     String modelo, boolean cambio) {
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		if(cambio == true)
			this.cambio = "Manual";
		else
			this.cambio = "Automático";
	}
	
	public Carro() { }

	//métodos - ações
	public void andar() {
		System.out.println("Andando...");
	}
	
	public void parar() {
		System.out.println("Parado!");
	}
	
	//Getters Setters
	protected void setCor(String cor) {
		this.cor = cor;
	}
	public String getCor() {
		return this.cor;
	}

	public String getMarca() {
		return marca;
	}

	protected void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCambio() {
		return cambio;
	}

	protected void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	@Override
	public String toString() {
		String retorno = "[Cor: "    + this.cor    + ", " +
	                      "Marca: "  + this.marca  + ", " + 
				          "Modelo: " + this.modelo + ", " +
	                      "Câmbio: " + this.cambio + "]";
		return retorno;
	}
}
