package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;

public interface UserService {
    /** ユーザ登録 */
    public void signup(MUser user);
    
    /** ユーザ取得 */
    public List<MUser> getUsers();
    
    /** ユーザ取得（１件） */
    public MUser getUserOne(String userId);
}
