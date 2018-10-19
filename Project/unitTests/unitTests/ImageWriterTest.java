package unitTests;


import Renderer.ImageWriter;
import org.junit.Test;

import java.util.Random;

public class ImageWriterTest {
    @Test
    public void writeToimage() {
        ImageWriter imageWriter = new ImageWriter("Image writer test", 500, 500, 1, 1);


        for (int i = 0; i < imageWriter.getHeight(); i++) {
            for(int j=0;j<imageWriter.getWidth();j++){
                if(i%50==0||j%50==0)
                    imageWriter.writePixel(j,i,255,255,255);
            }
        }

        imageWriter.writeToimage();


    }

}
