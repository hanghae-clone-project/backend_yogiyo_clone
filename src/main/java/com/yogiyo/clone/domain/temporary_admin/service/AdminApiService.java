package com.yogiyo.clone.domain.temporary_admin.service;

import com.yogiyo.clone.domain.temporary_admin.dto.*;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiMenuRepository;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminApiService {

    private final AdminApiRepository adminApiRepository;
    private final AdminApiMenuRepository adminApiMenuRepository;

    @Transactional
    public List<AdminMenuResponseDto> getMenuList() {
        List<Store> stores = adminApiRepository.findAll();
        List<AdminMenuResponseDto> dto = new ArrayList<>();

        for (Store store : stores) {
            dto.add(new AdminMenuResponseDto(store));
        }

        return dto;
    }

    @Transactional
    public StoreAddResponseDto addStore(StoreAddRequestDto dto) {
        Store store = adminApiRepository.saveAndFlush(new Store(dto));
        return new StoreAddResponseDto(store);
    }

    @Transactional
    public MenuAddResponseDto addMenu(Long id, MenuAddRequestDto dto) {
        Store store = adminApiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("상점 없음"));

        Menu menu = new Menu(dto, store);
        adminApiMenuRepository.save(menu);

        return new MenuAddResponseDto(menu);
    }
}
