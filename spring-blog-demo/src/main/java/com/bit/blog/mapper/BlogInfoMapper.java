package com.bit.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.blog.pojo.dataobject.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogInfoMapper extends BaseMapper<BlogInfo> {

}
