package cantina.visao;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class PalcoDeVendas extends BorderPane {

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
   
   
   
   
   
   
   
   
    private class CaixaDoPedido {

        HBox hbox;
        Label nomeDoItem;
        Integer quantidadeDeItem;
        Button acrenstarButton;
        Button decrementarButton;

        CaixaDoPedido(String nomeDoItem){
        
            PalcoDeVendas.CaixaDoPedido.this.nomeDoItem              = new Label(nomeDoItem);
            PalcoDeVendas.CaixaDoPedido.this.quantidadeDeItem   = 0 ;
            PalcoDeVendas.CaixaDoPedido.this.acrenstarButton        = new Button("+");
            PalcoDeVendas.CaixaDoPedido.this.decrementarButton = new Button("-");
            
            PalcoDeVendas.CaixaDoPedido.this.hbox   =  new HBox(20,PalcoDeVendas.CaixaDoPedido.this.nomeDoItem  ,   new Label( Integer.toString(quantidadeDeItem) ),   acrenstarButton ,   decrementarButton); 
            
        }
        
     public HBox getHbox() {
         return hbox;
     }

    }
}