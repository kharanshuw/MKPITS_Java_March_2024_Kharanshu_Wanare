import java.util.*;


class RemoveDuplicate{

public void mymethod(int arr[])
{
	List<Integer> list= new ArrayList<>(arr);
	
/*	for(int i : arr)
	{
		list.add(i);
	}
	*/

	HashSet<Integer> hashset=new HashSet<Integer>();

	hashset.addAll(list);

Iterator<Integer> itr = hashset.iterator();

while(itr.hasNext())
{
System.out.println(itr.next());
}

}

public static void main(String[] args)
{
	RemoveDuplicate remove=new RemoveDuplicate();
	
	int arr[]={10,20,30,40,40,20,60,90,45,60};
	
	remove.mymethod(arr);
}
}
