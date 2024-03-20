package com.example.api.reporitory;

import com.example.api.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option,Integer> {

    Optional<Option> findOptionByTitle(String title);
}
