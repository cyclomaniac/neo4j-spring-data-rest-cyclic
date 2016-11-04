package com.example.repositories;

import com.example.domain.Player;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by vagrant on 11/4/16.
 */
public interface PlayerRepository extends GraphRepository<Player>{
}
