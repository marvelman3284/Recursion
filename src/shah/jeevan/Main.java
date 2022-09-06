package shah.jeevan;

public class Main {

    public static Turtle t = new Turtle();

    public static void main(String[] args) {
        t.speed(100);
        t.setPosition(0, 0);
        tiltTriangle(100, 120, 0, 360);
//        serpinski(-100, -100, 0, 100, 100, -100, 5);
//        triangle(0, 0, 50, 100, 100, 0);
//        System.out.println("Hello World!");
//        recursiveHexagon(50, 0, 0, 2);
//        recursiveSquare(300, 0, 0, 3);
    }

    public static void recursiveSquare(double size, double x, double y, int iters) {
       if (iters == 0) {
           return;
       }
       square(size, x, y);

       // left
       recursiveSquare(size/2, x-size/2, y+size/2, iters-1);

       // right
       recursiveSquare(size/2, x+size/2, y+size/2, iters-1);

       // bottom left
       recursiveSquare(size/2, x-size/2, y-size/2, iters-1);

       // bottom right
       recursiveSquare(size/2, x+size/2, y-size/2, iters-1);
    }

    public static void tiltTriangle(double size, double angle, float tiltAngle, int iters) {
        if (iters < 0) {
            return;
        }

        t.right(tiltAngle);
        for (int i=0; i<3; i++) {
            t.forward(size);
            t.right(angle);
        }
        tiltTriangle(size, angle, tiltAngle+1, iters-1);
        System.out.println(tiltAngle);
    }

    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        t.up();
        t.setPosition(x1, y1);
        t.down();
        t.setPosition(x2, y2);
        t.setPosition(x3, y3);
        t.setPosition(x1, y1);
    }

    public static void serpinski(int x1, int y1, int x2, int y2, int x3, int y3, int iter) {
        if (iter > 0) {
            triangle(x1, y1, x2, y2, x3, y3);
            serpinski((x1+x2)/2, (y1+y2)/2, x2, y2, (x2+x3)/2, (y2+y3)/2, iter-1);
            serpinski(x1, y1, (x1+x2)/2, (y1+y2)/2, (x1+x3)/2, (y1+y3)/2, iter-1);
            serpinski((x1+x3)/2, (y1+y3)/2, (x2+x3)/2, (y2+y3)/2, x3, y3, iter-1);
        }
    }

    public static void square(double size, double x, double y) {
        t.up();
        t.setPosition(x, y);
        t.setDirection(0);
        t.forward(-1*size/2);
        t.left(90);
        t.forward(size/2);
        t.right(90);
        t.down();
        for(int i=0;i<4;i++) {
            t.forward(size);
            t.right(90);
        }
    }

    public static void hexagon(double size, double x, double y) {
        t.up();
        t.setPosition(x, y);
        t.setDirection(0);
        t.forward(-1*size/2);
        t.left(90);
        t.forward(size/2);
        t.right(90);
        t.down();
        for (int i=0; i<6; i++) {
            t.forward(size);
            t.right(60);
        }
    }

    public static void recursiveHexagon(double size, double x, double y, int iters) {
        if (iters == 0) {
            return;
        }
        hexagon(size, x, y);

        // left
        recursiveHexagon(size/2, x-size/2, y+size/2, iters-1);

        // right
        recursiveHexagon(size/2, x+size/2, y+size/2, iters-1);

        // bottom left
        recursiveHexagon(size/2, x-size/2, y-size/2, iters-1);

        // bottom right
        recursiveHexagon(size/2, x+size/2, y-size/2, iters-1);
    }
}