package rms;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SpringSwitchApplicationクラス<br>
 * 引数によってSpringWebApplicationとSpringBatchApplicationの起動を切り替える
 * @author
 */
public class SpringSwitchApplication {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(SpringSwitchApplication.class);

    /** 起動タイプ */
    private enum Type {
        WEB, BATCH
    }

    /**
     * メイン起動
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 起動タイプの判定
        Type type = getStartupType(args);
        logger.info("***************************** START UP -> {} *****************************", type);
        if (args != null && args.length > 0) {
            logger.debug("起動パラメータ -> {}", ToStringBuilder.reflectionToString(args, ToStringStyle.SIMPLE_STYLE));
        }

        // 起動
        switch (type) {
        case WEB:
            SpringWebApplication.main(args);
            break;
        case BATCH:
            SpringBatchApplication.main(args);
            break;
        }
    }

    /**
     * 起動タイプの取得<br>
     * 第1引数が"batch"の場合は「BATCH」、それ以外は「WEB」を返却
     * @param args
     * @return 起動タイプ
     * @throws Exception
     */
    private static Type getStartupType(String[] args) {
        if (args != null && args.length > 0 && args[0].equalsIgnoreCase(Type.BATCH.name())) {
            return Type.BATCH;
        }
        return Type.WEB;
    }
}
