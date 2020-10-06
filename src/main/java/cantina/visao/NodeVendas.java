package cantina.visao;

import cantina.dados.Cantina;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.HBox;

public class NodeVendas extends BorderPane{
    
    private SplitPane splitPane;

    private HBox hboxBotoes;
	private Button novoButton;
	private Button alterarButton;
    private Button excluirButton;

    private TabelaDePedidos tabelaDePedidos;
    private Button pesquisarPedidosButton;

    private TabelaDePessoas tabelaDePessoas;
    private Button pesquisarPessoasButton;

    public NodeVendas(Cantina cantina){
        //DIVISAO DE PEDIDOS
        tabelaDePedidos   = new TabelaDePedidos();
        
        pesquisarPessoasButton  = new Button("Pesquisar");
        pesquisarPessoasButton.setPadding(new Insets(10, 10, 10, 10));

        //DIVISAO DE PESSOAS
        tabelaDePessoas = new TabelaDePessoas(cantina.getPessoas());

        pesquisarPedidosButton = new Button("Pesquisar");
        pesquisarPedidosButton.setPadding(new Insets(10,10,10,10));

        pesquisarPessoasButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                new PalcoPesquisaDePessoas(cantina).show();
            }
            
        });
        // BOTÕES
		novoButton = new Button("Novo");
		alterarButton = new Button("Alterar");
		excluirButton = new Button("Excluir");

		hboxBotoes = new HBox(10, novoButton, alterarButton, excluirButton);
        hboxBotoes.setPadding(new Insets(20, 20, 20, 20));
        

        //EVENTO DOS BOTÕES



        //BORDERPANE
        splitPane = new SplitPane(new BorderPane(tabelaDePedidos, null, null, pesquisarPedidosButton, null),new BorderPane(tabelaDePessoas, null, null, pesquisarPessoasButton, null));

        this.setCenter(splitPane);
        this.setBottom(hboxBotoes);

    }


}