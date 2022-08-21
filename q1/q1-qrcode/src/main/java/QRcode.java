import java.util.Arrays;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    public boolean demitour(QRcode x,QRcode o){
        for (int i = 0; i < x.data.length; i++) {
            for (int j = 0; j < x.data[0].length; j++) {
                if(x.data[i][j] != o.data[o.data.length-i-1][o.data[0].length-1-j]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean quart(QRcode x, QRcode o){
        for (int i = 0; i < x.data.length ; i++) {
            for (int j = 0; j < x.data[0].length ; j++) {
                if (x.data[i][j] != o.data[j][o.data.length-i-1]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean treeQuart(QRcode x, QRcode o){
        for (int i = 0; i < x.data.length ; i++) {
            for (int j = 0; j < x.data[0].length ; j++) {
                if(x.data[i][j] != o.data[o.data.length-1-j][i] ){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean normal(QRcode x, QRcode o){
        for (int i = 0; i < x.data.length ; i++) {
            for (int j = 0; j < x.data[0].length ; j++) {
                if(x.data[i][j] != o.data[i][j] ){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(!( o instanceof QRcode)){
            return false;
        }
        QRcode code = (QRcode) o;
        return (demitour(this,code) || quart(this,code) || treeQuart(this, code)|| normal(this,code));

    }



}
