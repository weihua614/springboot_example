package springboot_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import springboot_ssmp.mapper.BookMapper;
import springboot_ssmp.pojo.Book;

public interface IBookService extends IService<Book> {

    public IPage<Book> getPages(Integer pageNum,Integer pageSize);


    public IPage<Book> getPages(Integer pageNum,Integer pageSize,Book book);


}
