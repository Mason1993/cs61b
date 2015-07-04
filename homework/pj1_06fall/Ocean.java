/* Ocean.java */

/**
 *  The Ocean class defines an object that models an ocean full of sharks and
 *  fish.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Ocean(int i, int j, int starveTime);
 *
 *  that creates an empty ocean having width i and height j, in which sharks
 *  starve after starveTime timesteps.
 *
 *  See the README file accompanying this project for additional details.
 */

public class Ocean {

  /**
   *  Do not rename these constants.  WARNING:  if you change the numbers, you
   *  will need to recompile Test4.java.  Failure to do so will give you a very
   *  hard-to-find bug.
   */

  public final static int EMPTY = 0;
  public final static int SHARK = 1;
  public final static int FISH = 2;

  /**
   *  Define any variables associated with an Ocean object here.  These
   *  variables MUST be private.
   */
    private int oceanWidth;
    private int oceanHeight;
    private int starveT;
    private int [][] oceanGrid;
    private int [][] hungerGrid;
  /**
   *  The following methods are required for Part I.
   */

  /**
   *  Ocean() is a constructor that creates an empty ocean having width i and
   *  height j, in which sharks starve after starveTime timesteps.
   *  @param i is the width of the ocean.
   *  @param j is the height of the ocean.
   *  @param starveTime is the number of timesteps sharks survive without food.
   */

  public Ocean(int i, int j, int starveTime) {
    // Your solution here.
    oceanWidth = i;
    oceanHeight = j;
    starveT = starveTime;
    oceanGrid = new int [i][j];
    hungerGrid = new int [i][j];
  }

  /**
   *  width() returns the width of an Ocean object.
   *  @return the width of the ocean.
   */

  public int width() {
    // Replace the following line with your solution.
    return this.oceanWidth;
  }

  /**
   *  height() returns the height of an Ocean object.
   *  @return the height of the ocean.
   */

  public int height() {
    // Replace the following line with your solution.
    return this.oceanHeight;
  }

  public int wrapX(int x) {
    x = x % this.oceanWidth;
    if (x < 0) {
      x = x + this.oceanWidth;
    }
    return x;
  }

    public int wrapY(int y) {
    y = y % this.oceanHeight;
    if (y < 0) {
      y = y + this.oceanHeight;
    }
    return y;
  }

  /**
   *  starveTime() returns the number of timesteps sharks survive without food.
   *  @return the number of timesteps sharks survive without food.
   */

  public int starveTime() {
    // Replace the following line with your solution.
    return this.starveT;
  }

  /**
   *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
   *  cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a fish in.
   *  @param y is the y-coordinate of the cell to place a fish in.
   */

  public void addFish(int x, int y) {
    // Your solution here.
    if (cellContents(x,y) == 0) {
        x = wrapX(x);
        y = wrapY(y);
        oceanGrid[x][y] = 2;
      }
      else {
        System.out.println("this cell is not empty, addFish fail!");
        System.exit(0);
      }
  }

  /**
   *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
   *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
   *  just eaten.  If the cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   */

  public void addShark(int x, int y) {
    // Your solution here.
    if (cellContents(x,y) == 0) {
        x = wrapX(x);
        y = wrapY(y);
        oceanGrid[x][y] = 1;
        hungerGrid[x][y] = this.starveT;
      }
      else {
        System.out.println("this cell is not empty, addShark fail!");
        System.exit(0);
      }

  }

    public void addEmpty(int x, int y) {
    // Your solution here.
    x = wrapX(x);
    y = wrapY(y);
    oceanGrid[x][y] = 0;
  }

  /**
   *  cellContents() returns EMPTY if cell (x, y) is empty, FISH if it contains
   *  a fish, and SHARK if it contains a shark.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int cellContents(int x, int y) {
    // Replace the following line with your solution.
    x = wrapX(x);
    y = wrapY(y);
    return this.oceanGrid[x][y];
  }

  /**
   *  timeStep() performs a simulation timestep as described in README.
   *  @return an ocean representing the elapse of one timestep.
   */

  public int[] neighbor(int x, int y) {
    int [] neighborArea = new int [3];
    x = wrapX(x);
    y = wrapY(y);
    for (int i = x-1; i <= x+1; i++) {
      for (int j = y-1; j <= y+1; j++) {
        switch (cellContents(i,j)) {
          case EMPTY: {
                    neighborArea[0]++;
                    break;
                  }
          case SHARK:{
                    neighborArea[1]++;
                    break;
                  }
          case FISH:{
                    neighborArea[2]++;
                    break;
                  }
          default:{
                    System.out.println("cellContents error, program terminated!");
                    System.exit(0);
                  }
        }
        }
      }
      return neighborArea;
  }

  public Ocean timeStep() {
    // Replace the following line with your solution.
    Ocean newOcean = new Ocean (this.oceanWidth, this.oceanHeight, this.starveT);
    
    
    for (int x = 0; x < this.oceanWidth; x++) {
      for (int y = 0; y < this.oceanHeight; y++) {
        int [] neighborArea = neighbor(x,y);             // initialize neighborArea to store neighbor info
        newOcean.oceanGrid[x][y] = this.oceanGrid[x][y];
        newOcean.hungerGrid[x][y] = this.hungerGrid[x][y];
        switch (cellContents(x,y)) {
          case SHARK: {
            if (this.hungerGrid[x][y] == 0) {
              newOcean.addEmpty(x,y);                             // shark dies because of hunger
            }
            if (neighborArea[2] > 0) {                   // situation 1: fish exists in neighborhood
              for (int i = x-1; i <= x+1; i++) {         // scan the neighborhood of cell(x,y), addEmpty to fish cell
                for (int j = y-1; j <= y+1; j++) {
                  if (cellContents(i,j) == 2) {
                    newOcean.addEmpty(i,j);
                  }
                }
              }
              newOcean.hungerGrid[x][y] = starveT;               // shark fed
            } else {                                    // situation 2: no fish exists in surrounding
              newOcean.hungerGrid[x][y]--;
            }
            break;
          }

          case FISH: {
            if (neighborArea[1] != 0) {
              if (neighborArea[1] > 1) {               // situation 4: multiple sharks surround fish
                newOcean.addEmpty(x,y);
                newOcean.addShark(x,y);
                newOcean.hungerGrid[x][y] = starveT;
              } else {                                 //  situation 5: only a single shark surrounding this fish
                newOcean.addEmpty(x,y);
              }
            }                                          // situation 3: no shrak, nothing happen; it goes outside if
            break;
          }

          case EMPTY: {
            if (neighborArea[2] >= 2) {
              if (neighborArea[1] <= 1) {             // situation 7: multiple fish and none/single shark, born fish
                newOcean.addFish(x,y);
              } else {                                // situation 8: multiple sharks, born shark
                newOcean.addShark(x,y);
                newOcean.hungerGrid[x][y] = starveT;
              }
            }                                         // situation 6: nothing happen. it goes outside if  
            break;
          }
          default: {
            System.out.println("cellContents error, program terminated!");
            System.exit(0);
            break;
          }
        }
      }
    }
    return newOcean;
  }

  /**
   *  The following method is required for Part II.
   */

  /**
   *  addShark() (with three parameters) places a shark in cell (x, y) if the
   *  cell is empty.  The shark's hunger is represented by the third parameter.
   *  If the cell is already occupied, leave the cell as it is.  You will need
   *  this method to help convert run-length encodings to Oceans.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   *  @param feeding is an integer that indicates the shark's hunger.  You may
   *         encode it any way you want; for instance, "feeding" may be the
   *         last timestep the shark was fed, or the amount of time that has
   *         passed since the shark was last fed, or the amount of time left
   *         before the shark will starve.  It's up to you, but be consistent.
   */

  public void addShark(int x, int y, int feeding) {
    // Your solution here.
  }

  /**
   *  The following method is required for Part III.
   */

  /**
   *  sharkFeeding() returns an integer that indicates the hunger of the shark
   *  in cell (x, y), using the same "feeding" representation as the parameter
   *  to addShark() described above.  If cell (x, y) does not contain a shark,
   *  then its return value is undefined--that is, anything you want.
   *  Normally, this method should not be called if cell (x, y) does not
   *  contain a shark.  You will need this method to help convert Oceans to
   *  run-length encodings.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int sharkFeeding(int x, int y) {
    // Replace the following line with your solution.
    return 0;
  }

}