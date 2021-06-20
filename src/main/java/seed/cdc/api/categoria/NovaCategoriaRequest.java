package seed.cdc.api.categoria;

import seed.cdc.api.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "O nome da categoria não pode ser nulo e/ou vazio")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria toCategoria() {
        Categoria categoria = new Categoria(this.nome);
        return categoria;
    }

}
