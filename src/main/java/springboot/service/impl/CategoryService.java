package springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.dto.request.CategoryRequest;
import springboot.dto.response.CategoryResponse;
import springboot.entity.Category;
import springboot.repository.CategoryRepository;
import springboot.service.mapper.CategoryMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> findAll() {
        return null;
    }

    @Override
    public CategoryResponse findById(Long id) {
        return null;
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public CategoryResponse update(CategoryRequest categoryRequest, Long id) {
        return null;
    }

    @Override
    public String lock(Long id) {
        return null;
    }
//    private final CategoryMapper categoryMapper;
//    @Override
//    public List<CategoryResponse> findAll() {
//        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).collect(Collectors.toList());
//    }
//
//    @Override
//    public CategoryResponse findById(Long id) {
//        return categoryMapper.toResponse(categoryRepository.findById(id).get());
//    }
//
//    @Override
//    public CategoryResponse create(CategoryRequest categoryRequest) {
//        return categoryMapper.toResponse(categoryRepository.save(categoryMapper.toEntity(categoryRequest)));
//    }
//
//    @Override
//    public CategoryResponse update(CategoryRequest categoryRequest, Long id) {
//        Category category = categoryMapper.toEntity(categoryRequest);
//        category.setId(id);
//        return categoryMapper.toResponse(category);
//    }
//
//    @Override
//    public String lock(Long id) {
//        Category category = categoryRepository.findById(id).get();
//        if (category != null) {
//            category.setStatus(!category.isStatus());
//            categoryRepository.save(category);
//            return "Khóa thành công";
//        }
//        return null;
//    }
}
