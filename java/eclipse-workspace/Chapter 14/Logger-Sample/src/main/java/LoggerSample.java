import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSample {
	private static final Logger logger = LoggerFactory.getLogger(LoggerSample.class);
	
	public static void main(String[] args) {
		logger.info("アプリケーションを実行しました。");
		logger.warn("警告すべき事象が発生しました。");
		logger.error("アプリケーションに例外がしました。");
	}
}
