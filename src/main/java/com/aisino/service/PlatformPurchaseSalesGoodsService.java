package com.aisino.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.PlatformPurchaseSalesGoods;

/**
 * (PlatformPurchaseSalesGoods)表服务接口
 *
 * @author cdy
 * @since 2023-06-13 10:08:39
 */
public interface PlatformPurchaseSalesGoodsService extends IService<PlatformPurchaseSalesGoods> {

    /**
     * 保存服务平台进销项发票物品
     *
     * @param entity
     * @return
     */
    public PlatformPurchaseSalesGoods savePlatformPurchaseSalesGoods(PlatformPurchaseSalesGoods entity);
}

