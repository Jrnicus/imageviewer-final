import java.awt.Color;
/**
 * Write a description of class RedChannel here.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class GreenTint extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public GreenTint(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    public void apply(OFImage image)
    {
        original = new OFImage(image);
        width = original.getWidth();
        height = original.getHeight();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                image.setPixel(x, y, new Color (pix.getRed(), 255, pix.getBlue()));
            }
        }
    }


}
