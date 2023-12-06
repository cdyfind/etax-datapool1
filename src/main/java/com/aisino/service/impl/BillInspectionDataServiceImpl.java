package com.aisino.service.impl;

import com.aisino.base.IdGeneratorSnowflake;
import com.aisino.entity.InvoiceLog;
import com.aisino.pojo.BillInspectionDataVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.aisino.dao.BillInspectionDataDao;
import com.aisino.entity.BillInspectionData;
import com.aisino.service.BillInspectionDataService;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BillInspectionData)表服务实现类
 *
 * @author cdy
 * @since 2023-06-12 14:59:40
 */
@Service("billInspectionDataService")
public class BillInspectionDataServiceImpl extends ServiceImpl<BillInspectionDataDao, BillInspectionData> implements BillInspectionDataService {

    @Resource
    private IdGeneratorSnowflake snowflake;

    @Resource
    private BillInspectionDataDao billInspectionDataDao;

    @Override
    public BillInspectionData saveBillInspectionData(BillInspectionData billInspectionData) {
        Long snowflakeId = snowflake.snowflakeId();
        billInspectionData.setId(snowflakeId.toString());
        this.save(billInspectionData);
        return billInspectionData;
    }

    @Override
    public List<BillInspectionDataVO> getBillInspectionDataVOList(String id) {

        MPJLambdaWrapper<BillInspectionDataVO> wrapper = new MPJLambdaWrapper<BillInspectionDataVO>()
                .selectAll(BillInspectionData.class)
                .selectAll(InvoiceLog.class)
                .innerJoin(InvoiceLog.class,InvoiceLog::getId,BillInspectionData::getInvoiceLogId)
                .eq(BillInspectionData::getId,id);
        List<BillInspectionDataVO> list = billInspectionDataDao.selectJoinList(BillInspectionDataVO.class, wrapper);

        return list;
    }
}

