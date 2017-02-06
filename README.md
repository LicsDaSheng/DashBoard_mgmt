#项目介绍

    1.提供公司内部人员管理系统
    2.积分管理系统
    3.项目跟踪管理系统
    4.成本费用管理系统

#依赖库

    1. spring-boot-starter-web 
    2. spring-boot-starter-jpa-extra
    3. lombok

#数据库

    1. mysql
   
#TO-DO

    1.集成权限
    2.完成人员组织机构管理
    3.rest接口文档 swagger
    4.集成工作流
    
#数据库预制
    1.INSERT INTO dashboard.t_project (id,  description,project_name) VALUES
        (replace(uuid(),'-',''),"平安三期项目V4.0","平安三期V4.0" );