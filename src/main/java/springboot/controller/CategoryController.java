package springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.request.CategoryRequest;
import springboot.dto.response.CategoryResponse;

import springboot.service.impl.ICategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest categoryRequest){
      return new ResponseEntity<>(categoryService.create(categoryRequest), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryRequest categoryRequest,@PathVariable Long id){
        return new ResponseEntity<>(categoryService.update(categoryRequest,id), HttpStatus.OK);
    }

    @PatchMapping("/lock/{id}")
    public ResponseEntity<?> lock(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.lock(id), HttpStatus.OK);
    }
}
