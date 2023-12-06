package com.aisino.service;

import com.aisino.pojo.BillInspectionDataVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.aisino.entity.BillInspectionData;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * (BillInspectionData)表服务接口
 *
 * @author cdy
 * @since 2023-06-12 14:59:39
 */
public interface BillInspectionDataService extends IService<BillInspectionData> {

    /**
     * 保存单据信息
     *
     * @param billInspectionData
     */
    public BillInspectionData saveBillInspectionData(BillInspectionData billInspectionData);


    /**
     * 获取单据详情
     *
     * @param id
     * @return BillInspectionDataVO
     */
    public List<BillInspectionDataVO> getBillInspectionDataVOList(String id);
}

