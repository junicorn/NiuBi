package just.niubi.ascii;

import java.util.Date;
import java.util.Random;

/**
 * Created by biezhi on 2017/3/23.
 */
public class ImageToAscii {

    private int timestart = (int) System.currentTimeMillis() / 1000;
    private int textType_count = -1;
    private String textType = "sequence";
    private String[] HTMLcharacter = {"0", "1"};
    private String bgColor = "black";
    private int fontSize = -3;
    private int grayscale = 0;
    private String browser = "ie";
    private int contrast = 0;
    private Random random = new Random();
    private int[] contrastcurve = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 8, 8, 9, 9, 10, 10, 11, 12, 12, 13, 14, 14, 15, 16, 17, 17, 18, 19, 20, 21, 22, 23, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 45, 46, 47, 48, 49, 51, 52, 53, 54, 56, 57, 58, 60, 61, 62, 64, 65, 66, 68, 69, 71, 72, 73, 75, 76, 78, 79, 81, 82, 84, 85, 87, 88, 90, 91, 93, 94, 96, 97, 99, 100, 102, 103, 105, 106, 108, 109, 111, 113, 114, 116, 117, 119, 120, 122, 124, 125, 127, 128, 130, 131, 133, 135, 136, 138, 139, 141, 142, 144, 146, 147, 149, 150, 152, 153, 155, 156, 158, 159, 161, 162, 164, 165, 167, 168, 170, 171, 173, 174, 176, 177, 179, 180, 182, 183, 184, 186, 187, 189, 190, 191, 193, 194, 195, 197, 198, 199, 201, 202, 203, 204, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 218, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 232, 233, 234, 235, 236, 237, 238, 238, 239, 240, 241, 241, 242, 243, 243, 244, 245, 245, 246, 246, 247, 247, 248, 249, 249, 249, 250, 250, 251, 251, 252, 252, 252, 253, 253, 253, 253, 254, 254, 254, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255};

    private String imageURL;
    private String HTMLheader, beginHTML, endHTML, fontHTMLstart, fontHTMLend;

    public void setHTMLvars() {
        HTMLheader = "<!-- Generated on " + new Date().toLocaleString() + " using pic2html.cgi, by Patrik Roos -->\n\n";

        beginHTML = "<HTML><HEAD><TITLE>Text image</TITLE></HEAD><BODY>\n";
        endHTML = "</td></tr></table>\n</BODY></HTML>";
        fontHTMLstart = "<font color=";
        fontHTMLend = "</font>";
    }

    public void werr(String errorMessage) {
        setHTMLvars();
        write(HTMLheader + "\n" + beginHTML + "\n");
        write("<table align=center><tr bgcolor=black><td><font color=lightblue size=4>Error: " + errorMessage + "</font></td></tr></table>\n");
        write(endHTML + "\n");
        return;
    }

    public String nextCharacter() {
        if (HTMLcharacter.length == 1) {
            return HTMLcharacter[0];
        }
        if (textType == "random") {
            return HTMLcharacter[random.nextInt(HTMLcharacter.length)];
        } else if (textType == "sequence") {
            textType_count++;
            if (textType_count >= HTMLcharacter.length) {
                textType_count = 0;
                return HTMLcharacter[0];
            }
            return HTMLcharacter[textType_count];
        }
        return null;
    }

    public void write(String html) {
        System.out.println(html);
    }

    public static void main(String[] args) {

        ImageToAscii imageToAscii = new ImageToAscii();

        imageToAscii.write("Content-Type: text/html\r\n\r\n");
        int imageWidth = 130;
        String imageData = "";

    }
}
