package cn.easybuy.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.User;


public interface UserMapper {
	public int add(User user);
	public int update(User user);
	public int delete(Integer id);
	public User selectById(Integer id);
	public User selectByName(String LoginName);
	public int count();
	public List<User> getUserList(
			  @Param("from")Integer currentPageNo,
			  @Param("pageSize")Integer pageSize);
}
