package cantina.visao;

import cantina.dados.Cantina;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.stage.Modality;

public class PalcoPesquisaDePessoas extends Stage {
    private BorderPane borderPane;

    private HBox hboxInferior;
    private TextField pesquisaTextField;
    private ChoiceBox<String> choiceBoxRamo;
    private Button PesquisarButton;

    private HBox hboxSuperior;
    private Button okButton;

    private TabelaDePessoas tabelaDePessoas;

    public PalcoPesquisaDePessoas(Cantina cantina){
        pesquisaTextField = new TextField();
        //BUTÃAO DE PESQUISAR
        PesquisarButton = new Button("Pesquisar");

        //pesquisaButton.setPadding(new Insets(20, 20, 20, 20));

        //CHOICEBOX
		choiceBoxRamo = new ChoiceBox<String>();
        choiceBoxRamo.getItems().addAll("todos","Lobinho", "Escoteiro", "Sênior", "Pioneiro", "Responsável");

        //TABELA DE PESSSOAS
        tabelaDePessoas = new TabelaDePessoas(cantina.getPessoas());

        //HBOX
        hboxSuperior = new HBox(10,new Label("Nome"),pesquisaTextField,choiceBoxRamo,PesquisarButton);
        hboxSuperior.setPadding(new Insets(20, 20, 20, 20));

        //BUTÃO OK
        okButton = new Button("ok");
        hboxInferior = new HBox(okButton);
        hboxInferior.setPadding(new Insets(20, 20, 20, 20));
        hboxInferior.setAlignment(Pos.CENTER);


        //BORDERPANE
        borderPane = new BorderPane(tabelaDePessoas, hboxSuperior, null, hboxInferior, null);

        //STAGE
        this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(borderPane));
		this.setHeight(500);
		this.setWidth(700);
		this.setResizable(false);
    
    }

    public TextField getPesquisaTextField(){
        return pesquisaTextField;
    }

    public TabelaDePessoas getTabela(){
        return tabelaDePessoas;
    }

    public Button getPesquisarbutton(){
        return PesquisarButton;
    }

    public ChoiceBox getChoiceBoxRamo(){
        return choiceBoxRamo;
    }

    public Button getOkButton(){
        return  okButton;
    }

    
}