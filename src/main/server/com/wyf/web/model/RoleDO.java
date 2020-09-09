package com.wyf.web.model;

import lombok.Data;

import java.util.List;

/**
*@description 角色实体
*@author weiyifei
*@date 2020/9/1
*/
@Data
public class RoleDO {

    private Long id;
    private String name;
    private String desc;
    private List<AuthorityDO> authorities;
}
