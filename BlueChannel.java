import java.awt.Color;
/**
 * This will display the Blue Channel in grey scale by setting the red and green values for each pixel 
 * equal to the value of the blue at each pixel.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class BlueChannel extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public BlueChannel(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will display the blue channel of a image that is given as a parmater in grey scale
     * each pixels color is chnaged 1 by 1 in a loop.
     * @param OFImage image
     */
    public void apply(OFImage image)
    {
        original = new OFImage(image);
        width = original.getWidth();
        height = original.getHeight();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                image.setPixel(x, y, new Color (pix.getBlue(), pix.getBlue(), pix.getBlue()));
            }
        }
    }


}
