package com.demo.project.listener;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.demo.project.common.ErrorCode;
import com.demo.project.exception.BusinessException;
import com.demo.project.model.dto.product.ProductExcel;
import com.demo.project.model.entity.Product;
import com.demo.project.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import java.util.List;


/**
 * ProductExcelListener: EasyExcel 商品监听器
 */
@Slf4j
public class ProductExcelListener extends AnalysisEventListener<ProductExcel> {

    /**
     * 每隔5条存储数据库 然后清理list 方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    /**
     * 缓存的数据
     */
    private List<ProductExcel> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * SubjectExcelListener 不能交给Spring管理
     * 使用构造方法进行注入
     */
    public ProductService productService;
    public ProductExcelListener(){}
    public ProductExcelListener(ProductService productService) {
        this.productService = productService;
    }

    // 读取excel数据
    @Override
    public void invoke(ProductExcel productExcel, AnalysisContext analysisContext) {
        if(productExcel == null){
            throw new BusinessException(ErrorCode.OPERATION_ERROR,"该excel为空");
        }
        cachedDataList.add(productExcel);
        // 达到BATCH_COUNT，存储一次数据库
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 存储数据库
     */
    private void saveData() {
        cachedDataList.forEach(item->{
            Product product = new Product();
            BeanUtils.copyProperties(item,product);
            productService.save(product);
        });
        log.info("存储数据库成功！");
    }
}