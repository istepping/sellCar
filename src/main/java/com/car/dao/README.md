 @author 孙磊
 @time 2018/7/12
 @note dao层功能设计
# 数据库访问层 访问功能设计
1. CarMapper :查看(id,全部),增加,删除,修改
2. UserMapper :查看(id),增加,注销,修改个人信息
3. ManagerMapper :查看(id),增加,注销,修改个人信息
4. OrderMapper: 查看(id，全部),增加,删除,修改.
5. CollectionMapper: 收藏信息表(用户下次登陆后能够保留用户收藏信息):增加,取消，通过用户id查看收藏 
6. ImageMapper: 查询其它图片.