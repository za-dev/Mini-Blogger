package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jake on 5/9/17.
 */
public interface MessageRepo extends CrudRepository<Message, Integer> {
}
