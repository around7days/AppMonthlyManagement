package rms.web.app.mst.userregist;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rms.common.consts.MRoleConst;
import rms.common.consts.MessageEnum;
import rms.common.consts.MessageTypeConst;
import rms.common.exception.BusinessException;
import rms.common.utils.RmsBeanUtils;
import rms.common.utils.RmsSessionUtils;
import rms.common.utils.SelectOptionEntity;
import rms.domain.app.mst.userregist.UserRegistDto;
import rms.domain.app.mst.userregist.UserRegistService;
import rms.web.app.mst.userlist.UserListController;
import rms.web.app.mst.userregist.UserRegistForm.Insert;
import rms.web.app.mst.userregist.UserRegistForm.Update;
import rms.web.app.system.menu.MenuController;

/**
 * ユーザ登録画面コントローラー<br>
 * 役割：管理者のみ
 * @author
 */
@Controller
@SessionAttributes(types = UserRegistForm.class)
@Secured(value = { MRoleConst.ADMIN })
public class UserRegistController extends rms.common.abstracts.AbstractController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(UserRegistController.class);

    /** ページURL */
    private static final String PAGE_URL = "html/userRegist";

    /** マッピングURL */
    public static final String MAPPING_URL = "/mst/userregist";

    /** 画面ID */
    public static final String SCREEN_ID = "M002";

    /** ユーザ登録画面サービス */
    @Autowired
    UserRegistService service;

    /**
     * ユーザ登録画面フォームの初期化
     * @return
     */
    @ModelAttribute
    UserRegistForm setupForm() {
        UserRegistForm form = new UserRegistForm();

        // selectbox用 承認者一覧の取得
        List<SelectOptionEntity> approveList = service.getSelectboxApprove();
        // selectbox用 部署一覧の取得
        List<SelectOptionEntity> departmentList = service.getSelectboxDepartment();

        // 値の反映
        form.setApproveList(approveList);
        form.setDepartmentList(departmentList);

        return form;
    }

    /**
     * 初期表示処理（新規時）
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "initInsert")
    public String initInsert(UserRegistForm form,
                             Model model) {
        // 画面表示モードを「新規」に設定
        form.setViewMode(UserRegistForm.VIEW_MODE_INSERT);
        return PAGE_URL;
    }

    /**
     * 初期表示処理（更新時）
     * @param form
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "initUpdate")
    public String initUpdate(UserRegistForm form,
                             @ModelAttribute("userId") String userId,
                             Model model) {
        // 選択されたユーザIDに紐付くユーザ情報を取得
        UserRegistDto entity = service.initDisplayUpdate(userId);

        // 取得した情報をフォームに反映
        RmsBeanUtils.copyProperties(entity, form);
        // 画面表示モードを「更新」に設定
        form.setViewMode(UserRegistForm.VIEW_MODE_UPDATE);

        logger.debug("出力フォーム情報 -> {}", form);

        return PAGE_URL;
    }

    /**
     * 新規登録処理
     * @param form
     * @param bindingResult
     * @param sessionStatus
     * @param redirectAttr
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "insert")
    public String insert(@Validated(Insert.class) UserRegistForm form,
                         BindingResult bindingResult,
                         SessionStatus sessionStatus,
                         RedirectAttributes redirectAttr,
                         Model model) {
        logger.debug("入力フォーム情報 -> {}", form);

        // 入力チェック
        if (bindingResult.hasErrors()) {
            logger.debug("入力チェックエラー -> {}", bindingResult.getAllErrors());
            return PAGE_URL;
        }

        // ユーザ登録情報Entityの生成
        UserRegistDto entity = RmsBeanUtils.createCopyProperties(form, UserRegistDto.class);

        try {
            // ユーザ情報登録処理
            service.regist(entity);
        } catch (BusinessException e) {
            logger.debug("業務エラー -> {}", e.toString());
            model.addAttribute(MessageTypeConst.ERROR, e.getErrorMessage());
            return PAGE_URL;
        }

        // 完了メッセージ
        redirectAttr.addFlashAttribute(MessageTypeConst.SUCCESS, message.getMessage(MessageEnum.info001));
        // セッション破棄
        sessionStatus.setComplete();

        return urlHelper.redirect(UserListController.MAPPING_URL, "reSearch");
    }

    /**
     * 更新処理
     * @param form
     * @param bindingResult
     * @param sessionStatus
     * @param redirectAttr
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "update")
    public String update(@Validated(Update.class) UserRegistForm form,
                         BindingResult bindingResult,
                         SessionStatus sessionStatus,
                         RedirectAttributes redirectAttr,
                         Model model) {
        // TODO フォームでリクエスト情報を受け取る場合に、ユーザーID等の想定外の情報まで受け取る可能性があるのが気になる。
        logger.debug("入力フォーム情報 -> {}", form);

        // 入力チェック
        if (bindingResult.hasErrors()) {
            logger.debug("入力チェックエラー -> {}", bindingResult.getAllErrors());
            return PAGE_URL;
        }

        // ユーザ登録情報Entityの生成
        UserRegistDto entity = RmsBeanUtils.createCopyProperties(form, UserRegistDto.class);

        try {
            // ユーザ情報更新処理
            service.update(entity);
        } catch (BusinessException e) {
            logger.debug("業務エラー -> {}", e.toString());
            model.addAttribute(MessageTypeConst.ERROR, e.getErrorMessage());
            return PAGE_URL;
        }

        // 完了メッセージ
        redirectAttr.addFlashAttribute(MessageTypeConst.SUCCESS, message.getMessage(MessageEnum.info002));
        // セッション破棄
        sessionStatus.setComplete();

        return urlHelper.redirect(UserListController.MAPPING_URL, "reSearch");
    }

    /**
     * 戻る処理
     * @param session
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "back")
    public String back(HttpSession session,
                       SessionStatus sessionStatus) {
        // セッション破棄
        sessionStatus.setComplete();

        String preScreenId = RmsSessionUtils.getRmsSessionInfo(session).getPreScreenId();
        if (MenuController.SCREEN_ID.equals(preScreenId)) {
            // 前画面がメニューの場合
            return urlHelper.redirect(MenuController.MAPPING_URL);
        } else {
            // 前画面がユーザ一覧画面の場合
            return urlHelper.redirect(UserListController.MAPPING_URL, "reSearch");
        }
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
