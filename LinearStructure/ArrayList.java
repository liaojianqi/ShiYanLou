public class ArrayList implements ArrayListInterface{
    public static final int INDEXOUTOFRANGE = -1;
    private int allSize = 0;       //实际内存长度
    private int usedSize = 0;      //当前已经使用的长度
    private int[] numbers = null;
    
    public ArrayList(){
        allSize = 5;
        usedSize = 0;
        numbers = new int[allSize];
    }
    @Override
    public void pushBack(int num) {
        if(usedSize == allSize){
            int[] tmpNumbers = new int[allSize*2];
            for (int i = 0; i < allSize; i++) {
                tmpNumbers[i] = numbers[i];
            }
            numbers = tmpNumbers;
            allSize *= 2;
        }
        numbers[usedSize++] = num;
    }

    @Override
    public boolean delete(int i) {
        if(i>=usedSize) return false;
        for (int j = i; j < usedSize-1; j++) {
            numbers[j] = numbers[j+1];
        }
        usedSize--;
        return true;
    }

    @Override
    public boolean change(int i, int num) {
        if(i>=usedSize) return false;
        numbers[i] = num;
        return false;
    }

    @Override
    public int numberAt(int i) {
        if(i>=usedSize) return INDEXOUTOFRANGE;
        return numbers[i];
    }
    @Override
    public int getCount() {
        return usedSize;
    }
    /*测试代码
     *输出结果应为:10 200 30 40 50 60 80 */
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