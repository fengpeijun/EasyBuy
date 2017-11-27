package cn.easybuy.service.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.dao.user.UserMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

public class ProductServiceImpl implements ProductService {

	@Override
	public boolean add(Product product) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).add(product)>0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag=false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean update(Product product) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).update(product)>0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag=false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).deleteProductById(productId)>0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag=false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public Product getProductById(Integer productId) {
		SqlSession sqlSession = null;
		Product pro = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).getProductById(productId)!=null) {
				pro = sqlSession.getMapper(ProductMapper.class).getProductById(productId);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			pro = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return pro;
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,
			Integer pageSize) {
		SqlSession sqlSession = null;
		 List<Product> pro = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).getProductList(currentPageNo, pageSize) !=null) {
				pro = sqlSession.getMapper(ProductMapper.class).getProductList(currentPageNo, pageSize) ;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			pro = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return pro;
	}

	@Override
	public int count(String proName, Integer categoryId, Integer level) {
		SqlSession sqlSession = null;
		int count =0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(ProductMapper.class).count();
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			count =0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return count;
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(ProductMapper.class).updateStock(productId,stock)>0) {
				flag = true;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag=false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

}
