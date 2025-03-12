package lesson3;

import java.util.concurrent.Exchanger;

public class EXercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Exchanger<Integer>	ex = new Exchanger<>();
		
		// 1. Создать три потока-"передатчика"
		// 2. Создать один поток-"приемник"
		// 3. Каждый поток-передатчик передает по ex 10 чисел от 1 до 10.
		// 4. Поток-приемник принимает 30 чисел, считает их сумму и выводит
		//    ее на консоль.
		
	}

}
