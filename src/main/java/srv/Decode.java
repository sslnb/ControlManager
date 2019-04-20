package srv;

import java.io.UnsupportedEncodingException;

public class Decode {
   public static String decode(String str) throws UnsupportedEncodingException {
        char ch;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i = i + 2) {
            ch = (char) Integer.parseInt(str.substring(i, i +2), 16);//每两位16进制转成一个char字符
            if (ch < 12) {//如果出现编码时候的溢出，那么需要加上256再减12
                ch = (char) (ch + 244);
            } else {
                ch = (char) (ch - 12);//根据凯撒编码规则，char要减去12
            }
            sb.append(ch);
        }
        //对结果的编码在主线程中处理
        String result = new String(sb.toString().getBytes("iso8859-1"),"GBK");
        return result;
    }
    
   public static void main(String[] args) {
	try {
		System.out.println(decode("333D4033"));
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
}
    
    
    
}
