package ru.pupkov.stas.cdek.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;

public class FilterByDateFinish {

    public static Specification<TaskForCalling> filterByDateFinish(Date dateFinish) {
        return new Specification<TaskForCalling>() {
            @Override
            public Predicate toPredicate(Root<TaskForCalling> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate finish = criteriaBuilder.lessThan(root.get("orderCreationTime"), dateFinish);
                return finish;
            }
        };
    }
}
