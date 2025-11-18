package design_patterns.singleton_design;


public class LearnSingleton {
	// create a static instance for the class so that this instance cannot be accessed by any object
	public static LearnSingleton instance;
	// create a private constructor so that no object can be created for this class
	private LearnSingleton(){

	}
	public static LearnSingleton getInstance(){
		if(instance==null){
			synchronized (LearnSingleton.class){
				if(instance==null){
					instance=new LearnSingleton();
				}
			}
		}
		return instance;
	}

	public void sendMessage(){
		System.out.println("Hello world !");
	}
}
