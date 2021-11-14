import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Encoding {

	public static void main(String[] args) {
		System.out.println("7-4-1");
		sub1();
		
		System.out.println("7-4-2");
		sub2();

		System.out.println("7-4-3");
		sub3();
		
		System.out.println("7-4-4");
		sub4();
		
		System.out.println("7-4-5");
		sub5();
	}

	private static void sub5() {
		String aaa = "aaa";
		String aa = "aa";
		String a = "a";
		
		System.out.println(aaa.equals(aa + a));
		System.out.println(aaa == (aa + a));
		System.out.println(aaa == (aa + a).intern());
	}

	private static void sub4() {
		// 環境依存文字
		String str = "あ𠀋𠀋𠀋あ";
		
		if(isIncludingSurrogateCharacter(str)) {
			System.out.println(str.codePointCount(0, str.length()));
		} else {
			System.out.println(str.length());
		}
	}

	private static boolean isIncludingSurrogateCharacter(String str) {
		char[] chars = str.toCharArray();
		
		for(char c : chars) {
			if(Character.isLowSurrogate(c) || Character.isHighSurrogate(c)) {
				System.out.println("サロゲートペアが含まれている文字列");
				return true;
			}
		}
		
		System.out.println("サロゲートペアが含まれていない文字列");
		return false;
	}

	private static void sub3() {
		byte[] utf16 = {0x30, 0x42, 0x30, 0x44};
		try {
			System.out.println("UTF-16から：" + new String(utf16, "UTF-16"));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		byte[] ms932 = {(byte)0x82, (byte)0xA0, (byte)0x82, (byte)0xA2};
		try {
			System.out.println("MS932から：" + new String(ms932, "MS932"));
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static void sub2() {
		String str = "あいうえお";
		
		System.out.print("UTF-8  : ");
		byte[] utf8;
		try {
			utf8 = str.getBytes("UTF-8");
			for(byte b : utf8) {
				System.out.printf("%02x", b);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println();

		System.out.print("UTF-16 : ");
		byte[] utf16;
		try {
			utf16 = str.getBytes("UTF-16");
			for(byte b : utf16) {
				System.out.printf("%02x", b);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println();

		System.out.print("UTF-32 : ");
		byte[] utf32 = str.getBytes(Charset.forName("UTF-32"));
		for(byte b : utf32) {
			System.out.printf("%02x", b);
		}
		System.out.println();
		
		System.out.print("MS932  : ");
		byte[] ms932 = str.getBytes(Charset.forName("MS932"));
		for(byte b : ms932) {
			System.out.printf("%02x", b);
		}
		System.out.println();
	}

	private static void sub1() {
		char c = 'あ';
		System.out.printf("%02x\n", (int)c);
	}
}
