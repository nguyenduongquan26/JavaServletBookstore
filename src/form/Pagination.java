package form;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pagination extends SimpleTagSupport {
	private int n;
	private String url;

	public void setN(int n) {
		this.n = n;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		JspWriter wt = context.getOut();
		wt.write("<ul class=\"pagination\">");
		int p=1;
		if(context.getRequest().getParameter("p")!=null) {
			p=Integer.parseInt(context.getRequest().getParameter("p"));
		}
		for(int i=1;i<=n;i++) {
			if(p==i) {
			wt.write("<li class=\"page-item active\">");
			}else {
			wt.write("<li class=\"page-item\">");
			}
			wt.write(String.format("<a class=\"page-link\" href=\"%s?p=%d\">%d</a>",url,i,i));
			wt.write("</li>");
		}
		wt.write("</ul>");
	}
}
