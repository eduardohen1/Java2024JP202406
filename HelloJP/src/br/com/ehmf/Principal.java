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
		
		idade = 4;
		switch(idade) {
			case 2:
				System.out.println("- Idade igual a 2");
			case 3:
			case 4:
				System.out.println("- Idade igual a 4");
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
		
	}

}
