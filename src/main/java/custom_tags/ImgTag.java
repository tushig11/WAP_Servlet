package custom_tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ImgTag extends SimpleTagSupport {

    private String file;
    private String alt;

    public void setFile(String fileName){
        this.file = fileName;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if(alt != null)
            out.write(String.format("<img src='resources/images/%s' alt='%s' />", file, alt));
        else
            out.write(String.format("<img src='resources/images/%s'/>", file));
    }


}
