package com.yogiyo.clone.domain.store.service;

import com.yogiyo.clone.domain.store.dto.StoreListDto;
import com.yogiyo.clone.domain.store.repository.StoreRepository;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import com.yogiyo.clone.domain.temporary_admin.repository.AdminApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    // 가게 전체 조회
    public List<StoreListDto> getStoreList() {
        ArrayList<StoreListDto> storeListDto = new ArrayList<>();
        List<Store> storeList = storeRepository.findAll();
        for (Store store : storeList) {
            storeListDto.add(new StoreListDto(store));
        }
        return storeListDto;
    }


}
