package co.yedam.thread;

import java.awt.Toolkit;

class PrintThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("print");
			try {
				Thread.sleep(500); // thread를 잠시 중단상태로 두는 것 500ms 기다렸다가 출력
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class BeepTask implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

public class ThreadExe {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread(); // 현재 실행되고 있는 쓰레드 값을 반환.
		System.out.println(mainThread.getName());

		PrintThread thread = new PrintThread();
		thread.start(); // run 메소드가 실행! 메인 쓰레드가 끝나고, 프린트쓰레드가 실행되는 것.

		Thread bthread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500); // thread를 잠시 중단상태로 두는 것 500ms 기다렸다가 출력
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		bthread.start();

		System.out.println("end of prog.");
	}
}
