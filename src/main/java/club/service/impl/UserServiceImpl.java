package club.service.impl;

import club.dao.UserMapper;
import club.pojo.Admins;
import club.pojo.User;
import club.service.UserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper um;
    @Override
    public PageInfo<User> allUser(String userName ,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if(userName != null && !"".equals(userName)){
            wrapper.like("userName",userName);
        }

        List<User> list = um.selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int add(User user) {
        return um.insert(user);
    }

    @Override
    public int update(User user) {
        return um.updateById(user);
    }

    @Override
    public User findById(Integer id) {
        return um.selectById(id);
    }

    @Override
    public int del(Integer id) {
        return um.deleteById(id);
    }
}
