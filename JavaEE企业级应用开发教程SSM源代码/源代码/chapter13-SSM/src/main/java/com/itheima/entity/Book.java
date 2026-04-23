package com.itheima.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author hm
 * @since 2024-04-29
 */
/*@Getter
@Setter*/
@Data
@TableName("book")
public class Book {
    @TableId("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("price")
    private BigDecimal price;
}
