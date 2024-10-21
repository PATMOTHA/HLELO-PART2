/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerandlogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class TaskDetails {
    private int taskNumber; // To keep track of the task numbers

    public TaskDetails() {
        this.taskNumber = 0; // Initialize task number
    }

    public void Application() {
        boolean exit = false;
        List<Map<String, String>> tasks = new ArrayList<>();

        while (!exit) {
            String menu = "Choose an option:\n1) Add tasks\n2) Show report\n3) Quit";
            String choice = JOptionPane.showInputDialog(menu);

            switch (choice) {
                case "1":
                    addTasks(tasks);
                    break;
                case "2":
                    showReport();
                    break;
                case "3":
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please select a valid option.");
            }
        }
    }

    public void addTasks(List<Map<String, String>> tasks) {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Map<String, String> task = new HashMap<>();
            
            // Task Name
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            task.put("Task Name", taskName);
            
            // Task Number
            task.put("Task Number", String.valueOf(taskNumber));
            
            // Task Description
            String taskDescription;
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                if (taskDescription.length() > 50) {
                    JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                }
            } while (taskDescription.length() > 50);
            task.put("Task Description", taskDescription);
            JOptionPane.showMessageDialog(null, "Task successfully captured");

            // Developer Details
            String developerFirstName = JOptionPane.showInputDialog("Enter developer's first name:");
            String developerLastName = JOptionPane.showInputDialog("Enter developer's last name:");
            String developerFullName = developerFirstName + " " + developerLastName;
            task.put("Developer Details", developerFullName);

            // Task Duration
            String taskDuration = JOptionPane.showInputDialog("Enter task duration in hours:");
            task.put("Task Duration", taskDuration);

            // Task ID
            String taskID = generateTaskID(taskName, taskNumber, developerLastName);
            task.put("Task ID", taskID);

            // Display the Task ID to the user
            JOptionPane.showMessageDialog(null, "Task ID: " + taskID);

            // Task Status
            String[] statuses = {"To Do", "Done", "Doing"};
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose task status:", "Task Status",
                                JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
            task.put("Task Status", taskStatus);

            tasks.add(task);
            taskNumber++; // Increment task number for the next task
        }
    }

    public String generateTaskID(String taskName, int taskNumber, String developerLastName) {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        String taskNumberPart = String.valueOf(taskNumber);
        String developerLastNamePart = developerLastName.length() >= 3 ? developerLastName.substring(developerLastName.length() - 3) : developerLastName;
        return (taskNamePart + ":" + taskNumberPart + ":" + developerLastNamePart).toUpperCase();
    }

    private void showReport() {
        JOptionPane.showMessageDialog(null, "Coming Soon");
    }

}