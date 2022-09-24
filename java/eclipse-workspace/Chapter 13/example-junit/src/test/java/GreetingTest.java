import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Greeting テストクラス
 */
public class GreetingTest {
	/**
	 * コンストラクタ
	 */
	public GreetingTest() {}
	
    private Greeting target = new Greeting();

    /**
	 * 夜の挨拶テスト
	 */
	@Test
	public void getMessage_夜開始(){
	    // 実行
	    String message = this.target.getMessage(17);
	
	    // 検証
	    assertEquals(message, "こんばんは");
	}

	/**
     * 朝の挨拶テスト
     */
    @Test
    public void getMessage_朝開始(){
        // 実行
        String message = this.target.getMessage(5);

        // 検証
        assertEquals(message, "おはようございます");
        //assertThat(message, is("おはようございます"));
    }

    /**
     * 昼の挨拶テスト
     */
    @Test
    public void getMessage_昼開始(){
        // 実行
        String message = this.target.getMessage(11);

        // 検証
        assertEquals(message, "こんにちは");
    }
}
