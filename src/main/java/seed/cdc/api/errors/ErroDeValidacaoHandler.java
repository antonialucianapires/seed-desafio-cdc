package seed.cdc.api.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDTO> handle(MethodArgumentNotValidException exception) {

        List<ErroDeFormularioDTO> listaDeErros = new ArrayList<>();
        List<FieldError> errosField =exception.getBindingResult().getFieldErrors();

        errosField.forEach(erro -> {
            ErroDeFormularioDTO erroDto = new ErroDeFormularioDTO(erro.getField(), erro.getDefaultMessage());
            listaDeErros.add(erroDto);
        });

        return listaDeErros;
    }

}
