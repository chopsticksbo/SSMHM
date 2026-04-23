package com.itheima.service;

import com.itheima.entity.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hm
 * @since 2024-04-29
 */
public interface BookService extends IService<Book> {
    public List<Book> findAllBooks();
}
