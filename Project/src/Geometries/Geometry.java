package Geometries;

import Primitives.Ray;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;

import java.awt.Color;
import java.util.List;


public abstract class Geometry implements IGeometry {
    //******************* Attributes ******************//
    private Material _material = new Material();
    private double _nShininess = 1;
    private Color _emmission = new Color(0, 0, 0);

    // ***************** Getters/Setters ********************** //
    public double getShininess(){return this._nShininess;}
    public Material getMaterial(){return this._material;}
    public Color getEmmission(){return this._emmission;}
    public void setShininess(double n){this._nShininess=n;}
    public void setMaterial(Material _material){this._material=_material;}
    public void setEmmission(Color emmission){this._emmission=emmission;}
    public void setKs(double ks){this._material.setKs(ks);}
    public void setKd(double kd){this._material.setKd(kd);}
    public void setKr(double kr){this._material.setKr(kr);}
    public void setKt(double kt){this._material.setKt(kt);}
}
