//package power.brain.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.cors.CorsConfiguration
//import org.springframework.web.cors.CorsConfigurationSource
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource
//import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//
//
//
//@Configuration
//@EnableWebMvc
//class WebConfig : WebMvcConfigurer {
//
////    @Bean
////    fun corsConfigurer(): WebMvcConfigurer {
////        return object : WebMvcConfigurer {
////            override fun addCorsMappings(registry: CorsRegistry) {
////                registry.addMapping("/**")
////                    .allowedOrigins("https://web-brainfullpower-7lk2blotveo7c.sel5.cloudtype.app")
////                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
////                    .allowedHeaders("*")
////                    .allowCredentials(false)
////                    .maxAge(3600)
////                    .exposedHeaders("Access-Control-Allow-Origin")
////            }
////        }
////    }
//
////    @Throws(Exception::class)
////    override fun configure(http: HttpSecurity) {
////        http.cors().and().csrf().disable()
////    }
//
//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource {
//        val configuration = CorsConfiguration()
//        configuration.allowedOrigins = listOf("*") // 실제 도메인으로 변경 필요
//        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
//        configuration.allowCredentials = true
//
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }
//}