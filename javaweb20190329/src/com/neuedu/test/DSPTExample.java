package com.neuedu.test;

public class DSPTExample {
    /**
     * 电商平台
     *  1：数据库
     *     用户表--- 管理员：后台管理系统
     *           --- 会员：买商品的
     *            t_user:uid uname upwd telephone address level(等级0 ：管理员 1：会员)
     *     商品表
     *           分类：
     *               t_category: cid, cname pid（0：第一层 ）ifleaf(0 叶子，1 枝)
     *           商品：
     *             t_good：gid,gnum(商品编号，人为进行编号),gname,gprice,gstock,gsell,gdesc
     *
     *     购物车
     *            t_shoppingcart：sid，gid,uid,num
     *     订单
     *          t_order:oid,ifpay,pdate,ifdelivery,ddate,iffinish,fdate
     *          t_orderdetail:odid,oid,gid,gname,uid,uname,num,price,
     *
     *  2：jdbc
     *     1）数据库的连接和封装导入为jar包
     *     2）jar 进行导入
     *     3） 测试
     *     注意：现在我们操作的javaweb ：jar包要随项目发布到网站上
     *          jar包放在lib中（WEB-INF---》lib：项目所需的jar都放入在里）
     *  3：实体类创建
     *     数据库中表---类 entity Javabeen pojo
     *  4：dao---对数据库表的操作
     *       dao接口
     *       dao实现类
     *        测试
     *  5：网页
     *     list:显示所有数据
     *     add：添加数据
     *     update:修改数据
     *  6：servlet ：将dao的结果放到页面或者网页的数据存放数据库中
     *
     *     一般情况：对每个表的操作，使用给一个servlet
     *     一个servlet实现多个功能
     *     1：每个要实现功能，使用方法封装一下
     *              方法名：提交处理的文件相同
     *         方法： public void 方法名（HttpServletRequest req，HttpServletResponse resp） throws ServletException ，IOException{
     *                 功能
     *         }
     *     2：如何调用方法
     *         add.user  update.user delete.user list.user
     *        1） doGet |doPost
     *        2）怎么调用
     *         a： req.getRequestURI  找到url资源路径
     *             /add.user /update.user
     *          b: 提取路径中文件名
     *             add update list 等  ---字符串的子串
     *
     *          c：匹配
     *          if("add".equals(path)){
     *              add(req,resp)
     *          }else if("list".equals(path)){
     *              list(req,resp)
     *          }.....
     *
     *
     *     list 功能完成了
     *     add：
     *     delete:
     *
     *     修改：1：找出这条记录的所有信息
     *           2：显示这些信息
     *           3：修改数据
     *           4：提交修改
     *           5：返回到list.user界面
     *
     */
}
