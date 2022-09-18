package shah.jeevan;

public class Main {

    public static double[][] points = new double[7][2];
    public static Turtle t = new Turtle();

    public static void main(String[] args) {
//        t.speed(10);
//        t.setPosition(0, 0);
//        tiltTriangle(100, 120, 0, 30);
//        wait(500);
//        t.clear();
//        serpinski(-100, -100, 0, 100, 100, -100, 5);
//        wait(500);
//        t.clear();
//        recursiveSquare(300, 0, 0, 3);
//        wait(500);
//        t.clear();
//        t.speed(15);
//        t.setDirection(90);
//        t.up();
//        t.setPosition(0, -200);
//        t.down();
//        tree(100);
//        wait(500);
//        t.clear();
//        t.speed(1);
//        recursiveH(0, 0, 150, 4);
//        wait(500);
//        t.clear();
//        recursiveHexagon(100, 0, 0, 5);
        t.speed(0);
        hexa(1000000);
    }

    private static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println("Exception thrown");
        }
    }

    public static void h(double x, double y, double size) {
        t.up();
        t.setPosition(x - size, y + size);
        t.setDirection(-90);
        t.down();
        t.forward(size * 2);
        t.backward(size);
        t.setDirection(0);
        t.forward(size * 2);
        t.right(90);
        t.forward(size);
        t.backward(size * 2);
    }

    public static void triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        t.up();
        t.setPosition(x1, y1);
        t.down();
        t.setPosition(x2, y2);
        t.setPosition(x3, y3);
        t.setPosition(x1, y1);
    }

    public static void recursiveH(double x, double y, double size, double iters) {
        if (iters > 0) {
            h(x, y, size);

            recursiveH(x - size, y + size, size / 2, iters - 1);
            recursiveH(x + size, y + size, size / 2, iters - 1);
            recursiveH(x - size, y - size, size / 2, iters - 1);
            recursiveH(x + size, y - size, size / 2, iters - 1);
        }
    }

    public static void recursiveSquare(double size, double x, double y, int iters) {
        if (iters == 0) {
            return;
        }
        square(size, x, y);

        // left
        recursiveSquare(size / 2, x - size / 2, y + size / 2, iters - 1);

        // right
        recursiveSquare(size / 2, x + size / 2, y + size / 2, iters - 1);

        // bottom left
        recursiveSquare(size / 2, x - size / 2, y - size / 2, iters - 1);

        // bottom right
        recursiveSquare(size / 2, x + size / 2, y - size / 2, iters - 1);
    }

    public static void tiltTriangle(double size, double angle, float tiltAngle, int iters) {
        if (iters < 0) {
            return;
        }

        t.right(tiltAngle);
        for (int i = 0; i < 3; i++) {
            t.forward(size);
            t.right(angle);
        }
        tiltTriangle(size, angle, tiltAngle + 1, iters - 1);
        System.out.println(tiltAngle);
    }

    public static void serpinski(int x1, int y1, int x2, int y2, int x3, int y3, int iter) {
        if (iter > 0) {
            triangle(x1, y1, x2, y2, x3, y3);
            serpinski((x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2, iter - 1);
            serpinski(x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x1 + x3) / 2, (y1 + y3) / 2, iter - 1);
            serpinski((x1 + x3) / 2, (y1 + y3) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3, iter - 1);
        }
    }

    public static void square(double size, double x, double y) {
        t.up();
        t.setPosition(x, y);
        t.setDirection(0);
        t.forward(-1 * size / 2);
        t.left(90);
        t.forward(size / 2);
        t.right(90);
        t.down();
        for (int i = 0; i < 4; i++) {
            t.forward(size);
            t.right(90);
        }
    }


    public static void trigon(double size) {
        for (int i = 0; i < 3; i++) {
            t.forward(size);
            t.right(120);
        }
    }

    public static void hexagon(double size, double x, double y) {
        t.up();
        t.setPosition(x, y);
        t.setDirection(90);
        t.down();
        for (int i = 0; i < 6; i++) {
            trigon(size);
            t.right(60);
        }
    }

    public static void recursiveHexagon(double size, double x, double y, int iters) {
        if (iters > 1) {
            hexagon(size, x, y);

            // top
            recursiveHexagon(size / 2, x, y + size, iters - 1);

            // top right
            recursiveHexagon(size / 2, x + (((Math.pow(3, 0.5)) / 2) * size), y + (0.5 * size), iters - 1);

            // bottom right
            recursiveHexagon(size / 2, x + (((Math.pow(3, 0.5)) / 2) * size), y - (0.5 * size), iters - 1);

            // bottom
            recursiveHexagon(size / 2, x, y - size, iters - 1);

            // bottom left
            recursiveHexagon(size / 2, x - (((Math.pow(3, 0.5)) / 2) * size), y - (0.5 * size), iters - 1);

            // top left
            recursiveHexagon(size / 2, x - (((Math.pow(3, 0.5)) / 2) * size), y + (0.5 * size), iters - 1);
        }
    }

    public static void tree(int length) {
        if (length > 5) {
            t.forward(length);
            t.right(20);
            tree(length - 15);
            t.left(40);
            tree(length - 10);
            t.right(20);
            t.backward(length);
        }
    }

    public static void hexa(int iters) {
        if (iters < 1) {
            return;
        }
        t.up();
        t.setPosition(100, 150);
        for (int i=0; i<6; i++) {
            t.dot();
            points[i][0] = t.getX();
            points[i][1] = t.getY();
            t.right(60);
            t.forward(200);
        }
        points[6][0] = 0;
        points[6][1] = 0;
        for (int i=0; i<iters; i++) {
            int rand = rand(0, 5);
            t.setPosition(points[6][0], points[6][1]);
            double dist = distance(points[6][0], points[6][1], points[rand][0], points[rand][1]);
            t.face(points[rand][0], points[rand][1]);
            t.forward(dist);
            t.dot();
            points[6][0] = t.getX();
            points[6][1] = t.getY();
        }
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return (2.0d/3.0d)*(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public static int rand(int min, int max) {
        int range = max-min+1;
        return (int)(Math.floor((Math.random() * range) + min));
    }
}