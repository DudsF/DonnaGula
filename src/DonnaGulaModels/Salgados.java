package DonnaGulaModels;

public class Salgados {
	private long id;
	private String nome;
	private String recheio;
	private float preco;
	
	@Override
	public String toString() {
		return "salgados [id=" + id + ", nome=" + nome + ", recheio=" + recheio + ", preco=" + preco + "]";
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	

	}

