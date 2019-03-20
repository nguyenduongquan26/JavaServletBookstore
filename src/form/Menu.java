package form;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import model.Category;

public class Menu extends SimpleTagSupport{
	private List<Category> list;

	public void setList(List<Category> list) {
		this.list = list;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext) getJspContext();
		JspWriter wt = getJspContext().getOut();
		String st = "<li><a href=\"%s/home/browser.html?id=%d\">%s</a></li>";
		wt.write("<ul>");
		for(Category p:list) {
			if(p.getParent()==0) {
				wt.write("<li>");
				wt.write(p.getName());
				wt.write("<ul>");
				for(Category c:list) {
					if(c.getParent()==p.getId())
						wt.write(String.format(st,context.getServletContext().getContextPath(),c.getId(),c.getName()));
				}
				wt.write("</ul>");
				wt.write("</li>");
			}
			
		}
		wt.write("</ul>");
	}
}
