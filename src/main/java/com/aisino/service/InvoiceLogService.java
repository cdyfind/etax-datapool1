package com.aisino.service;

import com.aisino.entity.PlatformPurchaseSalesGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.InvoiceLog;

/**
 * 调用记录日志表(InvoiceLog)表服务接口
 *
 * @author cdy
 * @since 2023-06-14 13:48:17
 */
public interface InvoiceLogService extends IService<InvoiceLog> {
    /**
     * 新增日志
     *
     * @param entity
     * @return
     * */
    public InvoiceLog saveInvoiceLogService(InvoiceLog entity);
}

