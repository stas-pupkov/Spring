package ru.pupkov.stas.cdek.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;

public class FilterByDateStart {

    public static Specification<TaskForCalling> filterByDateStart(Date dateStart) {
        return new Specification<TaskForCalling>() {
            @Override
            public Predicate toPredicate(Root<TaskForCalling> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate start = criteriaBuilder.greaterThan(root.get("orderCreationTime"), dateStart);
                return start;
            }
        };
    }
}
