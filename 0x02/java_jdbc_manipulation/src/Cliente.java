public class Cliente {
	
	private String nome;
	private Integer idade;
	private String cpf;
	private String RG;
	
	public Cliente(){
		
	}
	
	public Cliente(String nome, Integer idade, String cpf, String Rg) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		RG = Rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = Rg;
	}

}
