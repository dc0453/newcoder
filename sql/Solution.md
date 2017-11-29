* 查找最晚入职员工的所有信息

`select * from employees order by hire_date desc limit 1;`  


* 查找入职员工时间排名倒数第三的员工所有信息

`select * from employees order by hire_date desc limit 2, 1;`  

* 查找各个部门当前领导当前薪水详情以及其对应部门编号dept_no

```
应该注意先是salary为主，所以先查的是salaries
select s.emp_no, s.salary, s.from_date, s.to_date, dm.dept_no
from salaries s
inner join dept_manager dm
on dm.emp_no = s.emp_no 
where dm.to_date = '9999-01-01' and s.to_date = '9999-01-01';
```