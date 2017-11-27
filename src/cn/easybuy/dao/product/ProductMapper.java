package cn.easybuy.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.Product;

public interface ProductMapper {
	public int add(Product product);
	public int update(Product product);
	public int deleteProductById(Integer id);
	public Product getProductById(Integer id);
	public int count();
	public List<Product> getProductList(@Param("currentPageNo")Integer currentPageNo,@Param("pageSize")Integer pageSize);
	public int updateStock(Integer productId, Integer stock);
}
