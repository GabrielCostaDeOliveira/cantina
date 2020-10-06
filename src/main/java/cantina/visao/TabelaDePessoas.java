package cantina.visao;

import cantina.dados.Cantina;
import cantina.dados.Pessoa;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaDePessoas extends ScrollPane{

    TableView<Pessoa> tabelaDePessoas;
    TableColumn<Pessoa, String> nomeColuna;
    TableColumn<Pessoa, String> ramoColuna;
    TableColumn<Pessoa, String> telefoneColuna;

    public TabelaDePessoas(ObservableList<Pessoa> lista) {

        nomeColuna = new TableColumn<Pessoa, String>("Nome");
        ramoColuna = new TableColumn<Pessoa, String>("Ramo");
        telefoneColuna = new TableColumn<Pessoa, String>("Telefone");

        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ramoColuna.setCellValueFactory(new PropertyValueFactory<>("ramo"));
        telefoneColuna.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabelaDePessoas = new TableView<Pessoa>();
        tabelaDePessoas.getColumns().addAll(nomeColuna, ramoColuna, telefoneColuna);
        tabelaDePessoas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaDePessoas.setItems(lista);

        tabelaDePessoas.setPadding(new Insets(10, 10, 10, 10));
		
		this.setPadding(new Insets(10, 10, 10, 10));
		
		this.setContent(tabelaDePessoas);
		this.fitToWidthProperty().set(true);
		this.fitToHeightProperty().set(true);
		this.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        this.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        

    }

    public TableView<Pessoa> getTableview(){
        return tabelaDePessoas;
    }
}
