package ua.univercity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StepRunner {

    public static void run(Object target) {
        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> stepMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Step.class)) {
                if (method.getReturnType() != void.class || method.getParameterCount() > 0) {
                    throw new StepExecutionException("Invalid signature: " + method.getName());
                }
                stepMethods.add(method);
            }
        }

        stepMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));

        for (Method method : stepMethods) {
            try {
                method.setAccessible(true);
                System.out.println("Running step: " + method.getName());
                method.invoke(target);
            } catch (IllegalAccessException e) {
                throw new StepExecutionException("Access denied: " + method.getName(), e);
            } catch (InvocationTargetException e) {
                throw new StepExecutionException("Execution failed: " + method.getName(), e.getCause());
            }
        }
    }
}