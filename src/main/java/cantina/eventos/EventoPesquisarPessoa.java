package cantina.eventos;

import cantina.dados.Pessoa;
import cantina.visao.PalcoPesquisaDePessoas;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventoPesquisarPessoa {
    
    public static EventHandler<ActionEvent> eventoDePesquisaDePessoa(PalcoPesquisaDePessoas palcoCadastroDePessoas,ObservableList<Pessoa> listaDaPesquisa){
        return new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
			}
            
        };

    }
    
}