package com.example.oxy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author oxy
 */
@Data
@TableName(value = "test")
public class TestModel {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String data;
    public TestModel(){

    }
    public TestModel(String name, String data) {
        this.name = name;
        this.data = data;
    }
}
