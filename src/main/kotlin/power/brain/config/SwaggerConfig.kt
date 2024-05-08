package power.brain.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Brain Full Power")
                    .description("두뇌풀가동")
                    .version("v0.0.1")
//                    .license(License().name("Apache 2.0").url("https://springdoc.org"))
            )
//            .externalDocs(
//                ExternalDocumentation()
//                    .description("SpringShop Wiki Documentation")
//                    .url("https://springshop.wiki.github.org/docs")
//            )
    }
}