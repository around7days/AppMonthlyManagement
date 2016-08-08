package rms.web.tran.report.approve.regist;

import rms.com.validator.annotation.UploadFileNotEmpty;
import rms.domain.com.entity.VTReport;

import org.springframework.web.multipart.MultipartFile;

/**
 * 月報承認画面フォーム
 * @author
 */
public class ReportApproveRegistForm extends rms.web.com.abstracts.AbstractForm {

    /* 更新制御用 ----------------------------------------------------------- */
    /** 更新制御用 月報管理情報 */
    private VTReport updateEntity;

    /* 変数宣言 ------------------------------------------------------------- */
    /** 申請者ID */
    private String applyUserId;
    /** 申請者名 */
    private String applyUserNm;
    /** 年月 */
    private String targetYm;
    /** 月報ファイル */
    @UploadFileNotEmpty(message = "月報は{UploadFileNotEmpty.message}")
    private MultipartFile file;
    /** 公開有無名称 */
    private String publishNm;
    /** 承認者名1 */
    private String approveUserNm1;
    /** 承認者名2 */
    private String approveUserNm2;
    /** 承認者名3 */
    private String approveUserNm3;

    /* getter/setter -------------------------------------------------------- */
    /**
     * 更新制御用 月報管理情報を取得します。
     * @return 更新制御用 月報管理情報
     */
    public VTReport getUpdateEntity() {
        return updateEntity;
    }

    /**
     * 更新制御用 月報管理情報を設定します。
     * @param updateEntity 更新制御用 月報管理情報
     */
    public void setUpdateEntity(VTReport updateEntity) {
        this.updateEntity = updateEntity;
    }

    /**
     * 申請者IDを取得します。
     * @return 申請者ID
     */
    public String getApplyUserId() {
        return applyUserId;
    }

    /**
     * 申請者IDを設定します。
     * @param applyUserId 申請者ID
     */
    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    /**
     * 申請者名を取得します。
     * @return 申請者名
     */
    public String getApplyUserNm() {
        return applyUserNm;
    }

    /**
     * 申請者名を設定します。
     * @param applyUserNm 申請者名
     */
    public void setApplyUserNm(String applyUserNm) {
        this.applyUserNm = applyUserNm;
    }

    /**
     * 年月を取得します。
     * @return 年月
     */
    public String getTargetYm() {
        return targetYm;
    }

    /**
     * 年月を設定します。
     * @param targetYm 年月
     */
    public void setTargetYm(String targetYm) {
        this.targetYm = targetYm;
    }

    /**
     * 月報ファイルを取得します。
     * @return 月報ファイル
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * 月報ファイルを設定します。
     * @param file 月報ファイル
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * 公開有無名称を取得します。
     * @return 公開有無名称
     */
    public String getPublishNm() {
        return publishNm;
    }

    /**
     * 公開有無名称を設定します。
     * @param publishNm 公開有無名称
     */
    public void setPublishNm(String publishNm) {
        this.publishNm = publishNm;
    }

    /**
     * 承認者名1を取得します。
     * @return 承認者名1
     */
    public String getApproveUserNm1() {
        return approveUserNm1;
    }

    /**
     * 承認者名1を設定します。
     * @param approveUserNm1 承認者名1
     */
    public void setApproveUserNm1(String approveUserNm1) {
        this.approveUserNm1 = approveUserNm1;
    }

    /**
     * 承認者名2を取得します。
     * @return 承認者名2
     */
    public String getApproveUserNm2() {
        return approveUserNm2;
    }

    /**
     * 承認者名2を設定します。
     * @param approveUserNm2 承認者名2
     */
    public void setApproveUserNm2(String approveUserNm2) {
        this.approveUserNm2 = approveUserNm2;
    }

    /**
     * 承認者名3を取得します。
     * @return 承認者名3
     */
    public String getApproveUserNm3() {
        return approveUserNm3;
    }

    /**
     * 承認者名3を設定します。
     * @param approveUserNm3 承認者名3
     */
    public void setApproveUserNm3(String approveUserNm3) {
        this.approveUserNm3 = approveUserNm3;
    }

}
