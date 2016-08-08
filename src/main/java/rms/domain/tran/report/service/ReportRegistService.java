package rms.domain.tran.report.service;

import rms.com.base.BusinessException;
import rms.com.consts.MCodeConst;
import rms.domain.com.entity.TReport;
import rms.domain.com.repository.TReportDao;
import rms.domain.tran.report.repository.ReportSelectDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.thymeleaf.util.StringUtils;

/**
 * 月報申請画面サービス
 * @author
 */
@Service
public class ReportRegistService extends rms.domain.com.abstracts.AbstractService {

    /** logger */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ReportRegistService.class);

    /** TReportDao */
    @Autowired
    TReportDao tReportDao;

    /** 月報情報取得Dao */
    @Autowired
    ReportSelectDao reportSelectDao;

    /**
     * 月報情報の申請処理<br>
     * 補足：承認状況はメソッド内で自動設定
     * @param entity
     */
    public void apply(TReport entity) {

        // 承認者の有無に合わせてステータスを設定
        if (!StringUtils.isEmpty(entity.getApproveUserId1())) {
            entity.setStatus(MCodeConst.A001_Y01);
        } else if (!StringUtils.isEmpty(entity.getApproveUserId2())) {
            entity.setStatus(MCodeConst.A001_Y02);
        } else {
            entity.setStatus(MCodeConst.A001_Y03);
        }

        // 登録処理
        tReportDao.insert(entity);
    }

    /**
     * 月報情報の承認処理<br>
     * 補足：承認状況はメソッド内で自動設定
     * @param entity
     * @throws BusinessException
     */
    public void approve(TReport entity) throws BusinessException {

        // 現在の承認状況と承認者の有無に合わせてステータスを設定
        String newStatus;
        switch (entity.getStatus()) {
        case MCodeConst.A001_Y01:
            newStatus = MCodeConst.A001_Y02;
            if (StringUtils.isEmpty(entity.getApproveUserId2())) {
                newStatus = MCodeConst.A001_Y03;
            }
            break;
        case MCodeConst.A001_Y02:
            newStatus = MCodeConst.A001_Y03;
            break;
        case MCodeConst.A001_Y03:
            newStatus = MCodeConst.A001_100;
            break;
        default:
            throw new BusinessException("例外エラー");
        }
        entity.setStatus(newStatus);

        // 更新処理
        tReportDao.update(entity);
    }

    /**
     * 月報情報の否認処理<br>
     * 補足：承認状況はメソッド内で自動設定
     * @param entity
     * @throws BusinessException
     */
    public void deny(TReport entity) throws BusinessException {
        // 現在の承認状況に合わせてステータスを設定
        String newStatus;
        switch (entity.getStatus()) {
        case MCodeConst.A001_Y01:
            newStatus = MCodeConst.A001_N01;
            break;
        case MCodeConst.A001_Y02:
            newStatus = MCodeConst.A001_N02;
            break;
        case MCodeConst.A001_Y03:
            newStatus = MCodeConst.A001_N03;
            break;
        default:
            throw new BusinessException("例外エラー");
        }
        entity.setStatus(newStatus);

        // 更新処理
        tReportDao.update(entity);
    }
}
