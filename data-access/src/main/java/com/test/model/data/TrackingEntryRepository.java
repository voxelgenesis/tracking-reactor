package com.test.model.data;

import org.springframework.data.repository.CrudRepository;

import com.test.model.TrackingEntry;

public interface TrackingEntryRepository extends CrudRepository<TrackingEntry, Long> {

}
