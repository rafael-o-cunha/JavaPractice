package domain;

public class ColaboradorDomain implements IDomain<Long> {
    private final Long id;
    private String nome;
    private String email;
    private String cargo;
    private boolean ativo;

    //preservando inicialização de id e estado
    private ColaboradorDomain() {}

    public ColaboradorDomain(Long id, String nome, String email, String cargo) {
        this.id = id;
        this.ativo = true;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Long getId() {
        return this.id;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String toString() {
        return "{ " + String.join(", ", 
            "Id: " + this.id,
            "Nome: " + this.nome,
            "E-mail: " + this.email,
            "Cargo: " + this.cargo,
            "Ativo: " + this.ativo) + " }";
    }
}
