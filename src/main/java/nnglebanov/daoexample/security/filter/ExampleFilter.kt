package nnglebanov.daoexample.security.filter

import org.springframework.web.filter.GenericFilterBean
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class ExampleFilter : GenericFilterBean() {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        servletRequest.parameterMap["SpecialValue"] = arrayOf("My dirty secret")
    }
}