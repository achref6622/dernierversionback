package com.tnt.bourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnt.bourse.entities.PortefeuillAction;
import com.tnt.bourse.entities.PortefeuillActionId;

public interface PortefeuilleActionRepository  extends JpaRepository<PortefeuillAction, PortefeuillActionId>{

}
