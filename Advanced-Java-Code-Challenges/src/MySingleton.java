public class MySingleton {

    private static MySingleton mySingleton;

    public String str;

    private MySingleton(){
        str = "My Singleton";
    }

    public static MySingleton getSingleInstance(){

        if(mySingleton == null){
            mySingleton = new MySingleton();
        }
        return mySingleton;
    }
}
