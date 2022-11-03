package com.lhwl.wzk.jpa.dao;


import com.lhwl.wzk.jpa.model.WzkCoureseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WzkCourseRepository extends JpaRepository<WzkCoureseEntity,Long> {

    @Override
    @EntityGraph(value = "wzkCoureseEntity.Graph",type = EntityGraph.EntityGraphType.FETCH)
    List<WzkCoureseEntity> findAll();

    /**
     * 防止n+1sql @EntityGraph
     * @param name
     * @return
     */
    @EntityGraph(value = "wzkCoureseEntity.Graph",type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "select w from WzkCoureseEntity w left join Student s on w.schoolName=s.schoolName where s.sname like :name%")
    List<WzkCoureseEntity> queryList(@Param("name") String name);
}
