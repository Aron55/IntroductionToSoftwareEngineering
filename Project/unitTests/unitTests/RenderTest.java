package unitTests;

import Elements.Light;
import Elements.SpotLight;
import Geometries.Plane;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import javafx.scene.SceneAntialiasing;
import org.junit.Test;
import Scene.*;

import java.awt.*;


public class RenderTest {

    @Test
    public void basicRender() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);

        Sphere sphere = new Sphere(50, new Point3D(0.0, 0.0, -50));

        Triangle triangle = new Triangle(new Point3D(100, 0, -50), new Point3D(0, 100, -50), new Point3D(100, 100, -50));

        Triangle triangle2 = new Triangle(new Point3D(100, 0, -50), new Point3D(0, -100, -50), new Point3D(100, -100, -50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -50), new Point3D(0, 100, -50), new Point3D(-100, 100, -50));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -50), new Point3D(0, -100, -50), new Point3D(-100, -100, -50));

        //triangle.setEmmission(new Color(255, 255, 255));
        triangle2.setEmmission(new Color(255, 0, 0));
        triangle3.setEmmission(new Color(0, 255, 0));
        triangle4.setEmmission(new Color(103, 129, 255));
        //sphere.setEmmission(new Color(199, 49, 255));

        scene.addGeometry(sphere);
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        //scene.addLight(new SpotLight(new Color(255, 199, 135),new Point3D(100,100,-100),new Vector(-2,-2,-3),0,0.000001,0.00001));
        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();

    }

    @Test
    public void lightRender(){
        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setEmmission(new Color(66, 33, 131));
        sphere.setShininess(30);
        sphere.setKt(0);
        scene.addGeometry(sphere);

        Point3D p1 = new Point3D(0, 0, 0);
        Point3D p2 = new Point3D(-100, -100, 200);
        Vector v1= new Vector(p2,p1);

        scene.addLight(new SpotLight(new Color(214, 83, 204), new Point3D(-200, -200, -500),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Render light test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void recursiveTest() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(250, new Point3D(0.0, 0.0, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }



}
