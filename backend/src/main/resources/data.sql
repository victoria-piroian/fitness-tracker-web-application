


INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (1111, 'Michael', 'Scott', 49, 176.0, 170.0, '111');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (2222, 'Dwight', 'Schrute', 33, 180.0, 180.0, '222');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (3333, 'Jim', 'Halpert', 31, 175.0, 172.0, '333');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (4444, 'Pam', 'Beesly', 31, 158.0, 145.0, '444');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (5555, 'Kevin', 'Malone', 34, 175.0, 190.0, '555');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (6666, 'Andy', 'Bernard', 33, 177.0, 178.0, '666');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (7777, 'Ryan', 'Howard', 25, 169.0, 167.0, '777');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (8888, 'Angela', 'Martin', 34, 150.0, 130.0, '888');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (9999, 'Stanley', 'Hudson', 54, 178.0, 197.0, '999');
INSERT INTO UserProfile (clientId, firstName, lastName, age, height, weight, password) VALUES (1010, 'Kelly', 'Kapoor', 26, 159.0, 150.0, '101');


INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (1111, 1, 'December2,2022', 'arm day', 2.5, 3);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (1111, 2, 'December2,2022', 'yoga', 1, 4);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (2222, 1, 'December2,2022', 'leg day', 2, 5);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (2222, 1, 'December3,2022', 'cardio', 2.5, 2);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (2222, 2, 'December2,3033', 'yoga', 1.5, 5);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (3333, 1, 'December3,2022', 'arm day', 2, 3);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (3333, 2, 'December3,2022', 'yoga', 1.5, 4);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (4444, 1, 'December4,2022', 'leg day', 2.5, 4);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (5555, 1, 'November26,2022', 'arm day', 1, 1);
INSERT INTO Exercise (clientId, workoutId, dayYear, workoutName, duration, satisfaction) VALUES (6666, 1, 'December1,2022', 'cardio', 2, 2);


INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (1111, 'Breakfast', 'December2,2022', 'Eggs and toast', 300, 20.6, 34.5, 19.5, 12.7);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (1111, 'Lunch', 'December2,2022', 'Caprese sandwich', 361, 5.1, 32.5, 19.3, 16.7);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (1111, 'Dinner', 'December2,2022', 'Pad thai', 308, 8.2, 29, 16, 15);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (3333, 'Breakfast', 'November28,2022', 'Carrot muffin', 200, 11, 29.5, 4, 7.6);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (3333, 'Lunch', 'November28,2022', 'Grilled cheese', 291, 4, 27.9, 8.9, 16);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (5555, 'Breakfast', 'December4,2022', 'Waffles', 410, 30, 110, 16, 36);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (6666, 'Dinner', 'November30,2022', 'Tacos', 400, 1.4, 22.6, 22, 22.4);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (8888, 'Breakfast', 'December1,2022', 'Oatmeal', 143, 2, 25.6, 6, 2.5);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (8888, 'Lunch', 'December1,2022', 'Nachos', 236, 1, 21, 14, 12);
INSERT INTO Diet (clientId, mealType, dayYear, mealName, calories, sugar, carbs, protein, fat) VALUES (8888, 'Dinner', 'December1,2022', 'Pasta', 442, 1.6, 86.4, 16.2, 2.6);


INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (1111, 'December2,2022', 6.5, 4, true, true, 1);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (2222, 'December3,2022', 5, 4, true, true, 0);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (2222, 'December4,2022', 7, 4, false, false, 2);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (3333, 'December2,2022', 8.5, 4, true, true, 0);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (6666, 'November30,2022', 4, 4, false, false, 0);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (6666, 'December2,2022', 5.5, 4, false, true, 2);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (8888, 'November30,2022', 6.5, 4, true, false, 4);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (8888, 'December1,2022', 6, 4, true, true, 1);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (8888, 'December2,2022', 7, 4, false, true, 0);
INSERT INTO Sleep (clientId, dayYear, duration, restScore, dream, alarmWakeUp, numNaps) VALUES (8888, 'December3,2022', 7.5, 4, true, true, 2);


INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (1111, 1, 'I want to improve my sleep schedule and get over 6 hours more regularly.', 4, 'I have been going to bed a lot earlier and feel much more rested!');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (1111, 2, 'I want to eat a more balanced diet.', 2, 'I have been eating out a lot :(');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (2222, 1, 'I aim to do yoga twice this week.', 5, 'I did yoga three times this week!');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (4444, 1, 'I want to focus on cardio more at the gym.', 4, 'I have done a lot more cardio recently!');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (4444, 2, 'I aim to have protein shakes for breakfast this week.', 4, 'I had protein shakes three times this week');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (5555, 1, 'This week, I want to take fewer naps.', 4, 'I only took two naps this week');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (7777, 1, 'I want to wake up to my alarms everyday this week.', 2, 'I slept through my alarm yesterday and today.');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (8888, 1, 'I want to cook a balanced meal for dinner tonight.', 5, 'I made an amazing burrito bowl!');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (9999, 1, 'I aim to have longer workouts.', 4, 'My workout durations have been going up!');
INSERT INTO Progress(clientId, progressId, goal, progressScore, reflection) VALUES (9999, 2, 'I want to go start going to bed earlier.', 5, 'Success! I have been getting a lot more sleep!');