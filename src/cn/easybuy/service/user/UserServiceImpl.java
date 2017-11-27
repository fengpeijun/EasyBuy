package cn.easybuy.service.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.dao.user.UserMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.User;
import cn.easybuy.utils.MyBatisUtil;

public class UserServiceImpl implements UserService {

	@Override
	public boolean add(User user) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).add(user)>0) {
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
	public boolean update(User user) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).update(user)>0) {
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
	public boolean delete(Integer id) {
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).delete(id)>0) {
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
	public User selectById(Integer id) {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).selectById(id) != null) {
				user = sqlSession.getMapper(UserMapper.class).selectById(id);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			user=null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return user;
	}

	@Override
	public User selectByName(String loginName) {
		SqlSession sqlSession = null;
		User user = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).selectByName(loginName) != null) {
				user = sqlSession.getMapper(UserMapper.class).selectByName(loginName);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			user=null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return user;
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		SqlSession sqlSession = null;
	    List<User> user = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if (sqlSession.getMapper(UserMapper.class).getUserList(currentPageNo, pageSize) !=null) {
				user = sqlSession.getMapper(UserMapper.class).getUserList(currentPageNo, pageSize) ;
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			user = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return user;
	}

	@Override
	public int count() {
		SqlSession sqlSession = null;
		int count =0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(UserMapper.class).count();
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

}
