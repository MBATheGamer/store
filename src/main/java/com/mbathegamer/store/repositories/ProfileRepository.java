package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbathegamer.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
