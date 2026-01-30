# Vida Fit: Personal Fitness Tracking Web Application

## Description
Vida Fit is a web-based health and fitness tracking application designed to help users monitor and improve their diet, sleep, and exercise habits. Users can set personal goals, track their progress, and access resources to support healthier lifestyle choices.

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Requirements](#requirements)
4. [Architecture & Design](#architecture--design)
5. [Installation & Setup](#installation--setup)
6. [Usage](#usage)
7. [Testing](#testing)
8. [Future Improvements](#future-improvements)
9. [References](#references)

## Overview
Vida Fit addresses the need for accessible health tracking tools for young adults, particularly post-secondary students. Users can log meals, exercise, and sleep, while tracking overall progress toward wellness goals. The web app was designed to be intuitive, easy to navigate, and accessible on both laptops and mobile devices.

## Features
- **User Profile Management:** Create, update, and delete user profiles.
- **Diet Tracking:** Log, edit, and remove meals with nutritional information.
- **Exercise Tracking:** Record workouts, duration, and satisfaction levels.
- **Sleep Tracking:** Monitor sleep duration, rest quality, naps, and other sleep factors.
- **Progress Goals:** Set, update, and reflect on personal health goals.
- **Search & Filter:** Easily find past entries for diet, exercise, sleep, or goals.
- **Resources Page:** Access guides, charts, and wellness information.
- **Responsive Design:** Works on laptops, tablets, and mobile devices.

## Requirements
**Functional Requirements**
- Add, update, view, and delete meals, exercises, sleep entries, and progress goals.
- Edit user profile information.
- Display information in a user-friendly interface.
- Provide search functionality for entries.

**Non-Functional Requirements**
- Web accessibility on Windows and Mac devices.
- Response time under 10 seconds.
- Consistent date formatting.
- Easy navigation and minimal error rates.

## Architecture & Design
- **Methodology:** Waterfall V-Model to ensure structured planning, development, and testing.
- **Architecture:** MVC (Model-View-Controller) design with SQL database storage.
- **UML Diagrams:** 
  - Use Case Diagram: Visualizes main interactions.
  - Class Diagram: Shows connections between User, Diet, Sleep, Exercise, and Progress.
  - State Chart Diagram: Tracks progress goal completion.
  - Sequence Diagram: Illustrates interactions for logging progress.
  - Activity Diagram: Models workflow for adding/editing/deleting sleep entries.

## Installation & Setup
1. Clone the repository:  
   ```bash
   git clone https://github.com/yourusername/vida-fit.git
   ```
2. Open the project in your preferred Java IDE.
3. Configure the SQL database using the provided .sql file.
4. Ensure JDBC dependencies are installed.
5. Run the web application locally and access it via your browser.

## Usage
1. Navigate to the corresponding pages for Diet, Exercise, Sleep, or Progress.
2. Use the "+" button to add new entries.
3. Use the "Edit" button to update or delete entries.
4. Track progress towards your personal wellness goals over time.

## Testing
- CRUD operations for each entity (User, Diet, Exercise, Sleep, Progress) were validated through unit tests.
- Manual testing was conducted via the front-end for operations not fully supported by automated tests.
- Performance, accessibility, and error rates were evaluated to ensure a user-friendly experience.

## Future Improvements
- Implement a login page to add security for users.
- Incorporate a food catalog to reduce manual entry time.
- Add weekly summaries of user progress and push notifications for motivation.
- Explore AI/ML functionality for personalized suggestions based on user activity.

---

## Author
Victoria Piroian

University of Toronto

Faculty of Applied Science & Engineering, 2022
