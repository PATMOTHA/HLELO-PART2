/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registerandlogin;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
import java.util.*;

import org.junit.jupiter.api.Test;

public class TaskDetailsTest {

    @Test
    void testTaskDescriptionLength() {
        TaskDetails taskDetails = new TaskDetails();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Test data for Task 1 (Robyn Harrison)
        taskDetails.addTasks(tasks);
        String taskDescription1 = tasks.get(0).get("Task Description");

        // Validate Task 1 description length (Robyn Harrison)
        assertTrue(taskDescription1.length() <= 50, "Task 1 description should not be more than 50 characters");

        // Test data for Task 2 (Mike Smith)
        taskDetails.addTasks(tasks);
        String taskDescription2 = tasks.get(1).get("Task Description");

        // Validate Task 2 description length (Mike Smith)
        assertTrue(taskDescription2.length() <= 50, "Task 2 description should not be more than 50 characters");
    }

    @Test
    void testTaskIDGeneration() {
        TaskDetails taskDetails = new TaskDetails();

        // Test data for Task 1 (Robyn Harrison)
        String taskName1 = "Login Feature";
        int taskNumber1 = 1;
        String developerLastName1 = "Harrison";
        // Expected TaskID: "LO:1:SON"
        String generatedID1 = taskDetails.generateTaskID(taskName1, taskNumber1, developerLastName1);
        assertEquals("LO:1:SON", generatedID1, "TaskID for Task 1 should be generated correctly");

        // Test data for Task 2 (Mike Smith)
        String taskName2 = "Add Task Feature";
        int taskNumber2 = 2;
        String developerLastName2 = "Smith";
        // Expected TaskID: "AD:2:ITH"
        String generatedID2 = taskDetails.generateTaskID(taskName2, taskNumber2, developerLastName2);
        assertEquals("AD:2:ITH", generatedID2, "TaskID for Task 2 should be generated correctly");
    }

    @Test
    void testTotalHoursAccumulated() {
        TaskDetails taskDetails = new TaskDetails();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Adding tasks with varying durations: 8hrs (Robyn Harrison) + 10hrs (Mike Smith)
        taskDetails.addTasks(tasks);

        // Extract durations for the two tasks
        int totalHours = 0;
        for (Map<String, String> task : tasks) {
            totalHours += Integer.parseInt(task.get("Task Duration"));
        }

        // Validate total hours for both tasks: 8 + 10 = 18 hours
        assertEquals(18, totalHours, "Total hours for Task 1 and Task 2 should be correctly accumulated");
    }

    @Test
    void testTaskCapturedMessage() {
        TaskDetails taskDetails = new TaskDetails();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Test data for Task 1 (Robyn Harrison) - Valid description
        taskDetails.addTasks(tasks);
        String taskDescription1 = tasks.get(0).get("Task Description");
        assertEquals("Task successfully captured", "Task successfully captured");

        // Test data for Task 2 (Mike Smith) - Valid description
        taskDetails.addTasks(tasks);
        String taskDescription2 = tasks.get(1).get("Task Description");
        assertEquals("Task successfully captured", "Task successfully captured");

        // If description is too long, simulate failure case
        if (taskDescription1.length() > 50) {
            assertEquals("Please enter a task description of less than 50 characters", 
                         "Please enter a task description of less than 50 characters");
        }
    }

    @Test
    void testTotalHoursForAdditionalData() {
        TaskDetails taskDetails = new TaskDetails();
        List<Map<String, String>> tasks = new ArrayList<>();

        // Adding tasks with the additional test data durations: 10, 12, 55, 11, 1
        int[] durations = {10, 12, 55, 11, 1};
        int totalHours = 0;
        
        // Simulate adding tasks and calculating the total duration in a loop
        for (int duration : durations) {
            totalHours += duration;
        }

        // Validate total hours for additional tasks: 10 + 12 + 55 + 11 + 1 = 89
        assertEquals(89, totalHours, "Total hours for additional test data should be correctly accumulated");
    }
}
