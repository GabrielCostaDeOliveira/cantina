package cantina.visao;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PalcoDeVendas extends BorderPane {
    sudo();
    FlowPane flowPane;
    GridPane gridPane;

    TextField nomeDaPessoaTextField;

    HBox hboxBotoes;
    Button okButton;
    Button cancelarButton;

    public PalcoDeVendas(){

        nomeDaPessoaTextField = new TextField();
        nomeDaPessoaTextField.setEditable(false); 
        
        //BOTÕES
        okButton        = new Button("Ok");
        cancelarButton  = new Button("Cancelar");
        hboxBotoes      = new HBox(10,okButton,cancelarButton);

        
        
    
    }
    private class CaixaDoPedido extends HBox{
        Label nomeDoItem;
        Integer quantidadeDeItem;
        Button acrenstarButton;
        Button decrementarButton;

        CaixaDoPedido(String nomeDoItem){
        
            PalcoDeVendas.CaixaDoPedido.this.nomeDoItem        = new Label(nomeDoItem);
            PalcoDeVendas.CaixaDoPedido.this.quantidadeDeItem  = 0 ;
            PalcoDeVendas.CaixaDoPedido.this.acrenstarButton   = new Button("+");
            PalcoDeVendas.CaixaDoPedido.this.decrementarButton = new Button("-");
            
            sudo(10,PalcoDeVendas.CaixaDoPedido.this.nomeDoItem, PalcoDeVendas.CaixaDoPedido.this.quantidadeDeItem,PalcoDeVendas.CaixaDoPedido.this.acrenstarButton, PalcoDeVendas.CaixaDoPedido.this.decrementarButton = new Button("-"));




        }
        

            
    }
    
    
}