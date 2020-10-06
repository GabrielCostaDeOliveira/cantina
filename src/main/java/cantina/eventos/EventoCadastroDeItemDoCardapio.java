package cantina.eventos;

import cantina.dados.Cantina;
import cantina.dados.ItemDoCardapio;
import cantina.servicos.Validacao;

import cantina.visao.PalcoCadastroDeItemDoCardapio;
import cantina.visao.TabelaDoCardapio;
import cantina.visao.Dialogo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventoCadastroDeItemDoCardapio {
    public static EventHandler<ActionEvent> EventoCadastroItemDoCardapio(Button novoButton, Button alterarButton,
            TabelaDoCardapio tabelaDoCardapio, Cantina cantina) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evento) {
                if (evento.getSource() == novoButton) {
                    novoCadastroDeItemDoCardapio(cantina, tabelaDoCardapio);

                } else if (evento.getSource() == alterarButton) {
                    alterarCadastroDePessoas(cantina, tabelaDoCardapio);

                } else
                    excluirItemDoCardapio(cantina, tabelaDoCardapio);

            }
        };

    }

    private static void novoCadastroDeItemDoCardapio(Cantina cantina, TabelaDoCardapio tabelaDoCardapio) {

        PalcoCadastroDeItemDoCardapio palcoCadastroDeItemDoCardapio = new PalcoCadastroDeItemDoCardapio();

        palcoCadastroDeItemDoCardapio.setTitle("Cadastrar Produto");
        palcoCadastroDeItemDoCardapio.show();
        palcoCadastroDeItemDoCardapio.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nome = palcoCadastroDeItemDoCardapio.getTextFieldNome().getText();
                String valor = palcoCadastroDeItemDoCardapio.getTextFieldValor().getText();
                String descricao = palcoCadastroDeItemDoCardapio.getTextAreaDescricao().getText();

                if (Validacao.validaNomeDoItemDoCardapio(nome) && Validacao.validaNumero(valor)) {
                    ItemDoCardapio itemDoCardapio = new ItemDoCardapio(nome,valor,descricao);
                    cantina.setCardapio(itemDoCardapio);
                    tabelaDoCardapio.getItems().add(itemDoCardapio);


                    palcoCadastroDeItemDoCardapio.close();
                }

            }

        });

    }

    private static void alterarCadastroDePessoas(Cantina cantina, TabelaDoCardapio tabelaDoCardapio) {
        PalcoCadastroDeItemDoCardapio palcoCadastroDeItemDoCardapio = new PalcoCadastroDeItemDoCardapio();
        ItemDoCardapio itemDoCardapio_selecionado = tabelaDoCardapio.getSelectionModel().getSelectedItem();

        if (itemDoCardapio_selecionado != null) {
            palcoCadastroDeItemDoCardapio.setTitle("Alterar Item do cardapio");
            palcoCadastroDeItemDoCardapio.mostrarItemDoCardapio(itemDoCardapio_selecionado);
            palcoCadastroDeItemDoCardapio.show();
            palcoCadastroDeItemDoCardapio.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    String nome_novo = palcoCadastroDeItemDoCardapio.getTextFieldNome().getText();
                    String valor_novo = palcoCadastroDeItemDoCardapio.getTextFieldValor().getText();
                    String descricao_novo = palcoCadastroDeItemDoCardapio.getTextAreaDescricao().getText();

                    if (Validacao.validaNomeDoItemDoCardapio(nome_novo) && Validacao.validaNumero(valor_novo)) {
                        itemDoCardapio_selecionado.setNome(nome_novo);
                        itemDoCardapio_selecionado.setValor(valor_novo);
                        itemDoCardapio_selecionado.setDescricao(descricao_novo);

                        tabelaDoCardapio.refresh();


                        palcoCadastroDeItemDoCardapio.close();
                    }
                }
            });

        }
    }

    private static void excluirItemDoCardapio(Cantina cantina, TabelaDoCardapio tabelaDoCardapio) {
        ItemDoCardapio itemDoCardapio = tabelaDoCardapio.getSelectionModel().getSelectedItem();

        if (itemDoCardapio != null) {
            if (Dialogo.fazerPergunta("Você deseja exvluir (a/o) " + itemDoCardapio.toString())) {
                tabelaDoCardapio.getItems().remove(itemDoCardapio);
                cantina.getCardapio().remove(itemDoCardapio);
            }
        }

    }
}