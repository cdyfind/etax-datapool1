package com.aisino.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.TaxPurchaseSalesDetails;

/**
 * (TaxPurchaseSalesDetails)表服务接口
 *
 * @author cdy
 * @since 2023-06-13 10:35:38
 */
public interface TaxPurchaseSalesDetailsService extends IService<TaxPurchaseSalesDetails> {

    /**
     * 保存税务进销项发票详情
     * @param entity
     * @return
     */
    public TaxPurchaseSalesDetails saveTaxPurchaseSalesDetails(TaxPurchaseSalesDetails entity);

}

