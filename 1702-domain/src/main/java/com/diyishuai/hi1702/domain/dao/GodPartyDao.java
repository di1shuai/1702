package com.diyishuai.hi1702.domain.dao;

import com.diyishuai.hi1702.domain.domain.GodParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GodPartyDao extends JpaRepository<GodParty, Long> {


//    @Query(value = "select gp1 from god_par gp1 inner join (select gp.party_id,gp.min(roll_taday) roll_taday from GodParty gp group by party_id) gp2 on gp1.party_id = gp2.party_id and gp1.roll_taday = gp2.roll_taday", nativeQuery = true)
    @Query(value = "select gp1.*" +
            "from god_party gp1 inner join (select" +
            "                               party_id," +
            "                               min(roll_taday) roll_taday" +
            "                             from god_party" +
            "                             group by party_id) gp2 on gp1.party_id = gp2.party_id and gp1.roll_taday = gp2.roll_taday",nativeQuery = true)
    public List<GodParty> getAllPartyMinRoll();

}