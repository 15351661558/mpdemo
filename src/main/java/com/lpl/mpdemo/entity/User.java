package com.lpl.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@TableName("t_user")
public class User {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("username")
    private String name;

    private Integer age;

//    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String address;

    @TableField(exist = false)
    private Integer height;

    @TableLogic(value = "0",delval = "1")
    private Integer deleteflag;


    @TableField(fill = FieldFill.INSERT)
    private transient LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private transient LocalDateTime modifyTime;


}
