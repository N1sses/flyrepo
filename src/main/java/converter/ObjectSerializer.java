package converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class ObjectSerializer<T> {
	 public String objectToString(Serializable object) {
	  String encoded = null;
	  
	  try {
	   ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	   ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	   objectOutputStream.writeObject(object);
	   objectOutputStream.close();
	   encoded = new String(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray()));
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	  return encoded;
	 }

	 @SuppressWarnings("unchecked")
	 public <t extends Serializable>T stringToObject(String string, Class<t> clazz) {
	  byte[] bytes = Base64.getDecoder().decode(string.getBytes());
	  T object = null;
	  try {
	   ObjectInputStream objectInputStream = new ObjectInputStream( new ByteArrayInputStream(bytes) );
	   object = (T)objectInputStream.readObject();
	  } catch (IOException e) {
	   e.printStackTrace();
	  } catch (ClassNotFoundException e) {
	   e.printStackTrace();
	  } catch (ClassCastException e) {
	   e.printStackTrace();
	  }
	  return object;
	 }

}
