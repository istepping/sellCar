# 枚举数据
1. 车类别 CarSortEnum String SUV:多功能越野车 NEV:新能源车 sportCar:跑车
2. 车状态 CarStateEnum int 1:正在发售 2:暂停发售 3:已被删除
3. 订单状态 OrderStateEnum int 1:下单成功 2:已取消 3.已付款 4.已签收 5.已完成
4. 用户状态 UserStateEnum int 1:正常用户(离线) 2.正常用户(在线) 3:已注销用户
5. 登陆状态 LoginStateEnum int 1:已登陆 2:已离线
6. 服务结果状态 ResultStateEnum 1.执行成功 -1.输入错误 -2.未登陆 -3.数据操作异常 -4.权限异常
7. 管理员权限 ManagerAuthorityEnum 1.低级权限 2.中级权限 3.顶级权限