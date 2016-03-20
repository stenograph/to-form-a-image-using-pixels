package stenography;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


class pixelsd {
 BufferedImage image;
 int width;
 int height;
 
 public pixelsd() {
    try {
       File input = new File("abcd.jpg");
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
        /*String FGH="0E3zwt7e45s=";
		byte[] bytes = FGH.getBytes("US-ASCII");
		for(int i=0;i<bytes.length;i++)
		{
			System.out.print(bytes[i] + "\t");
		}*/
		
      /*for(int i=0;i<15;i++){
         for(int j=0;j<3;j++){
             System.out.print(" " + pixelData[i][j]);
             }System.out.println(" ");
      }*/
		
		
		
       int po=0;
       
		for(int nk=0;nk<420;nk++){
			for(int lk=0;lk<105;lk++){
				for(int k=0;k<3;k++){
					pixelData[po][k]=0;
				}
				po++;
			}
		}
		for(int i=0;i<15;i++){
	         for(int j=0;j<3;j++){
	             System.out.print(" " + pixelData[i][j]);
	             }System.out.println(" ");
	      }
		int count=0;
		int d=0,k=1,t=2;
		BufferedImage bufferImage2=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		 for(int y=0;y<width;y++){
	            for(int x=0;x<height;x++){
	            	
	                int Pixel=pixelData[count][d]<<16 | pixelData[count][k] << 8 | pixelData[count][t];
	                bufferImage2.setRGB(y, x,Pixel);
	                count++;
	                //System.out.println(x + "\t" + y + "\t" + count);
	            	
	            }
		 }
		 
		 
			 File f= new File("hfkfhnni.jpg");
			 ImageIO.write(bufferImage2, "jpg", f);
		 
         
	            
	            
		
		
         
        
    
       
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
