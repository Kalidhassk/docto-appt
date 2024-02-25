package com.tgpc.doctoappt.user.repository;

import com.tgpc.doctoappt.user.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
}
