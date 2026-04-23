package com.itheima.controller;

import com.itheima.entity.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hm
 * @since 2024-04-29
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @ResponseBody
    @RequestMapping("/findAllBooks")
    public List<Book> findAllBooks(){
        List<Book> allBooks = bookService.findAllBooks();
        return allBooks;
    }
}
