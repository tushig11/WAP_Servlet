package custom_tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class JavaScriptTag extends SimpleTagSupport {

    private String file;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if(file != null)
            out.write(String.format("<script src='resources/js/%s'></script>", file));
    }

    public void setFile(String fileName){
        this.file = fileName;
    }
}
