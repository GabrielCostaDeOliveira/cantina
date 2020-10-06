package cantina.visao;

import cantina.dados.Cantina;
import cantina.eventos.EventoCadastroDePessoa;
import javafx.geometry.Insets;

import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NodeCadastroDePessoa extends BorderPane {

	private HBox hboxBotoes;

	private Button novoButton;
	private Button alterarButton;
	private Button excluirButton;

	private TabelaDePessoas tabeleDePessoas;

	private EventHandler<ActionEvent> eventoDosbotoes;

	public NodeCadastroDePessoa(Cantina cantina) {

		// TABELA DE PESSOAS
		tabeleDePessoas = new TabelaDePessoas(cantina.getPessoas());

		// BOTÕES
		novoButton = new Button("Novo");
		alterarButton = new Button("Alterar");
		excluirButton = new Button("Excluir");

		hboxBotoes = new HBox(10, novoButton, alterarButton, excluirButton);
		hboxBotoes.setPadding(new Insets(20, 20, 20, 20));

		//EVENTO DOS BOTÕES

		eventoDosbotoes =EventoCadastroDePessoa.eventoCadastroDePessoas(novoButton, alterarButton, tabeleDePessoas, cantina);
	
		novoButton.setOnAction(eventoDosbotoes);
		alterarButton.setOnAction(eventoDosbotoes);
		excluirButton.setOnAction(eventoDosbotoes);

		// BORDERPANDE
		this.setCenter(tabeleDePessoas);
		this.setBottom(hboxBotoes);

	}

}