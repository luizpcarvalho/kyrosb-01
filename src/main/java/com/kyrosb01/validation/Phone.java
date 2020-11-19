package com.kyrosb01.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = { })
@Pattern(message = "Número de telefone inválido!", regexp = "^\\(?([1-9]{2})?\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")
public @interface Phone {

    String message() default "Número de telefone inválido!";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}