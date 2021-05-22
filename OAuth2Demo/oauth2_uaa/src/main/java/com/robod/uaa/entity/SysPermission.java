package com.robod.uaa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Robod
 * @date 2020/8/9 17:30
 */
@Data
public class SysPermission implements GrantedAuthority {

    private String id;
    private String code;
    private String description;
    private String url;

    /**
     * 如果授予的权限可以当作一个String的话，就可以返回一个String
     * @return
     */
    @JsonIgnore
    @Override
    public String getAuthority() {
        return code;
    }

}
