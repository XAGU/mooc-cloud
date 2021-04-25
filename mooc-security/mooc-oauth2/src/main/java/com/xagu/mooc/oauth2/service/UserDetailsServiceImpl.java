package com.xagu.mooc.oauth2.service;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.xagu.mooc.user.pojo.Power;
import com.xagu.mooc.user.pojo.Role;
import com.xagu.mooc.user.pojo.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

/**
 * @author xagu
 */

public class UserDetailsServiceImpl implements UserDetailsService {


    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //拿用户
        User user = jdbcTemplate
            .queryForObject("select * from user where username = ?", new String[]{s},
                new BeanPropertyRowMapper<>(User.class));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //获取当前用户的所有角色
        List<Role> roles = jdbcTemplate
            .query(
                "select * from role left join user_role ur on role.role_id = ur.role_id where ur.user_id = ?",
                new Integer[]{user.getUserId()}, new BeanPropertyRowMapper<>(Role.class));
        //获取所有角色的权限
        List<Power> powers = jdbcTemplate
            .query("select power.* from power left join role_power rp on power.power_id = rp.power_id where rp.role_id in (?)",
                roles.stream().map(Role::getRoleId).toArray(), new BeanPropertyRowMapper<>(Power.class));
        List<String> powerCode = powers.stream().filter(power -> !StringUtils.isEmpty(power.getPowerUrl())).map(Power::getPowerUrl)
            .collect(Collectors.toList());
        //构建oauth2的用户
        Set<String> authSet = new HashSet<>();
        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(item -> authSet.add("role_" + item.getRoleCode()));
            authSet.addAll(powerCode);
        }
        List<GrantedAuthority> authorityList = AuthorityUtils
            .createAuthorityList(authSet.toArray(new String[0]));
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.getEnable() == 1,
            true,
            true,
            user.getEnable() == 1,
            authorityList
        );
    }
}
