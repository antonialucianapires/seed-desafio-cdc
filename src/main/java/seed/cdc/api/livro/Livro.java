package seed.cdc.api.livro;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import seed.cdc.api.autor.Autor;
import seed.cdc.api.categoria.Categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private Date dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, String isbn, Date dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
