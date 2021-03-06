package rms.domain.app.tran.reportapprovelist;

import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rms.common.utils.PageInfo;
import rms.common.utils.ProjectProperties;
import rms.common.utils.SearchResultDto;
import rms.common.utils.SelectOptionsUtils;

/**
 * 月報承認状況一覧画面サービス
 * @author
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReportApproveListServiceImpl implements ReportApproveListService {

    /** logger */
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(ReportApproveListServiceImpl.class);

    /** application.properties */
    @SuppressWarnings("unused")
    @Autowired
    ProjectProperties properties;

    /** 月報情報取得Dao */
    @Autowired
    ReportApproveListDao dao;

    @Override
    public ReportApproveListDto initDisplay() {
        // 初期値の生成
        ReportApproveListDto condition = new ReportApproveListDto();
        // Integer targetYm = RmsUtils.getThisTargetYm(properties.getSysdate(), properties.getSwitchMonthReferenceDay());
        // condition.setTargetYm(targetYm); // 対象年月：当月

        return condition;
    }

    @Override
    public SearchResultDto<ReportApproveListResultEntity> search(ReportApproveListDto condition,
                                                                 PageInfo pageInfo) {
        // ページ情報の生成
        SelectOptions options = SelectOptionsUtils.get(pageInfo);

        // 検索処理
        List<ReportApproveListResultEntity> resultList = dao.reportApproveListByCondition(condition, options);

        // 検索結果格納
        SearchResultDto<ReportApproveListResultEntity> resultDto = new SearchResultDto<>();
        resultDto.setResultList(resultList);
        resultDto.setCount(options.getCount());

        return resultDto;
    }

}
