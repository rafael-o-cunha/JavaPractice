package models;

public class Produto {
	private String nome;
	private double preco;
	private Integer quantidade = 0;
	
	
	public Produto() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantity) {
		this.quantidade = quantity;
	}
	
	public double valorTotalEmEstoque() {
		return ((double)this.quantidade) * this.preco;
	}
	
	public void adicionarProdutos(Integer quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removerProdutos(Integer quantidade) {
		this.quantidade -= quantidade;
	}

	@Override
	public String toString() {
		String str;
		
		str = 	"Nome: " + this.nome + ", ";
		str +=	"$ " + this.preco + ", ";
		str +=	this.quantidade + " unidades, ";
		str +=	"Total: $ " + String.format("%.2f", this.valorTotalEmEstoque());
				
		return str;
	}
	
	
	
}
