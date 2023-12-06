package com.aisino.controller;



import com.aisino.base.R;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.BillInspectionData;
import com.aisino.service.BillInspectionDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;

/**
 * (BillInspectionData)表控制层
 *
 * @author cdy
 * @since 2023-06-12 14:59:31
 */
@Api(tags = "发票校验数据")
@RestController
@RequestMapping("billInspectionData")
public class BillInspectionDataController  {
    /**
     * 服务对象
     */
    @Resource
    private BillInspectionDataService billInspectionDataService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param billInspectionData 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "分页查询发票校验数据")
    @GetMapping
    public R selectAll(Page<BillInspectionData> page, BillInspectionData billInspectionData) {
        return success(this.billInspectionDataService.page(page, new QueryWrapper<>(billInspectionData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = " 通过主键查询单条数据")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
//        return success(this.billInspectionDataService.getById(id));
        return success(this.billInspectionDataService.getBillInspectionDataVOList(String.valueOf(id)));
    }

    /**
     * 新增数据
     *
     * @param billInspectionData 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = " 新增发票校验数据")
    @PostMapping
    public R insert(@RequestBody BillInspectionData billInspectionData) {
        return success(this.billInspectionDataService.saveBillInspectionData(billInspectionData));
    }

    /**
     * 修改数据
     *
     * @param billInspectionData 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "修改发票校验数据")
    @PutMapping
    public R update(@RequestBody BillInspectionData billInspectionData) {
        return success(this.billInspectionDataService.updateById(billInspectionData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "删除发票校验数据")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.billInspectionDataService.removeByIds(idList));
    }
}

