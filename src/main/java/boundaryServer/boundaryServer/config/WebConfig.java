package boundaryServer.boundaryServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // application.properties에서 설정한 값 불러오기
    @Value("${cors.allowed.origins}")
    private String[] allowedOrigins;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해 CORS 허용
                .allowedOrigins(allowedOrigins)  // properties에서 불러온 도메인 사용
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 메서드
                .allowedHeaders("*")  // 모든 헤더 허용
                .allowCredentials(true);  // 인증 정보 허용 (쿠키, 인증 헤더)
    }
}
