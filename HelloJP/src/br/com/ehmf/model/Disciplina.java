package br.com.ehmf.model;

import java.lang.module.ModuleDescriptor.Builder;

public class Disciplina {
	
	private String nome;
	private String periodo;
	private int cargaHoraria;
	
	public Disciplina(String nome, String periodo, int cargaHoraria) {
		this.nome = nome;
		this.periodo = periodo;
		this.cargaHoraria = cargaHoraria;
	}
	
	public Disciplina(Builder builder) {
		this.nome = builder.nome;
		this.periodo = builder.periodo;
		this.cargaHoraria = builder.cargaHoraria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		return "[Nome: "          + this.nome         + ", " +
	            "Período: "       + this.periodo      + ", " +
				"Carga horária: " + this.cargaHoraria + "]";
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String nome;
		private String periodo;
		private int cargaHoraria = 0;
		
		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder setPeriodo(String periodo) {
			this.periodo = periodo;
			return this;
		}
		
		public Builder setCargaHoraria(int cargaHoraria) {
			this.cargaHoraria = cargaHoraria;
			return this;
		}
		
		public Disciplina build() {
			return new Disciplina(this);
		}
		
	}
	
}
