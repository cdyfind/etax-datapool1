package com.aisino.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.BillInspectionDataGoods;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * (BillInspectionDataGoods)表服务接口
 *
 * @author cdy
 * @since 2023-06-12 15:01:46
 */
public interface BillInspectionDataGoodsService extends IService<BillInspectionDataGoods> {

    /**
     * 新增发票校验物品数据
     *
     * @param billInspectionDataGoods
     * @return BillInspectionDataGoods
     */
    public BillInspectionDataGoods saveBillInspectionDataGoods(BillInspectionDataGoods billInspectionDataGoods);
}

