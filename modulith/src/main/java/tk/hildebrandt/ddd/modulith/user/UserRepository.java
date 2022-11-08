package tk.hildebrandt.ddd.modulith.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, UserId> {

}
