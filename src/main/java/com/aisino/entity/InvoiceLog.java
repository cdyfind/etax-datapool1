package com.aisino.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * (InvoiceLog)表实体类
 *
 * @author cdy
 * @since 2023-06-15 15:57:48
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLog extends Model<InvoiceLog> {
    //主键id
    private String id;
    //纳税人识别号
    private String nsrsbh;
    //平台商编码
    private String username;
    //数据来源
    private String source;
    //发票类型
    private String fplx;
    /**
     * 请求数据
     */
    @TableField(exist = false)
    private JSONObject datagram;
    @TableField(exist = false)
    private Boolean ysFlag;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


}

