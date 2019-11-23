import java.awt.Color;
/**
 * This filter will make a Andy Warhol like image by make the image a quarter of the orginal size
 * and repeating the quarter size image 4 times in the space of the orginal image size.
 * Ofcurse warhol screen printed his designs and picked the colors in each box which would be hard to copy
 * sense the color choices were his idea and not simply based on a shift in RGB values. 
 * So for simplicity we will make the top left box the orginal color, the top right box the red channel of the orginal image,
 * the bottom left box the green channel of the orginal image, and the bottom right box will be the blue channel of the
 * orginal image.
 * This filter will also have a twist to it each smaller image (box) will flow into the next one by flipping the two
 * right side boxes horizontally and flipping the two bottom boxes veritcally.
 *
 * @author Steve Cate
 * @version 11/18/19
 */
public class FlippedWarholFilter extends Filter
{
    private OFImage original;
    private int width; // used to hold the width of the smaller images that will be inside the full image
    private int height; // used to hold the height of the smaller images that will be inside the full image
    
    /**
     * Constructor for objects of class RedChannel
     */
    public FlippedWarholFilter(String name)
    {
        // initialise instance variables
        super(name);
    }
    
    /**
     * This will apply the filter to the image makeing 4 images that flow into each other with diffrent colors
     * for each smaller image.
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
                // draw the first pixel for each image 
                image.setPixel(x, y, original.getPixel(x * 2, y * 2));
                image.setPixel(x+width, y, original.getPixel((width - 1 - x) * 2, y * 2));
                image.setPixel(x, y+height, original.getPixel(x * 2, (height - 1 - y) * 2));
                image.setPixel(x+width, y+height, original.getPixel((width - 1 - x) * 2, (height - 1 - y) * 2));
                
                // get the color for top right, bottom left, and bottom right boxes
                Color topRightColor = image.getPixel(x+width, y);
                Color bottomLeftColor = image.getPixel(x, y+height);
                Color bottomRightColor = image.getPixel(x+width, y+height);
                // change the color for top right, bottom left, and bottom right boxes
                // The top left box's color does not need to be changed as that will match the orginal
                image.setPixel(x+width, y, new Color (topRightColor.getRed(), 0, 0));
                image.setPixel(x, y+height, new Color (0, bottomLeftColor.getGreen(), 0));
                image.setPixel(x+width, y+height, new Color (0, 0, bottomRightColor.getBlue()));
            }
        }
    }


}
