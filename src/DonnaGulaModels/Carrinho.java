package DonnaGulaModels;

public class Carrinho {
	
	private long id;
	private Doces doces;
	private Salgados salgados;
	private int quantidade;
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	private float preco;
	
	@Override
	public String toString() {
		return " carrinho [id=" + id + ", doces=" + doces + ", salgados=" + salgados + ", quantidade=" + 
			quantidade	+ ", preco=" + preco + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Doces getDoces() {
		return doces;
	}

	public void setDoces(Doces doces) {
		this.doces = doces;
	}

	public Salgados getSalgados() {
		return salgados;
	}

	public void setSalgados(Salgados salgados) {
		this.salgados = salgados;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}



}