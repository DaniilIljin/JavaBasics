package reflection.tester;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private ArrayList<String> testResults = new ArrayList<>();

    public void runTests(List<String> testClassNames) {
        for (String testClassName : testClassNames) {
            try {
                Class<?> clazz = Class.forName(testClassName);
                runMethods(clazz);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

private Object getInstance(Class<?> clazz){
    try {
        return clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
        throw new RuntimeException("Can not create an instance");
    }
}

    private void runMethods(Class<?> clazz){
        for (Method method : clazz.getDeclaredMethods()) {
            MyTest annotation = method.getAnnotation(MyTest.class);
            if(annotation != null){
                try {
                    method.invoke(getInstance(clazz));
                    if(Exception.class.isAssignableFrom(annotation.expected())){
                        testResults.add(method.getName() + "() - FAILED");
                    } else {
                        testResults.add(method.getName() + "() - OK");
                    }
                } catch (Exception e) {
                    if (annotation.expected().isAssignableFrom(e.getCause().getClass()) || annotation.expected() == e.getClass()) {
                        testResults.add(method.getName() + "() - OK");
                    } else {
                        testResults.add(method.getName() + "() - FAILED");
                    }
                }
            }
        }
    }

    public String getResult() {
        return String.join("", testResults);
    }
}
