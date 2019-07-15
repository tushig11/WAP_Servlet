package custom_tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class CSSTag extends SimpleTagSupport {

    private String file;

    public void setFile(String fileName){
        this.file = fileName;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if(file != null)
            out.write(String.format("<link href='resources/css/%s' type='text/css' rel='stylesheet' />", file));
    }


}
