package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.itheima.common.AppHttpCodeEnum;
import com.itheima.common.ResponseResult;
import com.itheima.dto.WmLoginDto;
import com.itheima.entity.WmUser;
import com.itheima.mapper.WmUserMapper;
import com.itheima.service.WmUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.utils.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 自媒体用户信息表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2024-05-14
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser> implements WmUserService {

    @Override
    public ResponseResult login(WmLoginDto wmLoginDto) {
        //1.检查参数
        if (StringUtils.isBlank(wmLoginDto.getName()) || StringUtils.isBlank(wmLoginDto.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户名或密码为空");
        }
        //2.查询用户
        WmUser wmUser = getOne(Wrappers.<WmUser>lambdaQuery().eq(WmUser::getName, wmLoginDto.getName()).eq(WmUser::getPassword, wmLoginDto.getPassword()));
        if (wmUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST,"用户信息不存在");
        }
        //3.登录成功，返回用户信息和JWT数据
        Map<String, Object> map = new HashMap<>();
        String token = JWTUtil.getToken(wmUser.getId().longValue());
        map.put("token", JWTUtil.getToken(wmUser.getId().longValue()));
        wmUser.setPassword("");
        map.put("user", wmUser);
        return ResponseResult.okResult(map);
    }
}
