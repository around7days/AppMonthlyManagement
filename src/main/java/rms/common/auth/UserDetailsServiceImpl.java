package rms.common.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import rms.common.dao.MUserDao;
import rms.common.entity.MUser;
import rms.common.entity.MUserRole;

/**
 * 独自認証処理
 * @author
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MUserDao mUserDao;

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        // ユーザ情報の取得
        MUser mUser = mUserDao.selectById(id);
        if (mUser == null) {
            throw new UsernameNotFoundException("ログインに失敗しました");
        }

        // ユーザ役割情報の取得
        List<MUserRole> mUserRoleList = userDetailsDao.userRoleListByUserId(id);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (MUserRole mUserRole : mUserRoleList) {
            authorities.add(new SimpleGrantedAuthority(mUserRole.getRole()));
        }

        // 認証ユーザ情報の返却
        return new UserInfo(mUser, authorities);
    }
}
