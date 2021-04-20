package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.User;
import com.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void add() {
        User user = new User();
        user.setName("张三111");
        user.setAge(20);
        user.setEmail("1243@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void update() {
        User user = new User();
        user.setName("张三");
        user.setId(1384063960612892674L);
        user.setEmail("1243555@qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    @Test
    public void select(){
        Page<Map<String,Object>> page = new Page(2,3);

        Page<Map<String,Object>> page1 = userMapper.selectMapsPage(page,null);
        System.out.println(page1.getTotal());
        System.out.println(page1.getCurrent());
        System.out.println(page1.getRecords());
        System.out.println(page1.hasNext());
    }
    @Test
    public void delete(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三111");
        map.put("age",20);
       userMapper.deleteByMap(map);
    }

    @Test
    public void testQuery(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","Jone").ge("age",18).isNull("createtime");
        List<User> list = userMapper.selectList(queryWrapper);
        System.out.println(list);
    }

}
