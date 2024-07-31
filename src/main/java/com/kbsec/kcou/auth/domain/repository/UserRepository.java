package com.kbsec.kcou.auth.domain.repository;

import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default User getById(Long userId) {
        return findById(userId).orElseThrow(IllegalArgumentException::new);
    }

    boolean existsByPlatformAndPlatformId(Platform platform, String platformId);

    User getByPlatformAndPlatformId(Platform platform, String platformId);

}
