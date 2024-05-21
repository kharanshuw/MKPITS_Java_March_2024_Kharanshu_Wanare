package assignment14.assignment8;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import assignment14.assignment7.Order;

public class Playlistmanager {
	LinkedList<Song> linkedList=new LinkedList<Song>();
		
	public void add(Song song) {
		linkedList.add(song);
	}
	
	public 	void remove(String songidString) {
		Iterator<Song> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Song song = (Song) iterator.next();
			if (song.getSongIdString().equals(songidString)) {
				iterator.remove();
			}
		}
	}
	
	public void search(String titleString) {
		Iterator<Song> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Song song = (Song) iterator.next();
			if (song.getTitleString().equals(titleString)) {
				System.out.println(song);
			}
		}
	}
	
	public void sort() {
		Collections.sort(linkedList);
	}
	
	public void display() {
		Iterator<Song> iterator =linkedList.iterator();
		while (iterator.hasNext()) {
			Song song = (Song) iterator.next();
				System.out.println(song);
		
		}
	}
}
