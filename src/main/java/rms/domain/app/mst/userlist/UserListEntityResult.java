package rms.domain.app.mst.userlist;

import java.util.StringJoiner;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import rms.common.utils.StringUtilsImpl;

/**
 * ユーザ一覧（検索結果）クラス
 */
@Entity
public class UserListEntityResult extends rms.common.abstracts.AbstractEntity {

    /** ユーザID */
    @Column(name = "user_id")
    private String userId;

    /** ユーザ名 */
    @Column(name = "user_nm")
    private String userNm;

    /** メールアドレス */
    @Column(name = "email")
    private String email;

    /** 部署略称 */
    @Column(name = "department_rnm")
    private String departmentRnm;

    /** 承認者ID1 */
    @Column(name = "approve_user_id1")
    private String approveUserId1;

    /** 承認者名1称 */
    @Column(name = "approve_user_nm1")
    private String approveUserNm1;

    /** 承認者ID2 */
    @Column(name = "approve_user_id2")
    private String approveUserId2;

    /** 承認者名2称 */
    @Column(name = "approve_user_nm2")
    private String approveUserNm2;

    /** 承認者ID3 */
    @Column(name = "approve_user_id3")
    private String approveUserId3;

    /** 承認者名3称 */
    @Column(name = "approve_user_nm3")
    private String approveUserNm3;

    /** 役割名1 */
    @Column(name = "role_nm1")
    private String roleNm1;

    /** 役割名2 */
    @Column(name = "role_nm2")
    private String roleNm2;

    /** 役割名3 */
    @Column(name = "role_nm3")
    private String roleNm3;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUserNm() {
        return userNm;
    }

    /**
     * ユーザ名を設定します。
     * @param userNm ユーザ名
     */
    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    /**
     * メールアドレスを取得します。
     * @return メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールアドレスを設定します。
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 部署略称を取得します。
     * @return 部署略称
     */
    public String getDepartmentRnm() {
        return departmentRnm;
    }

    /**
     * 部署略称を設定します。
     * @param departmentRnm 部署略称
     */
    public void setDepartmentRnm(String departmentRnm) {
        this.departmentRnm = departmentRnm;
    }

    /**
     * 承認者ID1を取得します。
     * @return 承認者ID1
     */
    public String getApproveUserId1() {
        return approveUserId1;
    }

    /**
     * 承認者ID1を設定します。
     * @param approveUserId1 承認者ID1
     */
    public void setApproveUserId1(String approveUserId1) {
        this.approveUserId1 = approveUserId1;
    }

    /**
     * 承認者名1称を取得します。
     * @return 承認者名1称
     */
    public String getApproveUserNm1() {
        return approveUserNm1;
    }

    /**
     * 承認者名1称を設定します。
     * @param approveUserNm1 承認者名1称
     */
    public void setApproveUserNm1(String approveUserNm1) {
        this.approveUserNm1 = approveUserNm1;
    }

    /**
     * 承認者ID2を取得します。
     * @return 承認者ID2
     */
    public String getApproveUserId2() {
        return approveUserId2;
    }

    /**
     * 承認者ID2を設定します。
     * @param approveUserId2 承認者ID2
     */
    public void setApproveUserId2(String approveUserId2) {
        this.approveUserId2 = approveUserId2;
    }

    /**
     * 承認者名2称を取得します。
     * @return 承認者名2称
     */
    public String getApproveUserNm2() {
        return approveUserNm2;
    }

    /**
     * 承認者名2称を設定します。
     * @param approveUserNm2 承認者名2称
     */
    public void setApproveUserNm2(String approveUserNm2) {
        this.approveUserNm2 = approveUserNm2;
    }

    /**
     * 承認者ID3を取得します。
     * @return 承認者ID3
     */
    public String getApproveUserId3() {
        return approveUserId3;
    }

    /**
     * 承認者ID3を設定します。
     * @param approveUserId3 承認者ID3
     */
    public void setApproveUserId3(String approveUserId3) {
        this.approveUserId3 = approveUserId3;
    }

    /**
     * 承認者名3称を取得します。
     * @return 承認者名3称
     */
    public String getApproveUserNm3() {
        return approveUserNm3;
    }

    /**
     * 承認者名3称を設定します。
     * @param approveUserNm3 承認者名3称
     */
    public void setApproveUserNm3(String approveUserNm3) {
        this.approveUserNm3 = approveUserNm3;
    }

    /**
     * 役割名1を取得します。
     * @return 役割名1
     */
    public String getRoleNm1() {
        return roleNm1;
    }

    /**
     * 役割名1を設定します。
     * @param roleNm1 役割名1
     */
    public void setRoleNm1(String roleNm1) {
        this.roleNm1 = roleNm1;
    }

    /**
     * 役割名2を取得します。
     * @return 役割名2
     */
    public String getRoleNm2() {
        return roleNm2;
    }

    /**
     * 役割名2を設定します。
     * @param roleNm2 役割名2
     */
    public void setRoleNm2(String roleNm2) {
        this.roleNm2 = roleNm2;
    }

    /**
     * 役割名3を取得します。
     * @return 役割名3
     */
    public String getRoleNm3() {
        return roleNm3;
    }

    /**
     * 役割名3を設定します。
     * @param roleNm3 役割名3
     */
    public void setRoleNm3(String roleNm3) {
        this.roleNm3 = roleNm3;
    }

    /**
     * 役割名を返却します<br>
     * 備考：役割が複数存在する場合は「/」で結合して返却
     * @return
     */
    public String getRoleNm() {
        StringJoiner join = new StringJoiner("/");
        //@formatter:off
        if(!StringUtilsImpl.isEmpty(roleNm1)){ join.add(roleNm1); }
        if(!StringUtilsImpl.isEmpty(roleNm2)){ join.add(roleNm2); }
        if(!StringUtilsImpl.isEmpty(roleNm3)){ join.add(roleNm3); }
        //@formatter:on
        return join.toString();
    }
}