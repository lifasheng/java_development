// reference: https://dzone.com/articles/removing-duplicate-code-with-lambda-expressions

class Exception1 extends Exception {

}

class Exception2 extends Exception {

}

class A { // mercury client
    public int getNode(String entityId) throws Exception1, Exception2 {
        return 12;
    }

    public void setNode(int node) throws Exception1, Exception2 {
        System.out.println("set node to " + node);
    }
}

////////////////////////////////////////////////
interface Invocation<T> {
    T execute(A a) throws Exception;
}
class MercuryClientInvocationTemplate {
    private A aObj;
    public MercuryClientInvocationTemplate(A aObj) {
        this.aObj = aObj;
    }
    public < T > T execute(Invocation< T > invocation) {

        try {
           return invocation.execute(aObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

////////////////////////////////////////////////

class B {

    private MercuryClientInvocationTemplate mercuryClientInvocationTemplate;

    public B(MercuryClientInvocationTemplate mercuryClientInvocationTemplate) {
        this.mercuryClientInvocationTemplate = mercuryClientInvocationTemplate;
    }

    public int getNode(String entityId) {
        return mercuryClientInvocationTemplate.execute(aObj -> {
            return aObj.getNode(entityId);
        });
    }

    public void setNode(int node) {
        mercuryClientInvocationTemplate.execute(aObj -> {
            aObj.setNode(node);
            return null;
        });
    }
}

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        MercuryClientInvocationTemplate mercuryClientInvocationTemplate = new MercuryClientInvocationTemplate(a);
        B b = new B(mercuryClientInvocationTemplate);

        b.setNode(10);
        System.out.println(b.getNode("abc"));
    }
}



