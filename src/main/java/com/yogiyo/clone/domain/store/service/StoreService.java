package com.yogiyo.clone.domain.store.service;

import com.yogiyo.clone.domain.store.dto.StoreListDto;
import com.yogiyo.clone.domain.store.dto.StoreResponseDto;
import com.yogiyo.clone.domain.store.repository.StoreRepository;
import com.yogiyo.clone.domain.temporary_admin.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    // 가게 단건 조회
    public StoreResponseDto getStore(Long storeId) {
        Store foundStore = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 가게가 없습니다.")
        );
        return new StoreResponseDto(foundStore);
    }

}