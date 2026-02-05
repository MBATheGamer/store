package com.mbathegamer.store.services;

import org.springframework.stereotype.Service;

import com.mbathegamer.store.entities.Address;
import com.mbathegamer.store.entities.User;
import com.mbathegamer.store.repositories.AddressRepository;
import com.mbathegamer.store.repositories.ProfileRepository;
import com.mbathegamer.store.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final ProfileRepository profileRepository;
  private final EntityManager entityManager;

  @Transactional
  public void showEntityStates() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }

    userRepository.save(user);

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }
  }

  @Transactional
  public void showRelatedEntities() {
    var profile = profileRepository.findById(2L).orElseThrow();
    System.out.println(profile.getUser().getEmail());
  }

  public void fetchAddress() {
    addressRepository.findById(1L).orElseThrow();
  }

  public void persistRelated() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    var address = Address.builder()
        .street("street")
        .city("city")
        .state("state")
        .zip("zip")
        .build();

    user.addAddress(address);

    userRepository.save(user);
  }

  @Transactional
  public void deleteRelated() {
    // userRepository.deleteById(1L);

    var user = userRepository.findById(1L).orElseThrow();
    var address = user.getAddresses().getFirst();

    user.removeAddress(address);
    userRepository.save(user);
  }
}
