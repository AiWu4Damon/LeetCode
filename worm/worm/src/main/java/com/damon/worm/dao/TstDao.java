package com.damon.worm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Description: //TODO(对象型指标操作表)
 * @Author: fjy
 * @Date: 2019/11/28 0028 21:51
 * @Version: V1.0
 */
@Repository
public interface TstDao {
    /**
     *接受密码
     * @param userName 用户名
     * @return 密码
     */
//    @Select("select password from w_user where userName =#{userName}")
    String getUser(@Param("userName") String userName);
}
