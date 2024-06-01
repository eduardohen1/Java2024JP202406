package br.com.ehmf.model;

public class Pessoa {
	//atributos
	private String nome;
	private String telefone;
	private String email;
	private String linkedin;
	
	//construtor
	public Pessoa(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.linkedin = "-";
	}
	
	public Pessoa(String nome, String telefone, 
			String email, String linkedin) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.linkedin = linkedin;
	}

	//gets setts
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	@Override
	public String toString() {
		String retorno = "[Nome: "     + this.nome     + ", " +
                       	  "Telefone: " + this.telefone + ", " +
				          "E-mail: "   + this.email    + ", " +
                       	  "Linkedin: " + this.linkedin + "]";
		return retorno;
	}
	
	
}
