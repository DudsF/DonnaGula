package DonnaGulaModels;

public class Cliente {
 
	private Long id;
	private String nome;
	private String endereco;
	private String email;
	private int contato;
	private String cartao;
	private String senha;
	
	@Override
	public String toString() {
		return "cliente [id=" + id +", nome=" + nome + ",endereco=" + endereco + ",email=" + email + ",contato=" + contato + ",cartao=" + cartao + ",senha=" + senha + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContato() {
		return contato;
	}
	public void setContato(int contato) {
		this.contato = contato;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
