public class SingletonObject {
    private static SingletonObject singletonObject;

    private  SingletonObject() {
    }

    //synchronized 없으면 multi-thread 환경에서 문제
    //단점 : 성능 저하
    private static synchronized SingletonObject getInstance(){
        if(singletonObject == null){
            return new SingletonObject();
        }
        return singletonObject;
    }
}
