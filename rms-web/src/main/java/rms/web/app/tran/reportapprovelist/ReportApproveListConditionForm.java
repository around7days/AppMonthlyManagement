package rms.web.app.tran.reportapprovelist;

/**
 * 月報承認状況一覧（検索条件）画面フォーム
 * @author
 */
public class ReportApproveListConditionForm extends rms.common.abstracts.AbstractForm {

    /* 変数宣言 ------------------------------------------------------------- */
    /** 対象年月 */
    private Integer targetYm;

    /* getter/setter -------------------------------------------------------- */
    public Integer getTargetYm() {
        return targetYm;
    }

    public void setTargetYm(Integer targetYm) {
        this.targetYm = targetYm;
    }
}
