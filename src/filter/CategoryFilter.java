package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import model.CategoryRepository;


@WebFilter(urlPatterns= {"/home.html","/home/*","/upload/*","/cart.html","/cart/*"})
public class CategoryFilter implements Filter {

	CategoryRepository repository = new CategoryRepository();
	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setAttribute("categories", repository.getCategories2());
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
