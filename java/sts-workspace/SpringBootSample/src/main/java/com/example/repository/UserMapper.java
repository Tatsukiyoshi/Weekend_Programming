package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.MUser;

@Mapper
public interface UserMapper {
    /** ユーザ登録 */
    public int insertOne(MUser user);
    
    /** ユーザ取得 */
    public List<MUser> findMany();
    
    /** ユーザ取得（1件） */
    public MUser findOne(String userId);
    
    /** ユーザ更新（１件） */
    public void updateOne(@Param("userId") String userId,
            @Param("password") String password,
            @Param("userName") String userName);
    
    /** ユーザ削除（１件） */
    public int deleteOne(@Param("userId") String userId);
}
