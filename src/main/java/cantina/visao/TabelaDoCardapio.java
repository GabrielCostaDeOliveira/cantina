package cantina.visao;

import cantina.dados.ItemDoCardapio;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaDoCardapio extends TableView<ItemDoCardapio> {
    TableColumn<ItemDoCardapio, String> nomeColuna;
    TableColumn<ItemDoCardapio, String> ramoColuna;
    TableColumn<ItemDoCardapio, String> telefoneColuna;


    public TabelaDoCardapio(){
        nomeColuna = new TableColumn<ItemDoCardapio, String>("Nome");
        ramoColuna = new TableColumn<ItemDoCardapio, String>("Volor");
        telefoneColuna = new TableColumn<ItemDoCardapio, String>("Descrição");


        nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ramoColuna.setCellValueFactory(new PropertyValueFactory<>("valor"));
        telefoneColuna.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        this.getColumns().addAll(nomeColuna, ramoColuna, telefoneColuna);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.getItems().add(new ItemDoCardapio( "combo 1 ","7.25", "cacorro quente\nrefrigerante\nbolo"));


    }



}