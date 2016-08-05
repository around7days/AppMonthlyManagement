package rms.web.tran.report.approve.list;

import java.util.List;

import rms.domain.tran.report.entity.ReportApproveListResultEntity;
import rms.web.com.utils.PageInfo;

import javax.validation.Valid;

/**
 * 月報承認状況一覧画面フォーム
 * @author
 */
public class ReportApproveListForm extends rms.web.com.abstracts.AbstractForm {

    /* 変数宣言 ------------------------------------------------------------- */
    /** 検索条件 */
    @Valid
    private ReportApproveListConditionForm condition = new ReportApproveListConditionForm();
    /** ページ情報 */
    private PageInfo pageInfo = new PageInfo();
    /** 検索結果リスト */
    private List<ReportApproveListResultEntity> resultList;

    /* getter/setter -------------------------------------------------------- */
    /**
     * 検索条件を取得します。
     * @return 検索条件
     */
    public ReportApproveListConditionForm getCondition() {
        return condition;
    }

    /**
     * 検索条件を設定します。
     * @param condition 検索条件
     */
    public void setCondition(ReportApproveListConditionForm condition) {
        this.condition = condition;
    }

    /**
     * ページ情報を取得します。
     * @return ページ情報
     */
    public PageInfo getPageInfo() {
        return pageInfo;
    }

    /**
     * ページ情報を設定します。
     * @param pageInfo ページ情報
     */
    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    /**
     * 検索結果リストを取得します。
     * @return 検索結果リスト
     */
    public List<ReportApproveListResultEntity> getResultList() {
        return resultList;
    }

    /**
     * 検索結果リストを設定します。
     * @param resultList 検索結果リスト
     */
    public void setResultList(List<ReportApproveListResultEntity> resultList) {
        this.resultList = resultList;
    }
}