package springboot_ssmp.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_ssmp.mapper.BookMapper;
import springboot_ssmp.pojo.Book;
import springboot_ssmp.service.IBookService;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public IPage<Book> getPages(Integer pageNum, Integer pageSize) {
        Page<Book> bookPage = new Page<>(pageNum,pageSize);
        bookMapper.selectPage(bookPage,null);
        return bookPage;
    }

    @Override
    public IPage<Book> getPages(Integer pageNum, Integer pageSize, Book book) {
        Page<Book> bookPage = new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper=new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(!StringUtils.isEmpty(book.getType()),Book::getType,book.getType());
        bookLambdaQueryWrapper.like(!StringUtils.isEmpty(book.getName()),Book::getName,book.getName());
        bookLambdaQueryWrapper.like(!StringUtils.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        bookMapper.selectPage(bookPage,bookLambdaQueryWrapper);
        return bookPage;
    }
}
