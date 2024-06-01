package br.com.ehmf;

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
		
	}

}
