package DonnaGulaModels;

public class Salgados {
	private long id;
	private String nome;
	private String recheio;
	private int preco;
	
	@Override
	public String toString() {
		return "salgados [id=" + id + ", nome=" + nome + ", recheio=" + recheio + ", preco=" + preco + "]";
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRecheio() {
		return recheio;
	}
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
}