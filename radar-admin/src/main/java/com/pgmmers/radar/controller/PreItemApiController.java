package com.pgmmers.radar.controller;


import com.pgmmers.radar.dal.bean.PreItemQuery;
import com.pgmmers.radar.service.common.CommonResult;
import com.pgmmers.radar.service.model.PreItemService;
import com.pgmmers.radar.vo.model.PreItemVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services/v1/preitem")
@Api(value = "PreitemApi", description = "预处理接口相关操作",  tags = {"预处理API"})
public class PreItemApiController {

    @Autowired
    private PreItemService preItemService;

    @GetMapping("/{id}")
    public CommonResult get(@PathVariable Long id) {
        CommonResult result = new CommonResult();
        PreItemVO preItemVO = preItemService.get(id);
        if (preItemVO != null) {
            result.setSuccess(true);
            result.getData().put("preItem", preItemVO);
        }
        return result;
    }


    @GetMapping("/list/{modelId}")
    public CommonResult list(@PathVariable Long modelId) {
        CommonResult result = new CommonResult();
        result.setSuccess(true);
        result.getData().put("list", preItemService.listPreItem(modelId));
        return result;
    }

    @PostMapping
    public CommonResult query(@RequestBody PreItemQuery query) {
        return preItemService.query(query);
    }

    @PutMapping
    public CommonResult save(@RequestBody PreItemVO preItem) {
        return preItemService.save(preItem);
    }

    @DeleteMapping
    public CommonResult delete(@RequestBody Long[] id) {
        return preItemService.delete(id);
    }

}
