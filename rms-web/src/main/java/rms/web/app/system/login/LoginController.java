package rms.web.app.system.login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import rms.common.base.WebSecurityConfig;
import rms.common.consts.MessageEnum;
import rms.common.consts.MessageTypeConst;
import rms.common.entity.TInfomation;
import rms.domain.app.system.login.LoginService;

/**
 * ログイン画面コントローラー
 * @author
 */
@Controller
@SessionAttributes(types = LoginForm.class)
public class LoginController extends rms.common.abstracts.AbstractController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /** ページURL */
    private static final String PAGE_URL = "html/login";

    /** マッピングURL */
    public static final String MAPPING_URL = WebSecurityConfig.LOGIN_MAPPING_URL;

    /** 画面ID */
    public static final String SCREEN_ID = "S001";

    /** ログイン画面サービス */
    @Autowired
    LoginService service;

    /**
     * ログイン画面フォームの初期化
     * @return
     */
    @ModelAttribute
    LoginForm setupForm() {
        return new LoginForm();
    }

    /**
     * 初期処理
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(MAPPING_URL)
    public String init(LoginForm form,
                       WebRequest request,
                       HttpSession session) {
        if (!session.isNew() && request.getUserPrincipal() != null) {
            // セッション情報が残っている場合は一度ログアウト処理を実施（念の為セッションとユーザ情報の両方をチェック）
            logger.debug("session invalidate -> {}", request.getSessionId());
            return urlHelper.forward(WebSecurityConfig.LOGOUT_MAPPING_URL);
        }

        // お知らせ情報の取得
        TInfomation entity = service.getInfomation();
        if (entity != null) {
            form.setInfo(entity.getInfo());
        }

        return PAGE_URL;
    }

    /**
     * ログイン処理<br>
     * 備考：ログイン認証/ログアウト処理はWebSecurityConfigで実施
     * @param form
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "validate")
    public String login(@Validated LoginForm form,
                        BindingResult bindingResult,
                        Model model) {
        // 入力チェック
        if (bindingResult.hasErrors()) {
            logger.debug("入力チェックエラー -> {}", bindingResult.getAllErrors());
            return PAGE_URL;
        }

        // ログイン認証処理にフォワード
        return urlHelper.forward(WebSecurityConfig.AUTH_MAPPING_URL);
    }

    /**
     * ログイン失敗処理<br>
     * 備考：SpringConfigで設定したログインできなかった場合の処理を定義する
     * @param form
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "error")
    public String loginError(LoginForm form,
                             BindingResult bindingResult,
                             Model model) {
        // 「ログインに失敗しました。」
        model.addAttribute(MessageTypeConst.ERROR, message.getMessage(MessageEnum.error011));
        logger.debug("認証エラー -> {}", bindingResult.getAllErrors());
        return PAGE_URL;
    }

    /*
     * (非 Javadoc)
     * @see rms.common.abstracts.AbstractController#getScreenId()
     */
    @Override
    protected String getScreenId() {
        return SCREEN_ID;
    }
}
