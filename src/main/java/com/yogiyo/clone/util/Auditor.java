package com.yogiyo.clone.util;

import com.yogiyo.clone.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class Auditor implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
//        log.info("[Auditor 실행]");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        log.info("[principal is null? {}]", principal == null);
        if (principal instanceof UserDetailsImpl) {
            Long id = ((UserDetailsImpl) principal).getUser().getId();
            return Optional.of(id);
        }

        return Optional.empty();
    }
}
