package seed.cdc.api.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsIdValidator.class)
public @interface ExistsId {
    String message() default "{exists.id}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();
    String fieldName();

    boolean isOptional() default false;

}
