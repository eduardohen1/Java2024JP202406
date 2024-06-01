package br.com.ehmf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Funcao {

	public void lerArquivo(String nome) throws FileNotFoundException {
		FileInputStream file = new FileInputStream(nome);
	}
	
}
