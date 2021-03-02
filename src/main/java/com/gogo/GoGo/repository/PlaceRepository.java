package com.gogo.GoGo.repository;

import com.gogo.GoGo.domain.Place;
import com.gogo.GoGo.enumclass.PlaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,Long> {

    void deleteByCommunityId(Long communityId);

//    @Query(value = "select place.communityId from Place place where place.name = :name")
    List<Place> findByName(PlaceStatus name);
}
