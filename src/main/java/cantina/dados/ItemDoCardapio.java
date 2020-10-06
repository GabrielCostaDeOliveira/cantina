package cantina.dados;

public class ItemDoCardapio {

	StringBuilder nome;
	Double valor;
	StringBuilder descricao;

	public ItemDoCardapio(String nome, String valor,String descricao) {
		this.nome      = new StringBuilder(nome);
		this.valor     = Double.parseDouble(valor);
		this.descricao = new StringBuilder(descricao);
	}

	// TOSTRING
	public String toString() {
		return nome.toString();
	}

	// GETTER E SETTER
	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = new StringBuilder(nome);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = Double.parseDouble(valor);
	}

	public StringBuilder getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = new StringBuilder(descricao);
	}

}
