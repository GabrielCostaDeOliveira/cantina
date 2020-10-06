package cantina.visao;



import cantina.dados.Cantina;
import cantina.eventos.EventoCadastroDeItemDoCardapio;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NodeCadastroDeItemDoCardapio extends BorderPane {

	private HBox hboxBotoes;

	private Button novoButton;
	private Button alterarButton;
	private Button excluirButton;

	private ScrollPane scrollpane;
	private TabelaDoCardapio tabelaDoCardapio;

	private EventHandler<ActionEvent>  evento;

	public NodeCadastroDeItemDoCardapio(Cantina cantina){
        
		// TABELA DE PESSOAS
		tabelaDoCardapio = new TabelaDoCardapio();
		scrollpane = new ScrollPane();
		tabelaDoCardapio.setPadding(new Insets(10, 10, 10, 10));
		scrollpane.setPadding(new Insets(10, 10, 10, 10));

		scrollpane.setContent(tabelaDoCardapio);
		scrollpane.fitToWidthProperty().set(true);
		scrollpane.fitToHeightProperty().set(true);

		scrollpane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
		scrollpane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);

		// BOTÕES
		novoButton = new Button("Novo");
		alterarButton = new Button("Alterar");
		excluirButton = new Button("Excluir");

		hboxBotoes = new HBox(10, novoButton, alterarButton, excluirButton);
		hboxBotoes.setPadding(new Insets(20, 20, 20, 20));

		
		evento = EventoCadastroDeItemDoCardapio.EventoCadastroItemDoCardapio(novoButton, alterarButton, tabelaDoCardapio, cantina);
		
		novoButton.setOnAction(evento);
		alterarButton.setOnAction(evento);
		excluirButton.setOnAction(evento);
    
		// MENU ITEM
		this.setCenter(scrollpane);
		this.setBottom(hboxBotoes);

	}
	}
