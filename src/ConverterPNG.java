import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ConverterPNG {

    public static void main(String[] args) {
        System.out.println("TEST");
        try(
                FileInputStream in = new FileInputStream("src/amongUs.png");
                FileOutputStream out = new FileOutputStream("out.png");
        ){

            byte[] byteList = in.readAllBytes();

            System.out.println("started");
            System.out.println("bit depth: " +Integer.toHexString(byteList[24]));
            System.out.println("color type: " + Integer.toHexString(byteList[25]));
            System.out.println("compression method: " + Integer.toHexString(byteList[26]));
            System.out.println("filter method: " + Integer.toHexString(byteList[27]));


            // Change the color from the IHDR chunk by updating color-type
            // byteList[25] = 2; //If you open this comment, close the PLTE chunk update so the image don't get corrupted.

            // Change the color from the PLTE chunk
            System.out.println("PLTE 0 : " + Integer.toHexString(byteList[37]));
            System.out.println("PLTE 1 : " + Integer.toHexString(byteList[38]));
            System.out.println("PLTE 2 : " + Integer.toHexString(byteList[39]));
            System.out.println("PLTE 3 : " + Integer.toHexString(byteList[40]));
            System.out.println("PLTE COLOR 1 : " + Integer.toHexString(byteList[41]));
            System.out.println("PLTE COLOR 2 : " + Integer.toHexString(byteList[42]));
            System.out.println("PLTE COLOR 3 : " + Integer.toHexString(byteList[43]));

            byteList[41] = 15;
            byteList[42] = 15;
            byteList[43] = 15;

            byteList[44] = 15;
            byteList[45] = 15;
            byteList[46] = 15;

            byteList[47] = 15;
            byteList[48] = 15;
            byteList[49] = 15;

            byteList[50] = 15;
            byteList[51] = 15;
            byteList[52] = 15;
            byteList[42] = 15;

                out.write(byteList);

            for (Byte byt: byteList){
                System.out.println(Integer.toHexString(byt));
            }
            System.out.println("finished");


        }catch(Exception e){

            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
