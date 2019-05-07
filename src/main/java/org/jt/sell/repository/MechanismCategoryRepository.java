package org.jt.sell.repository;

import org.jt.sell.dataobject.MechanismCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: MechanismCategoryRepository
 * @Author: hjt
 * @Date: 2019/5/6 16:45
 * @Version: 1.0
 */
public interface MechanismCategoryRepository extends JpaRepository<MechanismCategory,Integer> {

    List<MechanismCategory> findByFatherType(Integer fatherType);
    MechanismCategory findByCategoryType(Integer categoryType);

}
