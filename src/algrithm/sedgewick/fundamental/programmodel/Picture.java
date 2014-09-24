/*************************************************************************
 *  Compilation:  javac Picture.java
 *  Execution:    java Picture imagename
 *
 *  Data type for manipulating individual pixels of an image. The original
 *  image can be read from a file in jpg, gif, or png format, or the
 *  user can create a blank image of a given size. Includes methods for
 *  displaying the image in a window on the screen or saving to a file.
 *
 *  % java Picture mandrill.jpg
 *
 *  Remarks
 *  -------
 *   - pixel (x, y) is column x and row y, where (0, 0) is upper left
 *
 *   - see also GrayPicture.java for a grayscale version
 *
 *************************************************************************/
package algrithm.sedgewick.fundamental.programmodel;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


/**
 *  This class provides methods for manipulating individual pixels of
 *  an image. The original image can be read from a <tt>.jpg</tt>, <tt>.gif</tt>,
 *  or <tt>.png</tt> file or the user can create a blank image of a given size.
 *  This class includes methods for displaying the image in a window on
 *  the screen or saving it to a file.
 *  <p>
 *  Pixel (<em>x</em>, <em>y</em>) is column <em>x</em> and row <em>y</em>.
 *  By default, the origin (0, 0) is upper left, which is a common convention
 *  in image processing.
 *  The method <tt>setOriginLowerLeft()</tt> change the origin to the lower left.
 *  <p>
 *  For additional documentation, see
 *  <a href="http://introcs.cs.princeton.edu/31datatype">Section 3.1</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i>
 *  by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public final class Picture implements ActionListener {
    private BufferedImage image;               // the rasterized image
    private JFrame frame;                      // on-screen view
    private String filename;                   // name of file
    private boolean isOriginUpperLeft = true;  // location of origin
    private final int width, height;           // width and height

   /**
     * Initializes a blank <tt>w</tt>-by-<tt>h</tt> picture, where each pixel is black.
     */
    public Picture(int w, int h) {
        if (w < 0) throw new IllegalArgumentException("width must be nonnegative");
        if (h < 0) throw new IllegalArgumentException("height must be nonnegative");
        width = w;
        height = h;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // set to TYPE_INT_ARGB to support transparency
        filename = w + "-by-" + h;
    }

   /**
     * Initializes a new picture that is a deep copy of <tt>pic</tt>.
     */
    public Picture(Picture pic) {
        width = pic.width();
        height = pic.height();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        filename = pic.filename;
        for (int x = 0; x < width(); x++)
            for (int y = 0; y < height(); y++)
                image.setRGB(x, y, pic.get(x, y).getRGB());
    }

   /**
     * Initializes a picture by reading in a .png, .gif, or .jpg from
     * the given filename or URL name.
     */
    public Picture(String filename) {
        this.filename = filename;
        try {
            // try to read from file in working directory
            File file = new File(filename);
            if (file.isFile()) {
                image = ImageIO.read(file);
            }

            // now try to read from file in same directory as this .class file
            else {
                URL url = getClass().getResource(filename);
                if (url == null) { url = new URL(filename); }
                image = ImageIO.read(url);
            }
            width  = image.getWidth(null);
            height = image.getHeight(null);
        }
        catch (IOException e) {
            // e.printStackTrace();
            throw new RuntimeException("Could not open file: " + filename);
        }
    }

   /**
     * Initializes a picture by reading in a .png, .gif, or .jpg from a File.
     */
    public Picture(File file) {
        try { image = ImageIO.read(file); }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not open file: " + file);
        }
        if (image == null) {
            throw new RuntimeException("Invalid image file: " + file);
        }
        width  = image.getWidth(null);
        height = image.getHeight(null);
        filename = file.getName();
    }

   /**
     * Returns a JLabel containing this picture, for embedding in a JPanel,
     * JFrame or other GUI widget.
     */
    public JLabel getJLabel() {
        if (image == null) { return null; }         // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }

   /**
     * Sets the origin to be the upper left pixel.
     */
    public void setOriginUpperLeft() {
        isOriginUpperLeft = true;
    }

   /**
     * Sets the origin to be the lower left pixel.
     */
    public void setOriginLowerLeft() {
        isOriginUpperLeft = false;
    }

   /**
     * Displays the picture in a window on the screen.
     */
    public void show() {

        // create the GUI for viewing the image if needed
        if (frame == null) {
            frame = new JFrame();

            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");
            menuBar.add(menu);
            JMenuItem menuItem1 = new JMenuItem(" Save...   ");
            menuItem1.addActionListener(this);
            menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                                     Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            menu.add(menuItem1);
            frame.setJMenuBar(menuBar);



            frame.setContentPane(getJLabel());
            // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle(filename);
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }

        // draw
        frame.repaint();
    }

   /**
     * Returns the height of the picture (in pixels).
     */
    public int height() {
        return height;
    }

   /**
     * Returns the width of the picture (in pixels).
     */
    public int width() {
        return width;
    }

   /**
     * Returns the color of pixel (<em>x</em>, <em>y</em>).
     */
    public Color get(int x, int y) {
        if (x < 0 || x >= width())  throw new IndexOutOfBoundsException("x must be between 0 and " + (width()-1));
        if (y < 0 || y >= height()) throw new IndexOutOfBoundsException("y must be between 0 and " + (height()-1));
        if (isOriginUpperLeft) return new Color(image.getRGB(x, y));
        else                   return new Color(image.getRGB(x, height - y - 1));
    }

   /**
     * Sets the color of pixel (<em>x</em>, <em>y</em>) to given color.
     */
    public void set(int x, int y, Color color) {
        if (x < 0 || x >= width())  throw new IndexOutOfBoundsException("x must be between 0 and " + (width()-1));
        if (y < 0 || y >= height()) throw new IndexOutOfBoundsException("y must be between 0 and " + (height()-1));
        if (color == null) throw new NullPointerException("can't set Color to null");
        if (isOriginUpperLeft) image.setRGB(x, y, color.getRGB());
        else                   image.setRGB(x, height - y - 1, color.getRGB());
    }

   /**
     * Is this Picture equal to obj?
     */
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Picture that = (Picture) obj;
        if (this.width()  != that.width())  return false;
        if (this.height() != that.height()) return false;
        for (int x = 0; x < width(); x++)
            for (int y = 0; y < height(); y++)
                if (!this.get(x, y).equals(that.get(x, y))) return false;
        return true;
    }


   /**
     * Saves the picture to a file in a standard image format.
     * The filetype must be .png or .jpg.
     */
    public void save(String name) {
        save(new File(name));
    }

   /**
     * Saves the picture to a file in a standard image format.
     */
    public void save(File file) {
        this.filename = file.getName();
        if (frame != null) { frame.setTitle(filename); }
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        if (suffix.equals("jpg") || suffix.equals("png")) {
            try { ImageIO.write(image, suffix, file); }
            catch (IOException e) { e.printStackTrace(); }
        }
        else {
            System.out.println("Error: filename must end in .jpg or .png");
        }
    }

   /**
     * Opens a save dialog box when the user selects "Save As" from the menu.
     */
    public void actionPerformed(ActionEvent e) {
        FileDialog chooser = new FileDialog(frame,
                             "Use a .png or .jpg extension", FileDialog.SAVE);
        chooser.setVisible(true);
        if (chooser.getFile() != null) {
            save(chooser.getDirectory() + File.separator + chooser.getFile());
        }
    }


   /**
     * Tests this <tt>Picture</tt> data type. Reads a picture specified by the command-line argument,
     * and shows it in a window on the screen.
     */
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        System.out.printf("%d-by-%d\n", pic.width(), pic.height());
        pic.show();
    }

}

