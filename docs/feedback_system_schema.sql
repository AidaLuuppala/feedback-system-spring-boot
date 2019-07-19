CREATE DATABASE feedback_system_db WITH ENCODING 'UTF8' LC_COLLATE='fi_FI.UTF8' LC_CTYPE='fi_FI.UTF8' TEMPLATE=template0;

CREATE TABLE "feedback" (
	"feedback_id" serial NOT NULL,
	"feedback_date" DATE NOT NULL,
	"feedback_type" varchar(100) NOT NULL,
	"feedback_giver_type" varchar(100) NOT NULL,
	"feedback_topic" varchar(100) NOT NULL,
	"feedback_text" varchar(4000) NOT NULL,
	"feedback_status" varchar(100) NOT NULL,
	"wants_contact" BOOLEAN NOT NULL,
	"language" varchar(100) NOT NULL,
	"contact_firstname" varchar(50),
	"contact_lastname" varchar(50),
	"contact_email" varchar(100),
	"contact_mobile" varchar(15),
	CONSTRAINT "feedback_pk" PRIMARY KEY ("feedback_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "feedback_user" (
    	"id" serial NOT NULL,
    	"username" varchar(50) NOT NULL,
    	"password" varchar(500) NOT NULL,
    	"role" varchar(50) NOT NULL,
    	"user_firstname" varchar(50) NOT NULL,
    	"user_lastname" varchar(50) NOT NULL,
    	"department" varchar(100) NOT NULL,
    	CONSTRAINT "user_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);


/* test data to feedback_user table for login with username = username and password = password */
INSERT INTO feedback_user(username, password, role, user_firstname, user_lastname, department) VALUES ('username', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'ADMIN', 'Firstname', 'Lastname', 'Department');


