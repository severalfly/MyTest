create database db_examsystem;

create table `tb_teacher`(
	`teacher_id` varchar(20) NOT NULL default'',
	`passord` varchar(20) default NULL,
	PRIMARY KEY (teacher_id)
)

create table `tb_student`(
	student_id varchar(20) NOT NULL default '',
	passord varchar(20) default NULL,
	student_name varchar(20) default NULL,
	result int(11) default NULL,
	sclass varchar(20) default NULL,
	PRIMARY KEY (student_id)
)

create table `tb_subject`(
	subject_id int(11) NOT NULL auto_increment,
	subject_title varchar(255) default NULL,
	subject_option_a varchar(50) default NULL,
	subject_option_b varchar(50) default NULL,
	subject_option_c varchar(50) default NULL,
	subject_option_d varchar(50) default NULL,
	subject_answer varchar(1) default NULL,
	subject_parse text,
	PRIMARY KEY (subject_id)
)