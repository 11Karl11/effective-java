package chapter24.annotation;

/**
 * @author karl xie
 */

import java.lang.reflect.Method;

public class SecurityAspect {
    public void checkSecurity(Object object, String methodName, Object... args) throws Exception {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                if (method.isAnnotationPresent(Secure.class)) {
                    // 在这里,我们可以执行安全性检查
                    System.out.println("Performing security check...");
                }

                method.invoke(object, args);
                return;
            }
        }

        throw new NoSuchMethodException("Method " + methodName + " not found in " + clazz.getName());
    }
}