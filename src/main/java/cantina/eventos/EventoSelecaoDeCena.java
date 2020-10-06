package cantina.eventos;

import cantina.visao.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;



public class EventoSelecaoDeCena {

    
    public static EventHandler<ActionEvent> eventoSelecaoDeCena(Stage palco,BorderPane raiz,MenuItem menuItemCadastroDePessoa, MenuItem menuItemCadastroDeItemDoCardapio,MenuItem menuItemVendas
                                                                    ,NodeCadastroDeItemDoCardapio nodeCadastroDeItemDoCardapio,NodeCadastroDePessoa nodeCadastroDePessoa,NodeVendas nodeVendas){
        return new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent evento) {
				if(evento.getSource() == menuItemCadastroDePessoa){
                    palco.setTitle("Cadastro de Pessoas");
				    raiz.setCenter(nodeCadastroDePessoa);
                }else if(evento.getSource() ==menuItemCadastroDeItemDoCardapio ){
                    palco.setTitle("Cadastro de Item do Cardápio");
				    raiz.setCenter(nodeCadastroDeItemDoCardapio);
                }else if(evento.getSource() ==menuItemVendas){
                    palco.setTitle("Vendas");
                    raiz.setCenter(nodeVendas);
                }
			}
            
        };

    }
    
}