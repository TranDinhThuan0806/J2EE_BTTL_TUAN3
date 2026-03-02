package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    
    private List<Category> listCategory = new ArrayList<>();

    // Constructor này sẽ tự động chạy khi Spring Boot khởi tạo Service
    // Nó giúp tạo sẵn 2 danh mục mặc định theo đúng yêu cầu đề bài
    public CategoryService() {
        listCategory.add(new Category(1, "Điện thoại"));
        listCategory.add(new Category(2, "Laptop"));
    }

    /**
     * Lấy toàn bộ danh sách danh mục.
     * Hàm này được dùng để truyền dữ liệu ra form, hiển thị trên Dropdown List.
     */
    public List<Category> getAll() {
        return listCategory;
    }

    /**
     * Tìm kiếm một danh mục dựa vào ID.
     * Hàm này được dùng khi lưu sản phẩm: Controller nhận ID từ dropdown list, 
     * gọi hàm này để lấy đúng đối tượng Category và gán vào Product.
     */
    public Category get(int id) {
        return listCategory.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}