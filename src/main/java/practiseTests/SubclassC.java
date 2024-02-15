package practiseTests;

public class SubclassC {
    public int c;

    public void setC(int c){
        this.c=c;
    }

    public static void main(String args[]){
        SubclassB obj=new SubclassB();
        System.out.println(obj);
        System.out.println(new SubclassB());
    }
}
