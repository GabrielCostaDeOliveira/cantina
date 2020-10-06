package cantina.visao;

import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import cantina.dados.ItemDoCardapio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PalcoCadastroDeItemDoCardapio extends Stage {
    private GridPane gridPane;
    private BorderPane borderPane;

    private Label labelNome;
    private Label labelValor;
    private Label labelDescricao;

    private TextField textFieldNome;
    private TextField textFieldValor;
    private TextArea textAreaDescricao;

    private HBox hboxBotoes;
	private Button OkButton;
	private Button canselarButton;

    public PalcoCadastroDeItemDoCardapio(){
    
        labelNome      = new Label("Nome");
        labelValor     = new Label("Valor");
        labelDescricao = new Label("Descrição");

        textFieldNome     = new TextField();
        textFieldValor    = new TextField();
		textAreaDescricao = new TextArea();
		
		textAreaDescricao.setPrefColumnCount(14);
		textAreaDescricao.setPrefHeight(14);

        OkButton = new Button("Ok");
		canselarButton = new Button("Canselar");

		canselarButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent canselar) {
				PalcoCadastroDeItemDoCardapio.this.hide();
			}
        });
        
        hboxBotoes = new HBox(15, OkButton, canselarButton);
		hboxBotoes.setAlignment(Pos.CENTER_RIGHT);
        hboxBotoes.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.addRow(0, labelNome     , textFieldNome);
		gridPane.addRow(1, labelValor    , textFieldValor);
		gridPane.addRow(2, labelDescricao, textAreaDescricao);
		gridPane.setAlignment(Pos.CENTER);

        //PALCO
		borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(hboxBotoes);

		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(borderPane));
		this.setHeight(290);
		this.setWidth(380);
		this.setResizable(false);

	}
	
	public void mostrarItemDoCardapio(ItemDoCardapio itemDoCardapio){
		getTextFieldNome().setText(itemDoCardapio.toString());
		getTextFieldValor().setText(Double.toString(itemDoCardapio.getValor()));
		getTextAreaDescricao().setText(itemDoCardapio.getDescricao().toString());
		
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public BorderPane getBorderPane() {
		return borderPane;
	}

	public Label getLabelNome() {
		return labelNome;
	}

	public Label getLabelValor() {
		return labelValor;
	}

	public Label getLabelDescricao() {
		return labelDescricao;
	}

	public TextField getTextFieldNome() {
		return textFieldNome;
	}

	public TextField getTextFieldValor() {
		return textFieldValor;
	}

	public TextArea getTextAreaDescricao() {
		return textAreaDescricao;
	}

	public HBox getHboxBotoes() {
		return hboxBotoes;
	}

	public Button getOkButton() {
		return OkButton;
	}

	public Button getCanselarButton() {
		return canselarButton;
	}

    
}
