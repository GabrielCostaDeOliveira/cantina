package cantina.visao;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarJanela extends MenuBar {
	private Menu cadastro;

	private MenuItem pessoa;
	private MenuItem protudos;

	private Menu processos;
	private MenuItem vendas;
	private MenuItem pagamentos;

	private Menu relatorio;
	private MenuItem grafico;
	private MenuItem gerarRelatorio;

	MenuBarJanela() {
		cadastro = new Menu("Cadastro");
		pessoa = new MenuItem("Pessoas");
		protudos = new MenuItem("Produtos");
		cadastro.getItems().addAll(pessoa, protudos);

		processos = new Menu("Processos");
		vendas = new MenuItem("Vendas");
		pagamentos = new MenuItem("Pagamentos");
		processos.getItems().addAll(vendas, pagamentos);

		relatorio = new Menu("Relatórios");
		grafico = new MenuItem("Graficos");
		gerarRelatorio = new MenuItem("Relatório");
		relatorio.getItems().addAll(grafico, gerarRelatorio);

		this.getMenus().addAll(cadastro, processos, relatorio);

	}

	public Menu getCadastro() {
		return cadastro;
	}

	public MenuItem getPessoa() {
		return pessoa;
	}

	public MenuItem getProtudos() {
		return protudos;
	}

	public Menu getProcessos() {
		return processos;
	}

	public MenuItem getVendas() {
		return vendas;
	}

	public MenuItem getPagamentos() {
		return pagamentos;
	}

	public Menu getRelatorio() {
		return relatorio;
	}

	public MenuItem getGrafico() {
		return grafico;
	}

	public MenuItem getGerarRelatorio() {
		return gerarRelatorio;
	}
}
