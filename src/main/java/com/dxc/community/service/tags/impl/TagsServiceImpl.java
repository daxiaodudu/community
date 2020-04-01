package com.dxc.community.service.tags.impl;

import com.dxc.community.dao.TagsMapper;
import com.dxc.community.pojo.Tags;
import com.dxc.community.pojo.TagsExample;
import com.dxc.community.service.tags.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: TagsServiceImpl <br>
 * date: 2020/4/1 11:34 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public List<Tags> getList() {

        TagsExample example = new TagsExample();
        return this.tagsMapper.selectByExample(example);
    }
}
