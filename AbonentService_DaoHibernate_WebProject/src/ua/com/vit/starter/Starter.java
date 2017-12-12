package ua.com.vit.starter;

import java.util.List;

import ua.com.vit.connector.HibernateConnector;
import ua.com.vit.dao.AbonentDao;
import ua.com.vit.dao.DaoInterface;
import ua.com.vit.dao.UserDao;
import ua.com.vit.entity.Abonent;
import ua.com.vit.entity.User;


public class Starter {

	public static void main(String[] args) {
		DaoInterface<User,Integer> userDao = new UserDao();
		DaoInterface<Abonent,Integer> abonentDao = new AbonentDao();
 //       	User user = userDao.findById(1);
//			System.out.println(user);

//        	Abonent abonent = abonentDao.findById(2);
//        	System.out.println(abonent);
        
		//    	Abonent abonent = abonentDao.findById2(2);
		//    	System.out.println(abonent);

		List<User> users = userDao.findAll();
		users.forEach(System.out::println);
		
		HibernateConnector.getInstance().close();
        
        
		
		
		
	}

}
