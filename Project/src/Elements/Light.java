package Elements;

import java.awt.Color;


public abstract class Light {
    protected Color _color;

    // ***************** Constructors ********************** //
    public Light(){this._color=null;}
    public Light (Color color){this._color=color;}

    // ***************** Getters/Setters ********************** //
    public Color getIntensity(){return _color;}
}
