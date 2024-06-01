package br.com.ehmf.model;

public class Professor extends Pessoa {
	
	private String materia;
	private String formacao;
	private int codigo;
	
	public Professor(String materia, String formacao, int codigo,
			String nome, String telefone, String email
			) {
		super(nome, telefone, email);
		this.materia = materia;
		this.formacao = formacao;
		this.codigo = codigo;
	}
	
	public Professor(String materia, String formacao, int codigo,
			String nome, String telefone, String email, String linkedin
			) {
		super(nome, telefone, email, linkedin);
		this.materia = materia;
		this.formacao = formacao;
		this.codigo = codigo;
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {		
		return "[Nome: "     + super.getNome()     + ", " +
	            "Telefone: " + super.getTelefone() + ", " +
				"E-mail: "   + super.getEmail()    + ", " +
	            "Codigo: "   + this.codigo         + ", " + 
				"Formação: " + this.formacao       + ", " +
	            "Matéria: "  + this.materia        + ", " + 
				"Linkedin: " + super.getLinkedin() + "]";
	}
	
}
