package com.cognizant.BankManagementSystem.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

import com.cognizant.BankManagementSystem.model.UserData;

public interface GCPUsersRepository extends DatastoreRepository<UserData, Long>{

}
