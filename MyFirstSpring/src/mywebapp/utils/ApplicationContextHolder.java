package mywebapp.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Singleton qui contient le contexte de Spring.
 * 
 * @author Cédric DELRUE.
 * 
 */
public class ApplicationContextHolder {

	private static final String APPLICATION_CONTEXT_XML = "applicationContext.xml";
	private static final ApplicationContextHolder INSTANCE = new ApplicationContextHolder();

	private final ApplicationContext context;

	private ApplicationContextHolder() {
		context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
	}

	public static ApplicationContextHolder getInstance() {
		return INSTANCE;
	}

	public ApplicationContext getSpringApplicationContext() {
		return context;
	}
	
	public static Object getBean(final String nomDuBeanACharger) {
        return getInstance().context.getBean(nomDuBeanACharger);
    }
}
