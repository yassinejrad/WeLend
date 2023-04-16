package com.pidev.welend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pidev.welend.entities.Reclaim;

public interface ReclaimRepo extends JpaRepository<Reclaim,Integer> {
	@Query (value= "SELECT DISTINCT reclaimid,agent_agentid,description,reclaim_type,reclaimstatus,client_clientid,response FROM `reclaim` r INNER JOIN `client` c ON r.client_clientid = c.clientid INNER JOIN `users` u ON c.user_name= u.username WHERE u.locked=0", nativeQuery =true)
	List<Reclaim>findReclaimByLockedUser();
}
