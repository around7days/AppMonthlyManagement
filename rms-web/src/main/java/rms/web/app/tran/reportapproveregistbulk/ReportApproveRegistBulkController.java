package rms.web.app.tran.reportapproveregistbulk;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import rms.common.auth.UserInfo;
import rms.common.consts.MRoleConst;
import rms.common.consts.MessageEnum;
import rms.common.consts.MessageTypeConst;
import rms.common.exception.BusinessException;
import rms.domain.app.tran.reportapproveregistbulk.ReportApproveRegistBulkDto;
import rms.domain.app.tran.reportapproveregistbulk.ReportApproveRegistBulkService;
import rms.web.app.tran.reportapprovelist.ReportApproveListController;

/**
 * 月報一括承認画面コントローラー<br>
 * 役割：管理者、承認者
 * @author
 */
@Controller
@SessionAttributes(types = ReportApproveRegistBulkForm.class)
@Secured(value = { MRoleConst.ADMIN, MRoleConst.APPROVE })
public class ReportApproveRegistBulkController extends rms.common.abstracts.AbstractController {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(ReportApproveRegistBulkController.class);

    /** ページURL */
    private static final String PAGE_URL = "html/reportApproveRegistBulk";

    /** マッピングURL */
    public static final String MAPPING_URL = "/tran/reportapproveregistbulk";

    /** 画面ID */
    public static final String SCREEN_ID = "T005";

    /** 月報一括承認画面サービス */
    @Autowired
    ReportApproveRegistBulkService service;

    /**
     * 月報一括承認画面フォームの初期化
     * @return
     */
    @ModelAttribute
    ReportApproveRegistBulkForm setupForm() {
        return new ReportApproveRegistBulkForm();
    }

    /**
     * 初期表示処理
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "init")
    public String init(ReportApproveRegistBulkForm form,
                       Model model) {
        return PAGE_URL;
    }

    /**
     * 一括承認処理
     * @param form
     * @param bindingResult
     * @param userInfo
     * @param sessionStatus
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = MAPPING_URL, params = "approveBulk")
    public String approveBulk(@Validated ReportApproveRegistBulkForm form,
                              BindingResult bindingResult,
                              @AuthenticationPrincipal UserInfo userInfo,
                              SessionStatus sessionStatus,
                              Model model) throws IOException {
        logger.debug("入力フォーム情報 -> {}", form);

        // 入力チェック
        if (bindingResult.hasErrors()) {
            logger.debug("入力チェックエラー -> {}", bindingResult.getAllErrors());
            return PAGE_URL;
        }

        try {
            // 月報情報の一括承認処理
            List<ReportApproveRegistBulkDto> resultList = service.approveBulk(form.getFile(), userInfo);
            // 実行結果の反映
            form.setResultList(resultList);
        } catch (BusinessException e) {
            logger.debug("業務エラー -> {}", e.toString());
            model.addAttribute(MessageTypeConst.ERROR, e.getErrorMessage());
            return PAGE_URL;
        }

        // 完了メッセージ
        model.addAttribute(MessageTypeConst.SUCCESS, message.getMessage(MessageEnum.info005));
        // セッション破棄
        sessionStatus.setComplete();

        return PAGE_URL;
    }

    /**
     * 戻る処理
     * @param sessionStatus
     * @return
     */
    @RequestMapping(value = MAPPING_URL, params = "back")
    public String back(SessionStatus sessionStatus) {
        // セッション破棄
        sessionStatus.setComplete();
        return urlHelper.redirect(ReportApproveListController.MAPPING_URL, "reSearch");
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
