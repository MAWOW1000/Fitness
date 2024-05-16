package com.planfit.server.service;

import com.planfit.server.domain.Exercise;
import com.planfit.server.domain.User;
import com.planfit.server.dto.response.ExerciseGetAllResponse;
import com.planfit.server.repository.ExerciseRepository;
import com.planfit.server.repository.RoutineRepository;
import com.planfit.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExerciseService {

    private final UserRepository userRepository;
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;

    //운동 리스트 조회
    public ExerciseGetAllResponse findExercises(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();

        return ExerciseGetAllResponse.fromRoutines(routineRepository.findAllByUserOrderBySequenceAsc(user));
    }

    //전체 운동 리스트 조회
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }
}
