package springboot_ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import springboot_ssmp.pojo.Book;


@Repository
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
