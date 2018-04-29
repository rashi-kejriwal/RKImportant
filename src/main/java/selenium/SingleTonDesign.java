package selenium;

public class SingleTonDesign {

    private SingleTonDesign(){

    }

    private static SingleTonDesign singleTonDesignInstance=new SingleTonDesign();

    public static SingleTonDesign getInstance()
    {

        return singleTonDesignInstance;
    }
}
