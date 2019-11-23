import java.awt.Color;
/**
 * This will display the Green Channel in grey scale by setting the red and blue values for each pixel 
 * equal to the value of the green at each pixel.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class GreenChannel extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public GreenChannel(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will display the green channel of a image that is given as a parmater in grey scale
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
                image.setPixel(x, y, new Color (pix.getGreen(), pix.getGreen(), pix.getGreen()));
            }
        }
    }


}
