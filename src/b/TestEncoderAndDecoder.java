package b;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestEncoderAndDecoder {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "都是中文";
		
		// 第一个参数: 待转换的字符串
		// 第二个参数: 转换字符串时使用的编码格式
		String encode = URLEncoder.encode(str, "utf-8");
		System.out.println(encode);
		
		String e = "%E9%83%BD%E6%98%AF%E4%B8%AD%E6%96%87";
		
		String decode = URLDecoder.decode(e, "utf-8");
		System.out.println(decode);
	}
	
}
