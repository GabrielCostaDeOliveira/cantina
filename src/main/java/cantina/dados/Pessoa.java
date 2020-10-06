package cantina.dados;


public class Pessoa {
	private StringBuilder nome;
	private StringBuilder ramo;
	private Long telefone;
	private Boolean temDivida;
//	private ArrayList<Pedido> pedidos;

	// CONSTRUTORES
	public Pessoa(String nome, Long telefone, String ramo) {
		this.nome = new StringBuilder(nome);
		this.telefone = telefone;
		this.ramo = new StringBuilder(ramo);
		this.temDivida = false;
	}

	public Pessoa(Double despesa) {
		this.nome = null;
		this.telefone = null;
		this.ramo = null;
		this.temDivida = null;
	}

	// TOSTRING

	public String toString() {
		return nome.toString();
	}

	// METODOS GETTER E SETTER
	public StringBuilder getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = new StringBuilder(nome);
	}

	public StringBuilder getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = new StringBuilder(ramo);
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = Long.parseLong(telefone);
	}

	public Boolean getTemDivida() {
		return temDivida;
	}

	public void saldarDivida() {
		this.temDivida = true;
	}

/*	public ArrayList<Pedido> getPedido() {
		return pedidos;
	}

	public void setPedido(Pedido pedido) {
		pedidos.add(pedido);
	} */

}
