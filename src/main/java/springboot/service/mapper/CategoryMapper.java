package springboot.service.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import springboot.dto.request.CategoryRequest;
import springboot.dto.response.CategoryResponse;
import springboot.entity.Category;

@Mapper
@Component
public interface CategoryMapper {

    Category toEntity(CategoryRequest categoryRequest);

    CategoryResponse toResponse(Category category);
}
