package cantina.servicos;

import cantina.dados.Cantina;
import cantina.dados.Pessoa;

public class Validacao {
	public static boolean validaNumeroDeTelefone(String telefone) {
		try {
			Long.parseLong(telefone);
			return telefone.length() < 9 ? false : true;
		} catch (Exception e) {
			System.out.println("número invalido");
			return false;
		}
	}

	public static boolean validaNomePessoa(String nome, Cantina cantina) {
		if (nome.length() > 4)
			for (Pessoa pessoa : cantina.getPessoas())
				if (pessoa.getNome().toString().equalsIgnoreCase(nome))
					return false;
		return true;
	}

	public static boolean validaNomeDoItemDoCardapio(String nome) {
		return nome.length() < 3 ? false : true;
	}

	public static boolean validaNumero(String numero) {
		try {
			Double.parseDouble(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
