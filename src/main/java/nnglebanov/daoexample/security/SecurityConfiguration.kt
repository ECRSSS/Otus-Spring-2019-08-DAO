package nnglebanov.daoexample.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@EnableWebSecurity
open class SecurityConfiguration : WebSecurityConfigurerAdapter() {


    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/")
    }

    @Throws(Exception::class)
    public override fun configure(http: HttpSecurity) {
        http.csrf().disable()
                // По умолчанию SecurityContext хранится в сессии
                // Это необходимо, чтобы он нигде не хранился
                // и данные приходили каждый раз с запросом
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests().antMatchers("/public.html").anonymous()
                .and()
                .authorizeRequests().antMatchers("/authenticated", "/success").authenticated()
                .and().anonymous().authorities("ROLE_ANONYMOUS").principal("ya")
                .and()
                // Включает Form-based аутентификацию
                //
                .formLogin()

                .and().rememberMe()
        http.rememberMe()
                .key("MyDirtySecret")
                .tokenValiditySeconds(50000)
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Autowired
    @Throws(Exception::class)
    public override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("admin").password("password").roles("ADMIN")
    }
}