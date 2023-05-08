package Lab4;

public class GenericInterfaceExample {

    public static void main(String[] args) {

        MyGenericClass<String> stringObject = new MyGenericClass<>("Hello, World!");
        MyGenericClass<Integer> integerObject = new MyGenericClass<>(42);

        stringObject.printType();
        integerObject.printType();
    }

    interface MyGenericInterface<T> {

        void printType(T t);
    }

    static class MyGenericClass<T> implements MyGenericInterface<T> {

        private T t;

        public MyGenericClass(T t) {
            this.t = t;
        }

        public void printType() {
            System.out.println(t.getClass().getSimpleName());
        }

        @Override
        public void printType(T t) {
            System.out.println(t.getClass().getSimpleName());
        }
    }
}