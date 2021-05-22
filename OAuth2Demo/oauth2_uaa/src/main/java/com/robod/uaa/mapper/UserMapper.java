package com.robod.uaa.mapper;

import com.robod.uaa.entity.SysPermission;
import com.robod.uaa.entity.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Repository("userMapper")
public interface UserMapper {

    /**
     * 根据账号查询用户信息
     * @param username
     * @return
     */
    @Select("select * from t_user where username = #{username} limit 1")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = List.class,
                many = @Many(select = "com.robod.uaa.mapper.UserMapper.findPermissionsByUserId"))
    })
    SysUser getUserByUsername(String username);

    /**
     * 根据用户id查询用户权限
     * @param userId
     * @return
     */
    @Select("SELECT * FROM t_permission WHERE id IN(" +
            "SELECT permission_id FROM t_role_permission WHERE role_id IN(" +
            "SELECT role_id FROM t_user_role WHERE user_id = #{userId})" +
            ")")
    List<SysPermission> findPermissionsByUserId(String userId);

}
