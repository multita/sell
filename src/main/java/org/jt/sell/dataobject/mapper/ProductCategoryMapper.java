package org.jt.sell.dataobject.mapper;

import org.apache.ibatis.annotations.*;
import org.jt.sell.dataobject.ProductCategory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject.mapper
 * @ClassName: ProductCategory
 * @Author: hjt
 * @Date: 2019/5/19 15:17
 * @Version: 1.0
 */


public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    @Insert("insert into product_category(category_name,category_type) values (#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type =#{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategory(Integer categoryType);

     ProductCategory selectByCategoryType(Integer categoryType);
}
