package com.itheima.service.impl;

import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import com.itheima.service.BookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hm
 * @since 2024-04-29
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

}
