package org.codesquad.repository;

import org.codesquad.domain.Major;

import java.util.List;

public interface MajorRepository {

    List<Major> findAll();

    Major findById(String majorId);

    Major save(Major major);

    void update(Major major);

    void remove(Major major);
}
