package problemStatement_10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MaxValue extends RecursiveTask<Integer>{
	
	private  int[] array;
	private  int start;
	private  int end;
	
	

	public MaxValue(int[] array, int start, int end) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
	}



	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if(end-start<=5)
		{
			int max=Integer.MIN_VALUE;
			for(int i=start;i<end;i++)
			{
				if(array[i]>max)
				{
					max=array[i];
				}
			}
			return max;
		}
		else
		{
			int mid =(start+end)/2;
			MaxValue left=new MaxValue(array,start,mid);
			MaxValue right=new MaxValue(array,mid,end);
			left.fork();
			int rightResult = right.compute();
			int leftResult = left.join();
			return Math.max(rightResult, leftResult);
		}
		
	}
	public static void main(String[] args) {
		int[] array = {10,7,5,24,50,8,30,67,15,49,10000};
		ForkJoinPool fjp =new ForkJoinPool();
		MaxValue mx = new MaxValue(array, 0, array.length);
		int maxValue=fjp.invoke(mx);
		System.out.println(maxValue);
	}

}


