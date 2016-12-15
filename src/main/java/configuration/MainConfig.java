package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Valentina on 12.12.2016.
 */
@Configuration
@Import(DataBase.class)
public class MainConfig {
}
