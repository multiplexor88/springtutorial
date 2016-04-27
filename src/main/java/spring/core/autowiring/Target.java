package spring.core.autowiring;

/**
 * Created by multi on 21.04.2016.
 */
public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public void setFoo(Foo foo) {
        System.out.println("setFoo(Foo foo)");
        this.foo = foo;
    }

    public void setFoo2(Foo foo2) {
        System.out.println("setFoo2(Foo foo2)");
        this.foo2 = foo2;
    }

    public void setBar(Bar bar) {
        System.out.println("setBar(Bar bar)");
        this.bar = bar;
    }

    public Target(Bar bar, Foo foo) {
        System.out.println("Target(Bar bar, Foo foo) {");
        this.bar = bar;
        this.foo = foo;
    }

    public Target(Foo foo) {
        System.out.println("Target(Foo foo)");
        this.foo = foo;
    }


    public Target() {
        System.out.println("Target()");
    }

    @Override
    public String toString() {
        return "Target{" +
                "foo=" + foo +
                ", foo2=" + foo2 +
                ", bar=" + bar +
                '}';
    }
}
