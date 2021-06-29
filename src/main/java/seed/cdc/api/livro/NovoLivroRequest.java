package seed.cdc.api.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import seed.cdc.api.autor.Autor;
import seed.cdc.api.categoria.Categoria;
import seed.cdc.api.compartilhado.ExistsId;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

public class NovoLivroRequest {

    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private Double preco;
    @Min(100)
    private Integer numeroDePaginas;
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public NovoLivroRequest(String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, String isbn, LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }
}
