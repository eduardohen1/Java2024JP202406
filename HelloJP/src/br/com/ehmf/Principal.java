package br.com.ehmf;

import br.com.ehmf.model.Aluno;
import br.com.ehmf.model.Professor;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Hello pessoal!!!!");
		System.out.println("-----------------------------");
		System.out.println(":: OPERADORES LÓGICOS:");
		
		// validação de operadores lógicos
		boolean condicao = true;
		
		if(condicao == true) {
			System.out.println("* Minha condição é Verdadeira!");
		} else {
			System.out.println("* Minha condição é Falsa!");
		}
		
		int idade = 11;
		if(idade < 10) {
			System.out.println("* Filme Infantil (" + idade + ")");
		}else if(idade >= 10 && idade < 18){
			System.out.println("* Filme Juvenil (" + idade + ")");
		}else {
			System.out.println("* Filme Adulto (" + idade + ")");
		}
		
		idade = 3;
		switch(idade) {
			case 2:
				System.out.println("- Idade igual a 2");
				break;
			case 3:
			case 4:
				System.out.println("- Idade igual a 3 e 4");
				break;
			case 5:
			case 10: 
				System.out.println("- Idade igual a 10");
				break;
			case 11: 
				System.out.println("- Idade igual a 11");
				break;
			case 20: 
				System.out.println("- Idade igual a 20");
				break;
			default:
				System.out.println("- Outra idade");
				break;
		}
		
		// trabalhando com looppings:
		// criar uma contagem de 0 até 20
		int max = 21;
		for(int numero = 0; numero < max; numero++) {
			//System.out.print(numero);			
			// se o número for par, exibe um * entre o número, caso não
			//  exibe somente o número.
			if(numero % 2 == 0) {
				System.out.print("*" + numero + "*");
			}else {
				System.out.print(numero);
			}			
			if(numero < (max - 1)) {
				System.out.print(", ");
			}
		}
		
		//while
		int i = 0;
		while(i <= 10) {
			System.out.println("Escrevendo i: " + i);
			
			switch(i) {
				case 1:
					System.out.println(" Achei o 1!!!");
					break;
				default:
					System.out.print("----");
			}			
			i++;
		}
		
		System.out.println("-----------------------------");
		System.out.println(":: PROGRAÇÃO ORIENTADA A OBJETOS:");
		
		/*
		Carro carroJao = new Carro(); //instanciando uma classe
		carroJao.cor = "Branca";
		carroJao.marca = "Chevrolet";
		carroJao.modelo = "Onix";
		carroJao.andar();
		
		Carro carroTiao = new Carro(); //instanciando uma classe
		carroTiao.cor = "Azul";
		carroTiao.marca = "BYD";
		carroTiao.modelo = "Delphin";
		carroTiao.parar();
		*/
		Carro carroJao = new Carro("Branca", "Chevrolet", "Onix");
		carroJao.andar();
		
		Carro carroTiao = new Carro("Azul", "BYD", "Delphin","-");
		carroTiao.parar();
		
		Carro carroZe = new Carro("Vermelho", "VW", "Fusca",false);
		System.out.println("Carro Zé: " + carroZe.toString());
		carroZe.andar();
		
		Carro carroFulano = new Carro();
		carroFulano.setCor("Verde");
		System.out.println("A cor do carro de Fulano é: " + 
								carroFulano.getCor());
		carroFulano.andar();
		System.out.println("Carro fulano: " + carroFulano.toString());
	
		System.out.println("-----------------------------");
		System.out.println(":: PROGRAÇÃO ORIENTADA A OBJETOS - HERANÇA:");
		
		Aluno aluno1 = new Aluno("123456",2024, 
				"Nome aluno", "Telefone 1231", "aluno1@a.com");		
		System.out.println("Aluno1: " + aluno1.toString());
		
		Professor professor1 = new Professor("POO", "Mestre", 1,
				 "Professor 1", "646546546540", "prof1@a.com"
				);
		System.out.println("Professor1: " + professor1.toString());
		
		Professor prof2 = new Professor("Banco de dados", "Mestre" , 2,
				"Professor2", "6546464", "prof2@a.com",
				"http://linkedin.com");
		System.out.println("Professor2: " + prof2.toString());
		
	}

}
