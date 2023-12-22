package springboot.service.impl;

import springboot.dto.request.CategoryRequest;
import springboot.dto.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
    CategoryResponse create(CategoryRequest categoryRequest);
    CategoryResponse update(CategoryRequest categoryRequest,Long id);
    String lock(Long id);
}
