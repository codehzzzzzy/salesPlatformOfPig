package com.demo.project.controller;
import com.alibaba.excel.EasyExcel;
import com.demo.project.annotation.AuthCheck;
import com.demo.project.common.BaseResponse;
import com.demo.project.common.ErrorCode;
import com.demo.project.common.ResultUtils;
import com.demo.project.exception.BusinessException;
import com.demo.project.listener.ProductExcelListener;
import com.demo.project.model.dto.product.ProductAddRequest;
import com.demo.project.model.dto.product.ProductExcel;
import com.demo.project.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.demo.project.constant.UserConstant.ADMIN_ROLE;

/**
 *  商品接口
 *
 * @author hzzzzzy
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 创建商品
     *
     * @param productAddRequest
     * @return
     */
    @AuthCheck(mustRole = ADMIN_ROLE)
    @PostMapping("/addProduct")
    public BaseResponse<Long> addProduct(@RequestBody ProductAddRequest productAddRequest, HttpServletRequest request) {
        if (productAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long userId = productService.addProduct(productAddRequest,request);
        return ResultUtils.success(userId);
    }


    /**
     * 通过excel批量导入商品信息
     *
     */
    @SneakyThrows
    @PostMapping("upload")
    @ResponseBody
    public BaseResponse<String> upload(MultipartFile file){
        EasyExcel.read(file.getInputStream(), ProductExcel.class, new ProductExcelListener(productService)).sheet().doRead();
        return ResultUtils.success("导入成功");
    }
}
