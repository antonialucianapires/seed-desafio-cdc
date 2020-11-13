package seed.cdc.api.autor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank(message = "O nome não poder ser nulo e/ou vazio")
    private String nome;

    @NotBlank(message = "O e-mail não poder ser nulo e/ou vazio")
    private String email;

    @NotBlank(message = "A descrição não poder ser nula e/ou vazia")
    @Size(max = 400, message = "A descrição não pode ultrapassar 400 caracteres")
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
