import java.awt.Color;
/**
 * Write a description of class RedChannel here.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class Warhol extends Filter
{
    private OFImage original;
    private int width;
    private int height;
    
    /**
     * Constructor for objects of class RedChannel
     */
    public Warhol(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    public void apply(OFImage image)
    {
        original = new OFImage(image);
        width = original.getWidth();
        height = original.getHeight();
        
        width = width / 2;
        height = height / 2;
        OFImage newImage = new OFImage(width, height);

        // copy pixel data into new image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                newImage.setPixel(x, y, image.getPixel(x * 2, y * 2));
                }
        }
            
        currentImage = newImage;
        imagePanel.setImage(currentImage);
        frame.pack();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                image.setPixel(x, y, new Color (255, pix.getGreen(), pix.getBlue()));
            }
        }
    }


}
