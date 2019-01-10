package DonnaGulaModels;

public class Doces {
	private long id;
	private String nome;
	private String recheio;
	private int preco;
	
	@Override
	public String toString() {
		return "doces [id=" + id + ", nome=" + nome + ", recheio=" + recheio + ", preco=" + preco + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
