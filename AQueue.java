public class AQueue {
	private boolean isEmpty;
	private int size;
	private Object data[];
	public AQueue()
	{
		this.isEmpty=true;
		this.size=0;
	}
	/**
	 * inserts an element at the end of the queue
	 */
	public void enqueue(Object data)
	{
		if(isEmpty())
		{
			this.data= new Object[this.size+1];
			this.data[0]=data;
			this.size++;
			this.isEmpty=false;
		}
		else {
			Object newdata[]= new Object[this.size+1];
			for(int run=0;run<this.size;run++)
			{
				newdata[run]=this.data[run];
			}
			newdata[this.size+1]=data;
			this.size++;
			this.data=newdata.clone();
		}
	}
	/**
	 * removes and returns the element at the front of the queue
	 * @return
	 */
	public Object dequeue()throws EmptyQueueException{
		if(this.size==0)
		{
			throw new EmptyQueueException();
		}
		else{
			Object newdata[]= new Object[this.size-1];
			for(int run=1;run<this.size;run++)
			{
				newdata[run]=this.data[run];
			}
			this.size--;
			if(this.size==0)
			{
				this.isEmpty=true;
			}
			Object element=this.data[0];
			this.data=newdata.clone();
			return element;
		}
	}
	/**
	 * returns the element at the front without removing it
	 * @return
	 */
	public Object front()throws EmptyQueueException{
		if(this.size==0)
		{
			throw new EmptyQueueException();
		}
		else{
		return this.data[0];
		}
	}
	
	/**returns the number of elements stored
	 * @return
	 */
	public int size(){
		return this.size;
	}
	/**
	 * indicates whether no elements are stored
	 * The big-Oh running time
	 */
	public boolean isEmpty(){
		return this.isEmpty;
	}
	

	
}
class EmptyQueueException extends Exception
{

}