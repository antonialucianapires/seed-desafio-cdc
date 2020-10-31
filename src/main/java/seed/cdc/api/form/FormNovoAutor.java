package seed.cdc.api.form;

import seed.cdc.api.domain.Autor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormNovoAutor {

    @NotBlank(message = "O nome do autor não pode ser nulo e/ou vazio.")
    private String nome;

    @NotBlank(message = "O e-mail do autor não pode ser nulo e/ou vazio.")
    private String email;

    @NotBlank(message = "A descrição não pode ser nula e/ou vazia.")
    @Size(max = 400, message = "A descrição não pode ultrapassar 400 caracteres.")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toModel(String nome, String email, String descricao) {
        return new Autor(nome, email, descricao);
    }

}
