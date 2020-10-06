package cantina.dados;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cantina {

	ObservableList<ItemDoCardapio> cardapio;
	ObservableList<Pessoa> pessoas;


	public Cantina() {
		cardapio = FXCollections.observableArrayList();
		pessoas = FXCollections.observableArrayList(new Pessoa("Juliana Souza dos Remédios", 123453434l,"Pioneiro"),
		                                            new Pessoa("Gabriel Costa de Oliviera ", 981580931l, "Pioneiro"));
	}

	// GETTER E SETTER
	public ObservableList<ItemDoCardapio> getCardapio() {
		return cardapio;
	}

	public void setCardapio(ItemDoCardapio itemDoCardapio) {
		this.cardapio.add(itemDoCardapio);
	}

	public ObservableList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoa(Pessoa pessoas) {
		this.pessoas.add(pessoas);
	}

}
