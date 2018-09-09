package string;

/**
 * @Author: Usher
 * @Description:
 * 对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)；
 * 如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)；
 * 如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节；
 * 如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节；
 * 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节；
 * 因此，对UTF-8编码中的任意字节，根据第一位，可判断是否为ASCII字符；
 * 根据前二位，可判断该字节是否为一个字符编码的第一个字节；
 * 根据前四位（如果前两位均为1），可确定该字节为字符编码的第一个字节，并且可判断对应的字符由几个字节表示；
 * 根据前五位（如果前四位为1），可判断编码是否有错误或数据传输过程中是否有错误。
 *
 * 我们可以先来判断第一位，如果是0的话，则说明是ASCII码，我们直接跳过，判断方法是只要比二进制数10000000小的数第一位肯定是0，然后我们来处理第一位是1的情况，由于第一位的1只是个标识符，后面连续跟的1的个数才是表示后面的字节的个数，我们可以统一从第一位开始连续1的个数，然后减去1就是后面的字节的个数，我想的办法是如果该数字大于等于128，则表示第一位是1，然后减去128，如果得到的数大于等于64，则表示第二位是1，依次类推就可以得到连续的个数，我们要注意10000000这个数是不合法的，遇到了直接返回false。我们得到了cnt的个数，只要验证后面的字节是否是以10开头的数即可，验证方法也很简单，只要这个数在10000000 ~ 10111111范围之间，则一定是10开头的，参见代码如下：
 *
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
            if(data==null || data.length==0) return false;

            for(int i=0;i<data.length;i++) {

                if(data[i]>255)
                    return false;
                int count;

                if((data[i] & 128) == 0) {
                    count = 1;
                } else if((data[i] & 224) == 192) {
                    count = 2;
                } else if((data[i] & 240) == 224) {
                    count = 3;
                } else if((data[i] & 248) == 240) {
                    count = 4;
                } else {
                    return false;
                }
                for(int j=1;j<count;j++) {
                    if(i+j>=data.length) return false;
                    if((data[i+j] & 192) != 128) return false;
                }
                i=i+count-1;
            }
            return true;
        }


/*
//简化
 public boolean validUtf8(int[] data) {
        int count = 0;
        for ( int a : data ) {
            if ( count == 0 ) {
                if((a>>5) == 0b110) count = 1;
                else if((a>>4) == 0b1110) count = 2;
                else if((a>>3) == 0b11110) count = 3;
                else if((a>>7) == 1 ) return false;
            }else{
                if((a>>6) != 0b10 ) return false;
                count -- ;
            }
        }
        return count == 0;
    }*/

}
