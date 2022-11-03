package com.lhwl.wzk.jpa.listener;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
* @author mrli
* @description JPA通过AuditorAware<T>接口获取用户信息,
* @date 2022/11/2
**/
@Component
public class UserNameAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("123");
    }
}
