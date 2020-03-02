package nnglebanov.daoexample.rest

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PagesController {

    @GetMapping("/")
    fun indexPage(): String {
        return "index"
    }

    @GetMapping("/public.html")
    fun publicPage(): String {
        val securityContext = SecurityContextHolder.getContext()
        val authentication = securityContext.authentication
        println(authentication.principal)
        return "public.html"
    }

    @GetMapping("/authenticated")
    fun authenticatedPage(): String {
        val securityContext = SecurityContextHolder.getContext()
        val authentication = securityContext.authentication
        val userDetails = authentication.principal as UserDetails
        println(userDetails.username)
        return "authenticated"
    }

    @GetMapping("/success")
    fun successPage(): String {
        return "success"
    }

    @GetMapping("/error")
    fun errorPage(): String {
        return "error"
    }
}