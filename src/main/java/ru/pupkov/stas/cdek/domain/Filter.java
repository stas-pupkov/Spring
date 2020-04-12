package ru.pupkov.stas.cdek.domain;

import org.springframework.context.annotation.Condition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.MapAttribute;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static Specification<TaskForCalling> checkCompleted(Date dateStart) {
        return new Specification<TaskForCalling>() {
            @Override
            public Predicate toPredicate(Root<TaskForCalling> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate start = criteriaBuilder.greaterThan(root.get("date"), dateStart);
                //Predicate finish = criteriaBuilder.lessThan(root.get("date"), dateFinish);

                return start;



//                if (completed == false) {
//                    return criteriaBuilder.equal(root.get("completedTask"), false);
//                } else {
//                    return criteriaBuilder.equal(root.get("completedTask"), true);
//                }
//                return criteriaBuilder.lessThan(root.get("date"), date);




            }
        };
    }












//
//    private Date finish;
//    private TaskForCalling filter;
//
////    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
////        return criteriaBuilder.equal(root.get("date"), this.finish);
////    }
//
//    public Predicate toPredicate(Root<TaskForCalling> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        List<Predicate> predicates = new ArrayList<>();
//
//        if(filter.getDate() != null) {
//            predicates.add(criteriaBuilder.equal(root.get("date"), filter.getDate()));
//        }
//        if(predicates.isEmpty()){
//            predicates.add(criteriaBuilder.equal(root.get("date"), -1));
//        /*
//         I like to add this because without it if no criteria is specified then
//         everything is returned. Because that's how queries work without where
//         clauses. However, if my user doesn't provide any criteria I want to
//         say no results found.
//        */
//        }
//
//        return (Predicate) criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])))
//                .distinct(true).orderBy(criteriaBuilder.desc(root.get("date")));
//    }

}
