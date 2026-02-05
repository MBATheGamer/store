package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
