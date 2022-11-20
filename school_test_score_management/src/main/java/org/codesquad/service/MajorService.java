package org.codesquad.service;

import org.codesquad.domain.Major;
import org.codesquad.repository.MajorRepository;

import java.util.List;

public class MajorService {

    private MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public List<Major> findAll() {
        return majorRepository.findAll();
    }
}
