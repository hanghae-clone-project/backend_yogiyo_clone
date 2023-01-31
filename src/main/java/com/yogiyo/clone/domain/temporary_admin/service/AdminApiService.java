package com.yogiyo.clone.domain.temporary_admin.service;

import com.yogiyo.clone.domain.temporary_admin.dto.*;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.temporary_admin.entity.Menu;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiMenuRepository;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiRepository;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.repository.UserRepository;
import com.yogiyo.clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminApiService {

    private final AdminApiRepository adminApiRepository;
    private final AdminApiMenuRepository adminApiMenuRepository;
    private final UserRepository userRepository;

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
    public StoreAddResponseDto addStore(StoreAddRequestDto dto, Long user_id) {
        Users users = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        Store store = adminApiRepository.saveAndFlush(new Store(dto, users));
        return new StoreAddResponseDto(store);
    }

    @Transactional
    public MenuAddResponseDto addMenu(Long id, MenuAddRequestDto dto, Users users) {
        Store store = adminApiRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("상점 없음"));

        Menu menu = new Menu(dto, store, users);
        adminApiMenuRepository.save(menu);

        return new MenuAddResponseDto(menu);
    }

    @Transactional
    public List<StoreAddResponseDto> getStoreList(Users users) {
        List<StoreAddResponseDto> storeList = new ArrayList<>();
        List<Store> stores = adminApiRepository.findByUsers(users);
        for (Store store : stores) {
            storeList.add(new StoreAddResponseDto(store));
        }

        return storeList;
    }

    @Transactional
    public List<MenuAddResponseDto>  getAdminMenuList(Users users) {
        List<Menu> menus = adminApiMenuRepository.findByUserid(users.getId());
        List<MenuAddResponseDto> menuList = new ArrayList<>();
        for (Menu menu : menus) {
            menuList.add(new MenuAddResponseDto(menu));
        }

        return menuList;

    }

    @Transactional
    public void deleteMenu(Long menu_id) {
        Menu menu = adminApiMenuRepository.findById(menu_id).orElseThrow(() -> new IllegalArgumentException("가게가 없습니다."));
        adminApiMenuRepository.deleteByStoreAndId(menu.getStore(), menu_id);
    }
}
