package cantina.eventos;

import cantina.visao.*;
import cantina.servicos.Validacao;

import javafx.scene.control.Button;

import cantina.dados.Cantina;
import cantina.dados.Pessoa;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventoCadastroDePessoa {
    
    public static EventHandler<ActionEvent> eventoCadastroDePessoas(Button novoButton, Button alterarButton, TabelaDePessoas tabelaDePessoas,Cantina cantina) {
        return new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent evento) {
                if(evento.getSource() == novoButton){ 
                    novoCadastroDePessoa(cantina, tabelaDePessoas);;
                }else if(evento.getSource()==alterarButton){
                    alterarCadastroDepessoa(cantina, tabelaDePessoas);;
                }else
                    excluirCadastroDePessoa(cantina, tabelaDePessoas);;
                }
        };
    }

    private static void novoCadastroDePessoa(Cantina cantina,TabelaDePessoas tabelaDePessoas){
        PalcoCadastroDePessoas palcoCadastroDePessoas =new PalcoCadastroDePessoas();
    
        palcoCadastroDePessoas.setTitle("cadastrar Pessoa");
        palcoCadastroDePessoas.limpaPainelDeDados();
        palcoCadastroDePessoas.show();
        palcoCadastroDePessoas.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ok_Novo) {
                String nome     = palcoCadastroDePessoas.getTextFieldNome().getText();
                String telefone = palcoCadastroDePessoas.getTextFielTelefone().getText();
                String ramo     = palcoCadastroDePessoas.getChoiceBoxRamo().getSelectionModel().getSelectedItem();
                
                if (Validacao.validaNomePessoa(nome, cantina) && Validacao.validaNumero(telefone) && ramo != null) {
                    Pessoa pessoa = new Pessoa(nome, Long.parseLong(telefone), ramo);
                    cantina.setPessoa(pessoa);
                    tabelaDePessoas.getTableview().refresh();
                    palcoCadastroDePessoas.close();
                } else {
                    palcoCadastroDePessoas.close();
                    Dialogo.mostrarAviso("não foi cadastrado");
                }
            }
        });
    }
    
    private static void alterarCadastroDepessoa(Cantina cantina,TabelaDePessoas tabelaDePessoas){
        PalcoCadastroDePessoas palcoCadastroDePessoas =new PalcoCadastroDePessoas();
        Pessoa pessoa_selecionada = tabelaDePessoas.getTableview().getSelectionModel().getSelectedItem();
				
        if(pessoa_selecionada!=null) {
            palcoCadastroDePessoas.setTitle("Alterar Pessoas");
            palcoCadastroDePessoas.mostarPessoa(tabelaDePessoas);
            palcoCadastroDePessoas.show();
            palcoCadastroDePessoas.getOkButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent alterar) {
                    
                    String nome_novo = palcoCadastroDePessoas.getTextFieldNome().getText();
                    String telefone_novo = palcoCadastroDePessoas.getTextFielTelefone().getText();
                    String ramo_novo = palcoCadastroDePessoas.getChoiceBoxRamo().getSelectionModel().getSelectedItem();
                    
                    if (Validacao.validaNomePessoa(nome_novo, cantina) && Validacao.validaNumero(telefone_novo) && ramo_novo != null) {
                        pessoa_selecionada.setNome(nome_novo);
                        pessoa_selecionada.setRamo(ramo_novo);
                        pessoa_selecionada.setTelefone(telefone_novo);

                        tabelaDePessoas.getTableview().refresh();
                        
                        palcoCadastroDePessoas.close();
                    }
                }
            });
        }else
        Dialogo.mostrarAviso("Nenhum pessoa foi selecionada");
    }
    
    private static void excluirCadastroDePessoa(Cantina cantina, TabelaDePessoas tabelaDePessoas){
        Pessoa pessoa = tabelaDePessoas.getTableview().getSelectionModel().getSelectedItem();
        if (pessoa != null) {
            if (Dialogo.fazerPergunta("Você deseja excluir (a/o) " + pessoa.getNome())) {
                tabelaDePessoas.getTableview().getItems().remove(pessoa);
                cantina.getPessoas().remove(pessoa);
            }
        } else
            Dialogo.mostrarAviso("Nenhum item foi selecionado !!!");
    }

}