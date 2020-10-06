package cantina.visao;

import java.util.Date;

import cantina.dados.ItemDoCardapio;
import cantina.dados.Pedido;
import cantina.dados.Pessoa;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TabelaDePedidos extends ScrollPane{

    TableView<Pedido> tabelaDePedidos;
    TableColumn<Pedido,String> nomeDoDonoDoPedidoteColuna;
    TableColumn<Pedido,Date> dataColuna;
    TableColumn<Pedido,String> ItemsDoPedidoColuna;

    public TabelaDePedidos(){
        nomeDoDonoDoPedidoteColuna = new TableColumn<Pedido,String>("Pessoa");
        dataColuna                 = new TableColumn<Pedido,Date>("Data");
        ItemsDoPedidoColuna        = new TableColumn<Pedido,String>("Items Do Pedido");

        nomeDoDonoDoPedidoteColuna.setCellValueFactory(new PropertyValueFactory<>("Pessoa"));
        dataColuna.setCellValueFactory(new PropertyValueFactory<>("DataFormatada"));
        ItemsDoPedidoColuna.setCellValueFactory(new PropertyValueFactory<>("NomesDosItemsFormatados"));

        tabelaDePedidos= new TableView<>();
        tabelaDePedidos.getColumns().addAll(nomeDoDonoDoPedidoteColuna, dataColuna,ItemsDoPedidoColuna);
        tabelaDePedidos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabelaDePedidos.setPadding(new Insets(10,10,10,10));

		this.setPadding(new Insets(10, 10, 10, 10));
	
		this.setContent(tabelaDePedidos);
		this.fitToWidthProperty().set(true);
		this.fitToHeightProperty().set(true);
		this.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        this.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        tabelaDePedidos.getItems().add(new Pedido(new Pessoa("Juliana Souza dos Remédios", 123453434l,"Pioneiro"), FXCollections.observableArrayList(new ItemDoCardapio( "combo 1 ","7.25", "cacorro quente\nrefrigerante\nbolo"))));

    }
    
}