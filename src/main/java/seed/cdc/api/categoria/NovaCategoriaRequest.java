package seed.cdc.api.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "O nome da categoria não pode ser nulo e/ou vazio")
    private String nome;

    public Categoria toCategoria() {
        Categoria categoria = new Categoria(this.nome);
        return categoria;
    }

}
