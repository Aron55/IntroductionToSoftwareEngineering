package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;

public interface IGeometry {
    // ***************** Operation ********************** //
    List<Point3D> FindIntersections(Ray ray);

    Vector getNormal(Point3D point);

}
