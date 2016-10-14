#变长数组
##一、说明
###实验介绍
变长数组实现无限存储
##二、抽象数据类型
##三、接口设计
```
public interface ArrayListInterface {
    /*添加元素*/
    void pushBack(int num);
    /*删除第i个元素*/
    boolean delete(int i);
    /*修改第i个元素为num*/
    boolean change(int i,int num);
    /*返回第i个元素*/
    int numberAt(int i);
    /*返回当前元素个数*/
    int getCount();
}
```
##四、类设计
```
public class ArrayList {
 
    /*测试代码 */
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.pushBack(10);
        l.pushBack(20);
        l.pushBack(30);
        l.pushBack(40);
        l.pushBack(50);
        l.pushBack(60);
        l.pushBack(70);
        l.pushBack(80);
        l.delete(6);
        l.change(1, 200);
        for (int i = 0; i < l.getCount(); i++) {
            System.out.print(l.numberAt(i)+" ");
        }
    }
}
```
输出结果应为：`10 200 30 40 50 60 80`
##五、参考答案
##六、总结与拓展练习
