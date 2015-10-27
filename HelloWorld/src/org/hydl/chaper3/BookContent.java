package org.hydl.chaper3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {
	public static class Book {
		public Integer id;
		public String title;
		public String desc;
		public Book(Integer id,String title,String desc) {
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return title.toString();
		}
	}
	
	public static List<Book> ITEMS = new ArrayList<Book>();
	public static Map<Integer , Book> ITEM_MAP = new HashMap<Integer,Book>();
	static{
		addItem(new Book(1, "疯狂Java讲义", "描述1"));
		addItem(new Book(2, "疯狂Android讲义", "描述2"));
		addItem(new Book(3, "轻量级Java EE企业应用实战" , "描述3"));
	}
	private static void addItem(Book book) {
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
}
