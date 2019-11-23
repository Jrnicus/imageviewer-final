import java.awt.Color;
/**
 * This filter will make a Andy Warhol like image by make the image a quarter of the orginal size
 * and repeating the quarter size image 4 times in the space of the orginal image size.
 * Ofcurse warhol screen printed his designs and picked the colors in each box which would be hard to copy
 * sense the color choices were his idea and not simply based on a shift in RGB values. 
 * So for simplicity we will make the top left box the orginal color, the top right box the red channel of the orginal image,
 * the bottom left box the green channel of the orginal image, and the bottom right box will be the blue channel of the
 * orginal image.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class WarholFilter extends Filter
{
    private OFImage original;
    private int width; // to hold the width of the smaller images within the full size image
    private int height; // to hold the height of the smaller images within the full size image
    
    /**
     * Constructor for objects of class RedChannel
     */
    public WarholFilter(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will take the orginal image and make 4 smaller copies of the image to will the space of the orginal image.
     * and make it so that each smaller image is a diffrent color.
     * @param OFImage image
     */
    public void apply(OFImage image)
    {
        OFImage original = new OFImage(image);
        width = original.getWidth() / 2;
        height = original.getHeight() / 2;

        // copy pixel data into new image
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                //This will take every other pixel for x and y by doing this it will be half the hight
                // and half the width but keep the same aspect ratio
                image.setPixel(x, y, original.getPixel(x * 2, y * 2));
                
                // get the color of the pixel we just drew
                Color pix = image.getPixel(x, y);
                
                //Use the pixel we just drew and copy it in another box with a diffrent color
                // to build the other 3 images
                image.setPixel(x+width, y, new Color (pix.getRed(), 0, 0));
                image.setPixel(x, y+height, new Color (0, pix.getGreen(), 0));
                image.setPixel(x+width, y+height, new Color (0, 0, pix.getBlue()));
                }
        }
    }


}
