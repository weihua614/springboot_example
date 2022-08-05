package springboot_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_ssmp.controller.util.Res;
import springboot_ssmp.pojo.Book;
import springboot_ssmp.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    private String resultString1="操作成功";
    private String resultString2="操作失败";


    /**
     * 通过书ID查询
     * @param id 书的ID
     * @return
     */
    @GetMapping("/{id}")
    public Res getBookById(@PathVariable("id") Integer id){
        Book book = bookService.getById(id);
        if(book==null||book.getId()==null) return new Res(false,null,resultString2);
        return new Res(true,bookService.getById(id),resultString1);
    }

    @GetMapping
    public Res getAllBooks(){ return new Res(true,bookService.list());
    }

//    @GetMapping("/page/{pageNum}/{pageSize}")
//    public Res getBooksByPage(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
////        Page<Book> bookPage = new Page<>(pageNum, pageSize);
////        bookService.page(bookPage);
//        IPage<Book> bookPage=bookService.getPages(pageNum,pageSize);
//        long totalPages=bookPage.getPages();
//        if(totalPages<pageNum)
//        {
//            bookPage.setCurrent(totalPages);
//            bookPage=bookService.getPages(pageNum,pageSize);
//        }
//        return new Res(true,bookPage,resultString1);
//    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public Res getBooksByPage(@PathVariable Integer pageNum,@PathVariable Integer pageSize,Book book){
        IPage<Book> bookPage=bookService.getPages(pageNum,pageSize,book);
        long totalPages=bookPage.getPages();
        if(totalPages<pageNum)
        {
            bookPage.setCurrent(totalPages);
            bookPage=bookService.getPages((int)totalPages,pageSize,book);
        }
        return new Res(true,bookPage,resultString1);
    }

    @PostMapping
    public Res save(@RequestBody Book book){
        boolean res = bookService.save(book);
        if(book.getName().equals("123")) throw new RuntimeException();
        return new Res(res,null,res?resultString1:resultString2);
    }

    @PutMapping
    public Res updateBook(@RequestBody Book book){
        Book seBook = bookService.getById(book.getId());
        if(seBook==null||seBook.getId()==null) return new Res(false,resultString2);
        boolean res = bookService.updateById(book);
        return new Res(res,null,res?resultString1:resultString2);
    }

    @DeleteMapping("/{id}")
    public Res deleteBook(@PathVariable() Integer id){
        boolean res = bookService.removeById(id);
        return new Res(res,null,res?resultString1:resultString2);
    }
}
