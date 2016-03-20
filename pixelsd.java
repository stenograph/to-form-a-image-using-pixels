import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class pixelsd {
   BufferedImage image;
   int width;
   int height;
   
   public pixelsd() {
      try {
         File input = new File("hfkfhi.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         System.out.println("width, height: " + width + ", " + height);
         int[][] pixelData = new int[width * height][3];
         int[] rgb;
         
         int counter = 0;
         for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                rgb = getPixelData(image, i, j);

                for(int k = 0; k < rgb.length; k++){
                    pixelData[counter][k] = rgb[k];
                }

                counter++;
            }
        }
        /*for(int i=0;i<10;i++){
           for(int j=0;j<3;j++){
               System.out.print(" " + pixelData[i][j]);
               }System.out.println(" ");
        }*/
           
System.out.println(pixelData[0][2]);
System.out.println(pixelData[1][2]);
System.out.println(pixelData[2][2]);
System.out.println(pixelData[3][2]);
System.out.println(pixelData[4][2]);
System.out.println(pixelData[5][2]);
System.out.println(pixelData[6][2]);
System.out.println(pixelData[7][2]);

         
      } catch (Exception e) {}
   }
   
   static public void main(String args[]) throws Exception 
   {
      pixelsd obj = new pixelsd();
   }
private static int[] getPixelData(BufferedImage image, int x, int y) {
int argb = image.getRGB(x, y);

int rgb[] = new int[] {
    (argb >> 16) & 0xff, //red
    (argb >>  8) & 0xff, //green
    (argb      ) & 0xff  //blue
};
return rgb;
}
}

