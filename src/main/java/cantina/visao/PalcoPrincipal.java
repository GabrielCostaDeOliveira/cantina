package cantina.visao;
import cantina.dados.Cantina;
import cantina.eventos.EventoSelecaoDeCena;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PalcoPrincipal extends Application {
	private Cantina cantina;
	
	private BorderPane raiz;
	private Scene cena;
	
	private MenuBarJanela menubar;
	
	private NodeCadastroDePessoa nodeCadastroDePessoa;
	private NodeCadastroDeItemDoCardapio nodeCadastroDeItemDoCardapio;
	private NodeVendas nodeVendas;
	
	private EventHandler<ActionEvent> eventoSelecaoDeCena;
    
	public static void main(String[] args) {
		launch(args);
	}

	
	public void start(Stage palco){

		raiz  =new BorderPane();
		cena  =new Scene(raiz);
		
		menubar =new MenuBarJanela();
		raiz.setTop(menubar);

		cantina = new Cantina();
		
		nodeCadastroDePessoa         = new NodeCadastroDePessoa(cantina);
		nodeCadastroDeItemDoCardapio = new NodeCadastroDeItemDoCardapio(cantina);
		nodeVendas                   = new NodeVendas(cantina);

		eventoSelecaoDeCena = EventoSelecaoDeCena.eventoSelecaoDeCena(palco, raiz, menubar.getPessoa(), menubar.getProtudos(), menubar.getVendas(), nodeCadastroDeItemDoCardapio, nodeCadastroDePessoa, nodeVendas);
		
		//CADASTRO DE PESSOAS
        menubar.getPessoa().setOnAction(eventoSelecaoDeCena);
        
		//CADASTRO DE ITEM DO CARDAPIO
		menubar.getProtudos().setOnAction(eventoSelecaoDeCena);
		
		//VENDAS
		menubar.getVendas().setOnAction(eventoSelecaoDeCena);
		
		//PALCO
		palco.setScene(cena);
		palco.setHeight(600);
		palco.setWidth(850);
		palco.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
