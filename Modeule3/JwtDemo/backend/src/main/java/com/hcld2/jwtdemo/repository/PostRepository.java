package com.hcld2.jwtdemo.repository;

import com.hcld2.jwtdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
   List<Post> findAllByOrderByCreatedAtDesc();

}
