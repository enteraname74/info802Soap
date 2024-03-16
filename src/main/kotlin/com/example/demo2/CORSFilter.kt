package com.example.demo2

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.FilterConfig
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletResponse

@WebFilter(urlPatterns = ["/*"])
class CORSFilter : Filter {
    override fun init(filterConfig: FilterConfig?) {}

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        if (response is HttpServletResponse) {
            response.setHeader("Access-Control-Allow-Origin", "*")
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
            response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization")
            response.setHeader("Access-Control-Max-Age", "3600")
        }
        chain?.doFilter(request, response)
    }

    override fun destroy() {}
}