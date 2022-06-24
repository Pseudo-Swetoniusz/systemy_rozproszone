package project.part.dictanswer;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

public class AppConfig extends ResourceConfig {

    public AppConfig() {
        packages("project.part.dictanswer");
        register(JspMvcFeature.class);
        register(MultiPartFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
    }
}
