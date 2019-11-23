import java.awt.Color;
/**
 * This is a blue tint filter it will apply a blue tint to a image by changeing the blue values of every pixel to 255
 * The image will still look the same just appear as if it has a blue film over it.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class BlueTintFilter extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public BlueTintFilter(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will apply the blue tint to a image that is given as a parmater
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
                image.setPixel(x, y, new Color (pix.getRed(), pix.getGreen(), 255));
            }
        }
    }


}
