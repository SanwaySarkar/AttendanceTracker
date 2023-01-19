package com.fussiya.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fussiya.attendance.model.Tutorial;


public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContaining(String title);
  
  //@Modifying
  //@Query("update User u set u.active = false where u.lastLoginDate < :date")
  //void deactivateUsersNotLoggedInSince(@Param("date") String date);
  
  @Query(value ="select * from Tutorial u where u.description LIKE %?1% ",nativeQuery = true)
  List<Tutorial> getAllTutorialsbyDescription(String description);
  
  @Query(value ="select * from Tutorial u where u.classes = ?1 ",nativeQuery = true)
  List<Tutorial> getAllTutorialsbyClasses(Integer description);

}
