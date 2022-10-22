package com.example.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;
    
    /** ユーザ登録 */
    @Override
    public void signup(MUser user) {
        user.setDepartmentId(1);    // 部署
        user.setRole("ROLE_GENERAL");   // ロール
        mapper.insertOne(user);
    }
    
    /** ユーザ取得 */
    @Override
    public List<MUser> getUsers(MUser user){
        return mapper.findMany(user);
    }

    @Override
    public MUser getUserOne(String userId) {
        return mapper.findOne(userId);
    }

    /** ユーザ更新（１件） */
    @Transactional
    @Override
    public void updateUserOne(String userId, String password, String userName) {
        mapper.updateOne(userId, password, userName);
        
        // 例外を発生させる（トランザクション確認用のコード）
        // int i = 1/ 0;
    }

    /** ユーザ削除（1件） */
    @Override
    public void deleteOne(String userId) {
        int count = mapper.deleteOne(userId);
    }
}
