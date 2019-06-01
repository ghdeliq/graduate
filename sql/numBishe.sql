-- 2019-05-09 
-- 借助框架后的补充表

-- 创建表 course
CREATE TABLE sys_course
(
course_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '课程编号',
course_name VARCHAR(25) NOT NULL UNIQUE COMMENT '课程名',
course_textbook VARCHAR(30) COMMENT '课程使用教材',
textbook_price DOUBLE COMMENT '教材价格',
course_type INT NOT NULL COMMENT '课程类型(0：必修课; 1：限选课; 2：任选课)',
course_use BOOLEAN NOT NULL DEFAULT TRUE COMMENT '是否开设',
is_deleted BOOLEAN NOT NULL DEFAULT FALSE COMMENT '删除标志',
PRIMARY KEY(course_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


-- 创建表  教材变更记录
CREATE TABLE sys_textbook_change
(
tc_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '记录编号',
tc_course_id INT UNSIGNED NOT NULL  COMMENT '课程编号',
tc_old_textbook VARCHAR(30) NOT NULL COMMENT '旧教材',
tc_new_textbook VARCHAR(30) NOT NULL COMMENT '要更换的新教材',
tc_new_price DOUBLE NOT NULL COMMENT '新教材的价格',
tc_change_by VARCHAR(10) NOT NULL COMMENT '申请人(教师工号）loginName',
tc_up_time DATETIME NOT NULL  COMMENT '申请时间',
tc_check_by CHAR(10) COMMENT '审核人(管理员ID）',
tc_check_time DATETIME  COMMENT '审核时间',
tc_state INT NOT NULL DEFAULT 0 COMMENT '当前审核状态(0：提交，待审核;1：通过;2：驳回)',
PRIMARY KEY(tc_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '教材变更记录表';


-- 创建表 学生预定教材记录表
CREATE TABLE sys_stu_book_record
(
sbr_id INT NOT NULL AUTO_INCREMENT COMMENT '编号',
sbr_stu_id VARCHAR(20) NOT NULL COMMENT '学生学号',
sbr_course_id INT NOT NULL COMMENT '课程编号',
sbr_time DATETIME NOT NULL COMMENT '记录生成时间',
PRIMARY KEY(sbr_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '学生预定教材记录表';

-- 创建表 学生余额变更表
CREATE TABLE sys_balance_change
(
bc_id INT NOT NULL AUTO_INCREMENT COMMENT '流水ID',
stu_id VARCHAR(20) NOT NULL COMMENT '学生学号',
course_id INT NOT NULL COMMENT '课程编号',
change_type INT NOT NULL COMMENT '变更类型（0:订购，余额减少；1:取消，余额增加)',
new_balance DOUBLE NOT NULL COMMENT '现阶段余额(允许负值)',
PRIMARY KEY(bc_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '学生余额变更表';

-- 创建表 课程-班级对应表
CREATE TABLE sys_course_class
(
cc_id INT  NOT NULL AUTO_INCREMENT COMMENT '编号',
course_id INT  NOT NULL COMMENT '课程编号',
class_id INT NOT NULL COMMENT '班级编号(对应用户表里的dept_id)',
cc_semester VARCHAR(15) NOT NULL COMMENT '学期(2019春)',
PRIMARY KEY(cc_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '课程-班级对应表';


-- 创建表 可订购教材时间
CREATE TABLE sys_canbook_time
(
can_id INT NOT NULL AUTO_INCREMENT COMMENT '编号',
can_start DATETIME NOT NULL  COMMENT '开始时间',
can_end DATETIME NOT NULL  COMMENT '结束时间',
can_use CHAR(5) NOT NULL COMMENT '是否使用',
can_update_time DATETIME NOT NULL  COMMENT '更新时间',
can_update_by VARCHAR(20) NOT NULL COMMENT '更新人',
create_time DATETIME NOT NULL  COMMENT '更新时间',
create_by VARCHAR(20) NOT NULL COMMENT '更新人',
can_type INT NOT NULL COMMENT '类型(0:订购教材时间; 1:教材更改时间)',
PRIMARY KEY(can_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 COMMENT '时间控制表';