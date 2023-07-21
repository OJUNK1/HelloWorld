package co.yedam.thread;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) { //임계영역 만들기. 스레드 하나만 접근허용해서 끝날떄까지 다른 스레드에 접근 못하도록. synchronized
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
}
