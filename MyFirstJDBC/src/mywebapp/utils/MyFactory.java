package mywebapp.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFactory {

	public static Object getInstance(final Class<?> clazzInterface) {

		Object result = null;

		if (!clazzInterface.isInterface()) {
			throw new IllegalArgumentException("Ceci n'est pas une interface!");
		}

		String interfaceName = clazzInterface.getSimpleName();

		String className = clazzInterface.getPackage().getName() + "." + interfaceName.substring(1);

		Class<?> clazzToInstance = null;

		try {
			clazzToInstance = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			throw new IllegalArgumentException("Aucune implémentation trouvée pour cette interface!");
		}

		try {
			Method methodToCall = clazzToInstance.getMethod("getInstance", new Class[0]);

			result = methodToCall.invoke(null, new Object[0]);

		} catch (SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException("Problème de sécurité");
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException("La classe d'implémentation ne respecte pas le pattern singleton (getInstance)!");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Accès aux invocation interdit!");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Problème d'invocation!");
		}

		return result;

	}

}
