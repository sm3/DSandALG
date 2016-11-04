public class BinarySearch{

	public BinarySearch()
	{
	}
	
	public int indexOf(int[] item_arr, int key)
	{
		int hi = item_arr.length-1;
		int lo = 0;
		
		while (lo <=hi)
		{
			int mid = lo + hi-lo/2;
		
			if(key < item_arr[mid]) hi = mid-1;
			else if (key > item_arr[mid]) lo = mid+1;
			else
				return mid;
		}
		return -1;
	}
	
	public int localMinima(int[] a)
	{
		int hi = a.length-1;
		int lo = 0;
		while(lo <=hi )
		{
			int mid = lo+(hi-lo)/2;
			System.out.println(mid);
			if(mid > 0 && mid < a.length-2)
			{	if (a[mid] < a[mid+1] && a[mid] < a[mid-1])
					return mid;
				else if (a[mid-1] < a[mid])
					hi = mid-1;
				else if (a[mid+1] < a[mid])
					lo = mid+1;
			}
			else 
				return mid;
		}
		return -1;
	
	}
	
	public static void main(String[] args)
	{
		BinarySearch bs = new BinarySearch();
		int[] i = new int[] {1, 3, 5, 6, 7, 8, 9};
		System.out.println(bs.indexOf(i, 8));
		int[] k = new int[] {10, 4, 9, 1, 3, 5, 6, 7, 8, 9};
		System.out.println(bs.localMinima(k));
		
	}
	
	
	
}