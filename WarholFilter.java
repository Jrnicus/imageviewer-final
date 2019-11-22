import java.awt.Color;
import javax.swing.*;
/**
 * Write a description of class RedChannel here.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class WarholFilter extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    private ImagePanel imagePanel;
    private JFrame frame;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public WarholFilter(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    public void apply(OFImage image)
    {
        OFImage original = new OFImage(image);
        width = original.getWidth() / 2;
        height = original.getHeight() / 2;
        
        OFImage newImage = new OFImage(width, height);

        // copy pixel data into new image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {

                image.setPixel(x, y, original.getPixel(x * 2, y * 2));
                image.setPixel(x+width, y, original.getPixel(x * 2, y * 2));
                image.setPixel(x, y+height, original.getPixel(x * 2, y * 2));
                image.setPixel(x+width, y+height, original.getPixel(x * 2, y * 2));
                
                Color pix = image.getPixel(x, y);
                
                image.setPixel(x+width, y, new Color (pix.getRed(), 0, 0));
                image.setPixel(x, y+height, new Color (0, pix.getGreen(), 0));
                image.setPixel(x+width, y+height, new Color (0, 0, pix.getBlue()));
                }
        }
    }


}
