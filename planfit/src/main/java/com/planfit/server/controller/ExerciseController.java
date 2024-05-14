package com.planfit.server.controller;

import com.planfit.server.common.ApiResponseUtil;
import com.planfit.server.common.BaseResponse;
import com.planfit.server.common.message.SuccessMessage;
import com.planfit.server.dto.request.ExerciseFindAllDto;
import com.planfit.server.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.path}")
public class ExerciseController {

    private final ExerciseService exerciseService;

    //운동 리스트 조회
    @GetMapping("/exercises")
    public ResponseEntity<BaseResponse<?>> exercisesList(@RequestHeader Long userId) {
        List<ExerciseFindAllDto> exercises = exerciseService.findExercises(userId);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("exercises", exercises);
        return ApiResponseUtil.success(SuccessMessage.EXERCISES_FIND_SUCCESS, responseData);
    }
}
