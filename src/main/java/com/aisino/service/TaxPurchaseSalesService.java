package com.aisino.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.TaxPurchaseSales;

/**
 * (TaxPurchaseSales)表服务接口
 *
 * @author cdy
 * @since 2023-06-13 10:26:15
 */
public interface TaxPurchaseSalesService extends IService<TaxPurchaseSales> {

    /**
     * 保存 发票PlusTax对象
     * @param entity
     * @return
     */
    public TaxPurchaseSales saveTax(TaxPurchaseSales entity);
}

