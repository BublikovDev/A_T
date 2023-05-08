package Lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassExample {

    public static void main(String[] args) {

        MyClass myObject = new MyClass();

        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " : " + method.getReturnType());
        }

        try {
            Method method = MyClass.class.getDeclaredMethod("myMethod", String.class);
            String result = (String) method.invoke(myObject, "Hello, World!");
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static class MyClass {

        public int myInt;
        private String myString;

        public void setMyString(String myString) {
            this.myString = myString;
        }

        public String getMyString() {
            return myString;
        }

        public String myMethod(String input) {
            return "Input: " + input;
        }
    }
}