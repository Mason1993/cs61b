/* PixImage.java */

/**
 *  The PixImage class represents an image, which is a rectangular grid of
 *  color pixels.  Each pixel has red, green, and blue intensities in the range
 *  0...255.  Descriptions of the methods you must implement appear below.
 *  They include a constructor of the form
 *
 *      public PixImage(int width, int height);
 *
 *  that creates a black (zero intensity) image of the specified width and
 *  height.  Pixels are numbered in the range (0...width - 1, 0...height - 1).
 *
 *  All methods in this class must be implemented to complete Part I.
 *  See the README file accompanying this project for additional details.
 */

public class PixImage {

  /**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */
  private final int imageWidth;
  private final int imageHeight;
  private int [][][] pixelimage;


  /**
   * PixImage() constructs an empty PixImage with a specified width and height.
   * Every pixel has red, green, and blue intensities of zero (solid black).
   *
   * @param width the width of the image.
   * @param height the height of the image.
   */
  public PixImage(int width, int height) {   // it's a constructor, not method. Usage: PixImage currImage = new PixImage(a, b);
    // Your solution here.
    imageWidth = width;
    imageHeight = height;
    pixelimage = new int [width] [height] [3];
  }

  /**
   * getWidth() returns the width of the image.
   *
   * @return the width of the image.
   */
  public int getWidth() {
    // Replace the following line with your solution.
    return this.imageWidth;
  }

  /**
   * getHeight() returns the height of the image.
   *
   * @return the height of the image.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return this.imageHeight;
  }

  /**
   * getRed() returns the red intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the red intensity of the pixel at coordinate (x, y).
   */

  public short getRed(int x, int y) {
    // Replace the following line with your solution.
    return (short) this.pixelimage[x][y][0];
  }

  /**
   * getGreen() returns the green intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the green intensity of the pixel at coordinate (x, y).
   */
  public short getGreen(int x, int y) {
    // Replace the following line with your solution.
    return (short) this.pixelimage[x][y][1];
  }

  /**
   * getBlue() returns the blue intensity of the pixel at coordinate (x, y).
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @return the blue intensity of the pixel at coordinate (x, y).
   */
  public short getBlue(int x, int y) {
    // Replace the following line with your solution.
    return (short) this.pixelimage[x][y][2];
  }

  /**
   * setPixel() sets the pixel at coordinate (x, y) to specified red, green,
   * and blue intensities.
   *
   * If any of the three color intensities is NOT in the range 0...255, then
   * this method does NOT change any of the pixel intensities.
   *
   * @param x the x-coordinate of the pixel.
   * @param y the y-coordinate of the pixel.
   * @param red the new red intensity for the pixel at coordinate (x, y).
   * @param green the new green intensity for the pixel at coordinate (x, y).
   * @param blue the new blue intensity for the pixel at coordinate (x, y).
   */
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
    if ((x >= 0 && x <= imageWidth) && (y >= 0 && y <= imageHeight)) {
	  if ((red >= 0 && red <= 255) && (green >= 0 && green <= 255) && (blue >= 0 && blue <= 255)) {
      this.pixelimage[x][y][0] = red;
      this.pixelimage[x][y][1] = green;
      this.pixelimage[x][y][2] = blue;
    } else {
    	System.out.println("invalid RGB values. Values should be within [0,255]");
    	System.exit(0);
    }
    } else {
    	System.out.println("x or y value exceeds image boundary");
    	System.exit(0);
    }
  }

  /**
   * toString() returns a String representation of this PixImage.
   *
   * This method isn't required, but it should be very useful to you when
   * you're debugging your code.  It's up to you how you represent a PixImage
   * as a String.
   *
   * @return a String representation of this PixImage.
   */
  public String toString() {
    // Replace the following line with your solution.
    // display pixel(x,y) in this image in the format |intesity of red, intensity of green, intensity of blue|
    String str = new String();
    // looping through  j-th row i-th column
    for (int j = 0; j <= this.imageHeight - 1; j++) { 
      for (int i =0; i <= this.imageWidth - 1; i++) { 
        str += "|";
        str += String.valueOf(this.getRed(i,j)) + "," + String.valueOf(this.getGreen(i,j)) + "," + String.valueOf(this.getBlue(i,j));
      }
      str += "|\n";      
    } 
    return str;
  }

  /**
   * boxBlur() returns a blurred version of "this" PixImage.
   *
   * If numIterations == 1, each pixel in the output PixImage is assigned
   * a value equal to the average of its neighboring pixels in "this" PixImage,
   * INCLUDING the pixel itself.
   *
   * A pixel not on the image boundary has nine neighbors--the pixel itself and
   * the eight pixels surrounding it.  A pixel on the boundary has six
   * neighbors if it is not a corner pixel; only four neighbors if it is
   * a corner pixel.  The average of the neighbors is the sum of all the
   * neighbor pixel values (including the pixel itself) divided by the number
   * of neighbors, with non-integer quotients rounded toward zero (as Java does
   * naturally when you divide two integers).
   *
   * Each color (red, green, blue) is blurred separately.  The red input should
   * have NO effect on the green or blue outputs, etc.
   *
   * The parameter numIterations specifies a number of repeated iterations of
   * box blurring to perform.  If numIterations is zero or negative, "this"
   * PixImage is returned (not a copy).  If numIterations is positive, the
   * return value is a newly constructed PixImage.
   *
   * IMPORTANT:  DO NOT CHANGE "this" PixImage!!!  All blurring/changes should
   * appear in the new, output PixImage only.
   *
   * @param numIterations the number of iterations of box blurring.
   * @return a blurred version of "this" PixImage.
   */
  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
	   if (numIterations <= 0) {
		      return this;
	   } else {
		   PixImage currentImage = new PixImage(imageWidth, imageHeight); 
       PixImage blurImage = null;    // the key 1 of iterato, declare it first 
       currentImage = this;
		   for (int count = 0; count < numIterations; count++) {
         blurImage = new PixImage(imageWidth, imageHeight);  // the key 2 of iterator, need to initialize it every time
			   for (int x = 0; x <= this.imageWidth-1; x++) {
				   for (int y = 0; y <= this.imageHeight-1; y++) {
					   int position = posPixel(x, y);
             //System.out.println(position);
					   switch (position) {
					   case 1: 
						  blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x+1][y][0] + currentImage.pixelimage[x][y+1][0] + currentImage.pixelimage[x+1][y+1][0])/4;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x+1][y][1] + currentImage.pixelimage[x][y+1][1] + currentImage.pixelimage[x+1][y+1][1])/4;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x+1][y][2] + currentImage.pixelimage[x][y+1][2] + currentImage.pixelimage[x+1][y+1][2])/4;
               break;
              case 2:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y][0] + currentImage.pixelimage[x+1][y][0] + currentImage.pixelimage[x-1][y+1][0] + currentImage.pixelimage[x][y+1][0] + currentImage.pixelimage[x+1][y+1][0])/6;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y][1] + currentImage.pixelimage[x+1][y][1] + currentImage.pixelimage[x-1][y+1][1] + currentImage.pixelimage[x][y+1][1] + currentImage.pixelimage[x+1][y+1][1])/6;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y][2] + currentImage.pixelimage[x+1][y][2] + currentImage.pixelimage[x-1][y+1][2] + currentImage.pixelimage[x][y+1][2] + currentImage.pixelimage[x+1][y+1][2])/6;
              break;
              case 3:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y][0] + currentImage.pixelimage[x-1][y+1][0] + currentImage.pixelimage[x][y+1][0])/4;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y][1] + currentImage.pixelimage[x-1][y+1][1] + currentImage.pixelimage[x][y+1][1])/4;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y][2] + currentImage.pixelimage[x-1][y+1][2] + currentImage.pixelimage[x][y+1][2])/4;
              break;
              case 4:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x+1][y-1][0] + currentImage.pixelimage[x+1][y][0] + currentImage.pixelimage[x][y+1][0] + currentImage.pixelimage[x+1][y+1][0])/6;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x+1][y-1][1] + currentImage.pixelimage[x+1][y][1] + currentImage.pixelimage[x][y+1][1] + currentImage.pixelimage[x+1][y+1][1])/6;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x+1][y-1][2] + currentImage.pixelimage[x+1][y][2] + currentImage.pixelimage[x][y+1][2] + currentImage.pixelimage[x+1][y+1][2])/6;
              break;
              case 5:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y-1][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x+1][y-1][0] + currentImage.pixelimage[x-1][y][0] + currentImage.pixelimage[x+1][y][0] + currentImage.pixelimage[x-1][y+1][0] + currentImage.pixelimage[x][y+1][0] + currentImage.pixelimage[x+1][y+1][0])/9;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y-1][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x+1][y-1][1] + currentImage.pixelimage[x-1][y][1] + currentImage.pixelimage[x+1][y][1] + currentImage.pixelimage[x-1][y+1][1] + currentImage.pixelimage[x][y+1][1] + currentImage.pixelimage[x+1][y+1][1])/9;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y-1][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x+1][y-1][2] + currentImage.pixelimage[x-1][y][2] + currentImage.pixelimage[x+1][y][2] + currentImage.pixelimage[x-1][y+1][2] + currentImage.pixelimage[x][y+1][2] + currentImage.pixelimage[x+1][y+1][2])/9;
              break;
              case 6:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y-1][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x-1][y][0] + currentImage.pixelimage[x-1][y+1][0] + currentImage.pixelimage[x][y+1][0] )/6;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y-1][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x-1][y][1] + currentImage.pixelimage[x-1][y+1][1] + currentImage.pixelimage[x][y+1][1] )/6;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y-1][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x-1][y][2] + currentImage.pixelimage[x-1][y+1][2] + currentImage.pixelimage[x][y+1][2] )/6;
              break;
              case 7:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x+1][y-1][0] + currentImage.pixelimage[x+1][y][0])/4;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x+1][y-1][1] + currentImage.pixelimage[x+1][y][1])/4;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x+1][y-1][2] + currentImage.pixelimage[x+1][y][2])/4;
              break;
              case 8:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y-1][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x+1][y-1][0] + currentImage.pixelimage[x-1][y][0] + currentImage.pixelimage[x+1][y][0])/6;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y-1][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x+1][y-1][1] + currentImage.pixelimage[x-1][y][1] + currentImage.pixelimage[x+1][y][1])/6;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y-1][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x+1][y-1][2] + currentImage.pixelimage[x-1][y][2] + currentImage.pixelimage[x+1][y][2])/6;
              break;
              case 9:
              blurImage.pixelimage[x][y][0] = (currentImage.pixelimage[x][y][0] + currentImage.pixelimage[x-1][y-1][0] + currentImage.pixelimage[x][y-1][0] + currentImage.pixelimage[x-1][y][0])/4;
              blurImage.pixelimage[x][y][1] = (currentImage.pixelimage[x][y][1] + currentImage.pixelimage[x-1][y-1][1] + currentImage.pixelimage[x][y-1][1] + currentImage.pixelimage[x-1][y][1])/4;
              blurImage.pixelimage[x][y][2] = (currentImage.pixelimage[x][y][2] + currentImage.pixelimage[x-1][y-1][2] + currentImage.pixelimage[x][y-1][2] + currentImage.pixelimage[x-1][y][2])/4;
              break;
              default:
              System.out.println("invalid position of pixel. position should be within [1,9]");
              System.exit(0);              
					   }
				   }
			   }
        currentImage = blurImage;
        // System.out.println("current Image is: " + currentImage);
        // System.out.println("blurred Image is: " + blurImage);
		   }
       return blurImage;
	   }  
  }

  public int posPixel(int x, int y) {
    // 1 to 9, starting from upper left corner to bottom right corner, zigzag moving
    // |1|...|2|...|3|
    // |4|...|5|...|6|
    // |7|...|8|...|9|
    int posOfNeighbor = 0;
    if ((x >= 0 && x <= imageWidth) && (y >= 0 && y <= imageHeight)) {
    	if (x == 0 && y == 0) {
    		posOfNeighbor = 1;
    	}
    	if ((x > 0 && x < imageWidth-1) && y == 0) {
    		posOfNeighbor = 2;
    	}
    	if (x == imageWidth-1 && y == 0) {
    		posOfNeighbor =3;
    	}
    	if (x == 0 && (y > 0 && y < imageHeight-1)) {
    		posOfNeighbor = 4;
    	}
    	if ((x > 0 && x < imageWidth-1) && (y > 0 && y < imageHeight-1)) {
    		posOfNeighbor = 5;
    	}
    	if (x == imageWidth-1 && (y > 0 && y < imageHeight-1)) {
    		posOfNeighbor = 6;
    	}
    	if (x == 0 && y == imageHeight-1) {
    		posOfNeighbor = 7;
    	}
    	if ((x > 0 && x < imageWidth-1) && (y == imageHeight-1)) {
    		posOfNeighbor =8;
    	}
    	if (x == imageWidth-1 && y == imageHeight-1) {
    		posOfNeighbor = 9;
    	}

      //System.out.println("x: " + x + "y: " + y);
    } else {
    	System.out.println("x or y value exceeds image boundary");
    	System.exit(0);
    }
    return posOfNeighbor;
  }
 
  /**
   * mag2gray() maps an energy (squared vector magnitude) in the range
   * 0...24,969,600 to a grayscale intensity in the range 0...255.  The map
   * is logarithmic, but shifted so that values of 5,080 and below map to zero.
   *
   * DO NOT CHANGE THIS METHOD.  If you do, you will not be able to get the
   * correct images and pass the autograder.
   *
   * @param mag the energy (squared vector magnitude) of the pixel whose
   * intensity we want to compute.
   * @return the intensity of the output pixel.
   */
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

  /**
   * sobelEdges() applies the Sobel operator, identifying edges in "this"
   * image.  The Sobel operator computes a magnitude that represents how
   * strong the edge is.  We compute separate gradients for the red, blue, and
   * green components at each pixel, then sum the squares of the three
   * gradients at each pixel.  We convert the squared magnitude at each pixel
   * into a grayscale pixel intensity in the range 0...255 with the logarithmic
   * mapping encoded in mag2gray().  The output is a grayscale PixImage whose
   * pixel intensities reflect the strength of the edges.
   *
   * See http://en.wikipedia.org/wiki/Sobel_operator#Formulation for details.
   *
   * @return a grayscale PixImage representing the edges of the input image.
   * Whiter pixels represent stronger edges.
   */
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
    int [][] matrixX = {
      {1, 0 ,-1},
      {2, 0, -2},
      {1, 0, -1}
    };
    int [][] matrixY = {
      {1, 2, 1},
      {0, 0, 0},
      {-1, -2, -1}
    };
    PixImage sobelImage = new PixImage(this.imageWidth, this.imageHeight);
    for (int x = 0; x <= this.imageWidth-1; x++) {
      for (int y = 0; y <= this.imageHeight-1; y++) {
        long energy = 0;
        for (int color = 0; color <=2;  color++) {
          long gx = 0;
          long gy = 0;
          
          gx = this.pixelimage[reflectX(x+1)][reflectY(y-1)][color] + 2*this.pixelimage[reflectX(x+1)][reflectY(y)][color] + this.pixelimage[reflectX(x+1)][reflectY(y+1)][color] - this.pixelimage[reflectX(x-1)][reflectY(y-1)][color] - 2*this.pixelimage[reflectX(x-1)][reflectY(y)][color] - this.pixelimage[reflectX(x-1)][reflectY(y+1)][color];   
          gy = this.pixelimage[reflectX(x-1)][reflectY(y+1)][color] + 2*this.pixelimage[reflectX(x)][reflectY(y+1)][color] + this.pixelimage[reflectX(x+1)][reflectY(y+1)][color] - this.pixelimage[reflectX(x-1)][reflectY(y-1)][color] - 2*this.pixelimage[reflectX(x)][reflectY(y-1)][color] - this.pixelimage[reflectX(x+1)][reflectY(y-1)][color]; 
          energy += gx * gx + gy * gy;  
          
          /*
          for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {  // in this program, x indicates x-th column, y indicates y-th column;
              gx += matrixX[i+1][j+1] * this.pixelimage[reflectX(x-j)][reflectY(y+i)][color];
              //System.out.println("multi: " + matrixX[i+1][j+1] * this.pixelimage[reflectY(y+j)][reflectX(x-i)][color]);
              gy += matrixY[i+1][j+1] * this.pixelimage[reflectX(x+j)][reflectY(y-i)][color];
              energy += gx * gx + gy * gy;
            }
          }
          */
          }
          short intesity = mag2gray(energy);
          sobelImage.setPixel(x, y, intesity, intesity, intesity);
        }
      }
      //System.out.println("sobelImage is\n" + sobelImage);
    return sobelImage;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  }

  public int reflectX (int x) {  
    if (x == -1) {
      x++;
    } else if (x == this.imageWidth) {
      x--;
    } else if (x >= 0 && x <= this.imageWidth-1) {
      x = x; // not on the boundary, x remain same;
    } else {
      System.out.println("invalid coordinate of x for pixel(x,y). coordinate should be within [0,imageWidth-1]");
      System.exit(0); 
    }
    return x;
  }

  public int reflectY (int y) {
    if (y == -1) {
      y++;
    } else if (y == this.imageHeight) {
      y--;
    } else if (y >= 0 && y <= this.imageHeight-1) {
      y = y; // not on the boundary, y remain same;
    } else {
      System.out.println("invalid coordinate y for pixel(x,y). coordinate y should be within [0,imageHeight-1]");
      System.exit(0); 
    }
    return y;
  }

  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  /**
   * equals() checks whether two images are the same, i.e. have the same
   * dimensions and pixels.
   *
   * @param image a PixImage to compare with "this" PixImage.
   * @return true if the specified PixImage is identical to "this" PixImage.
   */
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * main() runs a series of tests to ensure that the convolutions (box blur
   * and Sobel) are correct.
   */
  public static void main(String[] args) {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.

    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2);
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals( 
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  
  }
}
