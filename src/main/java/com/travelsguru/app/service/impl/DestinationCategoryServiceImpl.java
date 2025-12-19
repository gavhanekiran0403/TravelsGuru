package com.travelsguru.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelsguru.app.dto.DestinationCategoryDto;
import com.travelsguru.app.exception.ResourceNotFoundException;
import com.travelsguru.app.mapper.DestinationCategoryMapper;
import com.travelsguru.app.model.DestinationCategory;
import com.travelsguru.app.repository.DestinationCategoryRepository;
import com.travelsguru.app.service.DestinationCategoryService;

@Service
public class DestinationCategoryServiceImpl implements DestinationCategoryService {

    @Autowired
    private DestinationCategoryRepository categoryRepository;

    @Autowired
    private DestinationCategoryMapper categoryMapper;

    @Override
    public DestinationCategoryDto createDestinationCategory(DestinationCategoryDto categoryDto) {
        DestinationCategory category = categoryMapper.dtoToEntity(categoryDto);
        DestinationCategory saved = categoryRepository.save(category);
        return categoryMapper.entityToDto(saved);
    }

    @Override
    public DestinationCategoryDto updateDestinationCategory(String destiCategoryId, DestinationCategoryDto categoryDto) {
        DestinationCategory category = categoryRepository.findById(destiCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DestinationCategory", "categoryId", destiCategoryId));

        category.setDestiCategoryName(categoryDto.getDestiCategoryName());

        return categoryMapper.entityToDto(categoryRepository.save(category));
    }

    @Override
    public DestinationCategoryDto getDestinationCategoryById(String destiCategoryId) {
        DestinationCategory category = categoryRepository.findById(destiCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DestinationCategory", "categoryId", destiCategoryId));
        return categoryMapper.entityToDto(category);
    }

    @Override
    public List<DestinationCategoryDto> getAllDestinationCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDestinationCategory(String destiCategoryId) {
        DestinationCategory category = categoryRepository.findById(destiCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DestinationCategory", "categoryId", destiCategoryId));
        categoryRepository.delete(category);
    }
}
