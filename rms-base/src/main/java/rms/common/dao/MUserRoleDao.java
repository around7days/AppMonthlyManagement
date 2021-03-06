package rms.common.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.NoResultException;
import org.seasar.doma.jdbc.OptimisticLockException;
import org.seasar.doma.jdbc.SelectOptions;

import rms.common.entity.MUserRole;

/**
 * MUserRoleDaoクラス
 */
@Dao
@ConfigAutowireable
public interface MUserRoleDao {

    /* 自動生成メソッド ------------------------------------------------------------- */

    /**
     * 1件取得
     * @param userId
     * @param role
     * @return the MUserRole entity
     */
    @Select
    MUserRole selectById(String userId,
                         String role);

    /**
     * 1件取得
     * @param userId
     * @param role
     * @param options
     * @return the MUserRole entity
     */
    @Select
    MUserRole selectById(String userId,
                         String role,
                         SelectOptions options);

    /**
     * 1件取得
     * @param userId
     * @param role
     * @param version
     * @throws NoResultException
     * @return the MUserRole entity
     */
    @Select(ensureResult = true)
    MUserRole selectByIdAndVersion(String userId,
                                   String role,
                                   Integer version) throws NoResultException;

    /**
     * 存在チェック
     * @param userId
     * @param role
     * @return
     */
    @Select
    boolean existsById(String userId,
                       String role);

    /**
     * 挿入
     * @param entity
     * @return affected rows
     */
    @Insert(excludeNull = true)
    int insert(MUserRole entity);

    /**
     * 更新（楽観的排他制御）
     * @param entity
     * @return affected rows
     * @throws OptimisticLockException
     */
    @Update(excludeNull = true)
    int update(MUserRole entity) throws OptimisticLockException;

    /**
     * 更新
     * @param entity
     * @return affected rows
     */
    @Update(excludeNull = true, ignoreVersion = true)
    int updateNoOptimisticLockException(MUserRole entity);

    /**
     * 削除（楽観的排他制御）
     * @param entity
     * @return affected rows
     * @throws OptimisticLockException
     */
    @Delete
    int delete(MUserRole entity) throws OptimisticLockException;

    /**
     * 削除
     * @param entity
     * @return affected rows
     * @throws OptimisticLockException
     */
    @Delete(ignoreVersion = true)
    int deleteNoOptimisticLockException(MUserRole entity);

    /* 独自メソッド ------------------------------------------------------------- */

    /**
     * ユーザIDに紐付く一覧を取得
     * @param userId
     * @return
     */
    @Select
    List<MUserRole> selectListByUserId(String userId);

    /**
     * ユーザIDに紐付くレコードを全て削除
     * @param userId
     * @return
     */
    @Delete(sqlFile = true)
    int deleteListByUserId(String userId);

}