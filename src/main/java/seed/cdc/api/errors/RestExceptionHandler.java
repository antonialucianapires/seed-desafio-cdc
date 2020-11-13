package seed.cdc.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroResponse> handle(MethodArgumentNotValidException exception) {

        List<ErroResponse> listaDeErros = new ArrayList<>();
        List<FieldError> errosField =exception.getBindingResult().getFieldErrors();

        errosField.forEach(erro -> {
            ErroResponse erroDto = new ErroResponse(erro.getField(), erro.getDefaultMessage());
            listaDeErros.add(erroDto);
        });

        return listaDeErros;
    }

}
