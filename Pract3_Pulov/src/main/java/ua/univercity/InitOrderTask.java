package ua.univercity;

class BaseInit {
    static {
        System.out.println("1. BaseInit: Static block");
    }

    {
        System.out.println("3. BaseInit: Instance block");
    }

    public BaseInit() {
        System.out.println("4. BaseInit: Constructor");
    }
}

class ChildInit extends BaseInit {
    static {
        System.out.println("2. ChildInit: Static block");
    }

    {
        System.out.println("5. ChildInit: Instance block");
    }

    public ChildInit() {
        System.out.println("6. ChildInit: Constructor");
    }
}

public class InitOrderTask {

    public void run() {
        new ChildInit();
    }

    public static void main(String[] args) {
        new InitOrderTask().run();
    }
}