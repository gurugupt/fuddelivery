package com.fuddelivery.repo;

import com.fuddelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User , Long> {

    @Query(value = "SELECT * FROM user WHERE email=?1",nativeQuery = true)
    User findByEmailOrUserName(String email);


    @Query(value = "SELECT * FROM user WHERE otp=?1" , nativeQuery = true)
    User findByOTP(Integer otp);

    @Query(value = "SELECT * FROM user WHERE email=?1" , nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE email=?1 OR username=?2 " , nativeQuery = true)
    Optional<User> findByUsernameOrEmail(String email);

    @Query(value = "SELECT * FROM `user` WHERE referralCode = ?1" , nativeQuery = true)
    User findUserByReferralCode(String referralCode);

    @Query(value = "SELECT  ur.guyWhoReferrerCode_id FROM `user` u RIGHT JOIN user_referrals ur ON u.id = ur.guyWhoSignup_id = ?1" , nativeQuery = true)
    Long findUserWhoSignUp(long userId);

//    @Query(value = "SELECT  ur.guyWhoReferrerCode FROM `user` u RIGHT JOIN user_referrals ur ON u.id = ur.guyWhoSignup_id = ?1" , nativeQuery = true)
//    Long findUserWhoSignUp(long userId);
}
