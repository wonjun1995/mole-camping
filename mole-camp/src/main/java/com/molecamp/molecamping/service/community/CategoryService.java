package com.molecamp.molecamping.service.community;

import com.molecamp.molecamping.entity.common.Category;
import com.molecamp.molecamping.repository.community.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> type_all() {
        return categoryRepository.findAll();
    }
}
