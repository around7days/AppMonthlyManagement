DELETE FROM M_USER;
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user01', '申請者０１', 'pass', 'xxx@xxx.xx', 'user06', 'user07', 'user08', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user02', '申請者０２', 'pass', 'xxx@xxx.xx', 'user06', 'user07', 'user08', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user03', '申請者０３', 'pass', 'xxx@xxx.xx', 'user06', 'user07', 'user08', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user04', '申請者０４', 'pass', 'xxx@xxx.xx', 'user06', 'user07', 'user08', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user05', '申請者０５', 'pass', 'xxx@xxx.xx', 'user06', 'user07', 'user08', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user06', '承認者０１', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user07', '承認者０２', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user08', '承認者０３', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user09', '承認者０４', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user10', '承認者０５', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
INSERT INTO M_USER(user_id, user_nm, password, email, approver1_id, approver2_id, approver3_id, version, del_flg, ins_date, ins_id, upd_date, upd_id) VALUES ('user11', '管理者０１', 'pass', 'xxx@xxx.xx', '', '', '', 0, 0, now(), 'system', now(), 'system');
commit;
