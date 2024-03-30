package com.example.uniquetriplets.controller;

import com.example.uniquetriplets.model.UniqueTriplets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UniqueTripletSumController {

    @PostMapping("/uniques")
    public ResponseEntity<?> findTriplets(@RequestBody UniqueTriplets request) {
        if (request == null || request.getNums() == null || request.getNums().length < 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid input: 'nums' array must contain at least 3 integers.");
        }

        int[] nums = request.getNums();
        int target = request.getTarget();

        try {
            List<List<Integer>> result = findTriplets(nums, target);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    private List<List<Integer>> findTriplets(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, sum = target - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
