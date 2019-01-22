package DonnaGulaModels;

public class Carrinho {
	
	private long id;
	private String doce;
	private String salgado;
	private int quantidade;
	private String preco;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoce() {
		return doce;
	}
	public void setDoce(String doce) {
		this.doce = doce;
	}
	public String getSalgado() {
		return salgado;
	}
	public void setSalgado(String salgado) {
		this.salgado = salgado;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}