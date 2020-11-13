package seed.cdc.api.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do autor não pode ser nulo e/ou vazio.")
    private String nome;

    @NotBlank(message = "O e-mail do autor não pode ser nulo e/ou vazio.")
    @Email(message = "O e-mail deve ser válido.")
    private String email;

    @NotBlank(message = "A descrição não pode ser nula e/ou vazia.")
    @Size(max = 400, message = "A descrição não pode ultrapassar 400 caracteres.")
    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor(String nome,  String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
