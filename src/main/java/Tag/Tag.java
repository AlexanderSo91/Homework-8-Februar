package Tag;

import org.springframework.core.metrics.StartupStep;

import java.lang.annotation.*;
import java.security.cert.Extension;

@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Tag {
    String name();

    String deskription() default "";




}
