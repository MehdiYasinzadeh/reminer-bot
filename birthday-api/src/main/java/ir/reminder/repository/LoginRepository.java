package ir.reminder.repository;

import ir.reminder.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoginRepository extends PagingAndSortingRepository<UserInfo, Long> {

    void save(UserInfo userInfo);
    boolean existsByNationalCode (String nationalCode);
    UserInfo findByEmail (String email);
    }
