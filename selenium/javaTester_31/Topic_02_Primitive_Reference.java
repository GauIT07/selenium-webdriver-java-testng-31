package javaTester_31;

public class Topic_02_Primitive_Reference {

    int x;

    public static void main(String[] args) {

        int x = 42;
        int y = x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        x = 50;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // Class
        // Instance 1
        Topic_02_Primitive_Reference c = new Topic_02_Primitive_Reference();
        c.x = 42;
        System.out.println("c.x = " + c.x);

        // Instance 2
        Topic_02_Primitive_Reference d = c;
        System.out.println("d.x = " + d.x);

        c.x = 100;

        System.out.println("c.x = " + c.x);
        System.out.println("d.x = " + d.x);


        Topic_02_Primitive_Reference e = new Topic_02_Primitive_Reference();
        System.out.println("e.x = " + e.x);

    }
}
