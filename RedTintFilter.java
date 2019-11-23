import java.awt.Color;
/**
 * This filter will apply a red tint to the image by changing the red value of every pixel to 255 
 * so it will look like the same image with a red film over it.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class RedTintFilter extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public RedTintFilter(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will apply the red tint to a image that is given as a parmater
     * the tint is applied pixel by pixel in a loop.
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
                image.setPixel(x, y, new Color (255, pix.getGreen(), pix.getBlue()));
            }
        }
    }


}
