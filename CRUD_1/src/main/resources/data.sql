-- Insert initial data for Student
INSERT INTO student (name) VALUES ('John Doe');
INSERT INTO student (name) VALUES ('Jane Smith');

-- Insert initial data for Teacher
INSERT INTO teacher (name) VALUES ('Mr. Anderson');
INSERT INTO teacher (name) VALUES ('Ms. Johnson');

-- Define some relationships between Students and Teachers
INSERT INTO student_teacher (student_id, teacher_id) VALUES (1, 1);
INSERT INTO student_teacher (student_id, teacher_id) VALUES (2, 2);