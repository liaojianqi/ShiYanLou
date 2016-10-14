/*
 * 变长数组
 * */
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
