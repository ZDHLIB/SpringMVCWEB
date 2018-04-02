CREATE TABLE `book` (
  `book_id` varchar(32) NOT NULL COMMENT 'Book id',
  `name` varchar(100) NOT NULL COMMENT 'Book name',
  `number` int(11) NOT NULL COMMENT 'Book number',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB COMMENT='Book table';

INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
(uuid(), 'Book1', 10),
(uuid(), 'Book2', 10),
(uuid(), 'Book3', 10),
(uuid(), 'Book4', 10);

CREATE TABLE `appointment` (
  `appoint_id` varchar(64) NOT NULL COMMENT 'Appointment ID',
  `book_id` varchar(32) NOT NULL COMMENT 'Book ID',
  `student_id` varchar(10) NOT NULL COMMENT 'Student ID',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Appintment time' ,
  PRIMARY KEY (`appoint_id`,`book_id`,`student_id`),
  FOREIGN KEY (`book_id`) REFERENCES book(`book_id`),
  INDEX `AppintmentIndex` (`appoint_id`)
) ENGINE=InnoDB COMMENT='Appintment table'


INSERT INTO appointment (`appoint_id`, `book_id`, `student_id`) 
VALUES (uuid(), 'b4c00a04-3371-11e8-8339-4c3488ef', '333333')