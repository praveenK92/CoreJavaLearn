package learn.ocp.core.designPattern.creational;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton {
	public static void main(String[] args) throws Exception{
		SerializedSingleton instanceOne=SerializedSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.json"));
		out.writeObject(instanceOne);
		out.close();
		//deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.json"));
		SerializedSingleton instanceTwo = (SerializedSingleton)in.readObject();
		in.close();
		System.out.println("instanceOne hashCode="+instanceOne.hashCode());
		System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
	}
	
}

class SerializedSingleton implements Serializable {
	private static final long serialVersionUID = -7604766932017737115L;
	private SerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance;
	}
	protected Object readResolve(){
		return getInstance();
	}
	
	public void printRa(){
		System.out.println(serialVersionUID);
	}
}