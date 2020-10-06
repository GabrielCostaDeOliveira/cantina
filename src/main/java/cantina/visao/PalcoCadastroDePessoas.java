package cantina.visao;

import cantina.dados.Pessoa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class PalcoCadastroDePessoas extends Stage {

	private GridPane gridPane;
	private BorderPane borderPane;

	private Label labelNome;
	private Label labelRamo;
	private Label labelTelefone;

	private ChoiceBox<String> choiceBoxRamo;

	private TextField textFieldNome;
	private TextField textFielTelefone;

	private HBox hboxBotoes;
	private Button OkButton;
	private Button canselarButton;

	public PalcoCadastroDePessoas() {
		super();
		labelNome = new Label("Nome");
		labelRamo = new Label("Ramo");
		labelTelefone = new Label("Telefone");

		textFieldNome = new TextField();
		textFielTelefone = new TextField();

		choiceBoxRamo = new ChoiceBox<String>();
		choiceBoxRamo.getItems().addAll("Lobinho", "Escoteiro", "Sênior", "Pioneiro", "Responsável");

		OkButton = new Button("Ok");
		canselarButton = new Button("Canselar");

		canselarButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent canselar) {
				PalcoCadastroDePessoas.this.hide();
			}
		});

		hboxBotoes = new HBox(15, OkButton, canselarButton);
		hboxBotoes.setAlignment(Pos.CENTER_RIGHT);
		hboxBotoes.setPadding(new Insets(10, 10, 10, 10));

		gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.addRow(0, labelNome, textFieldNome);
		gridPane.addRow(1, labelTelefone, textFielTelefone);
		gridPane.addRow(2, labelRamo, choiceBoxRamo);
		gridPane.setAlignment(Pos.CENTER);

		borderPane = new BorderPane();
		borderPane.setCenter(gridPane);
		borderPane.setBottom(hboxBotoes);

		this.initModality(Modality.APPLICATION_MODAL);
		this.setScene(new Scene(borderPane));
		this.setHeight(250);
		this.setWidth(350);
		this.setResizable(false);
	}
	
	
	public void limpaPainelDeDados() {
		textFieldNome.setText("");
		textFielTelefone.setText("");
		choiceBoxRamo.getSelectionModel().clearSelection();
	}
	public void mostarPessoa(TabelaDePessoas tabeleDaPessoas) {
		Pessoa pessoa = tabeleDaPessoas.getTableview().getSelectionModel().getSelectedItem();
		
		textFieldNome.setText(pessoa.getNome().toString());
		textFielTelefone.setText(pessoa.getTelefone().toString());
		choiceBoxRamo.setValue(pessoa.getRamo().toString());
	}

	public Label getLabelNome() {
		return labelNome;
	}

	public Label getLabelRamo() {
		return labelRamo;
	}

	public Label getLabelTelefone() {
		return labelTelefone;
	}

	public ChoiceBox<String> getChoiceBoxRamo() {
		return choiceBoxRamo;
	}

	public TextField getTextFieldNome() {
		return textFieldNome;
	}

	public TextField getTextFielTelefone() {
		return textFielTelefone;
	}

	public Button getOkButton() {
		return OkButton;
	}

}
