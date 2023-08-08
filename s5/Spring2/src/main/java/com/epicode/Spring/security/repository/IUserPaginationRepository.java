package com.epicode.Spring.security.repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.Spring.security.entity.User;

public interface IUserPaginationRepository extends PagingAndSortingRepository<User, Long> {

}
