package com.epicode.Spring.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.Spring.security.entity.Device;

public interface IDevicePaginationRepository extends PagingAndSortingRepository<Device, Long>{

}
