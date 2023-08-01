package com.product.main;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.product.constant.Constant;
import com.product.impl.SearchProduct;
import com.product.io.Input;
import com.product.io.ReadFiles;
import com.product.model.Product;

public class ProductSearch {
	static List<Product> updatedFiles;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Input input = new Input(scanner);
		Timer timer = updateFiles();

		int inputNumber = 0;
		char choice = 'y';

		try {
			do {
				Product product = input.userInput();
				SearchProduct.searchProductForUser(updatedFiles, product, ++inputNumber);
				System.out.print("\nSearch more product (y/n): ");
				choice = scanner.next().charAt(0);
				System.out.println();
			} while (choice == 'Y' || choice == 'y');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			timer.cancel();
		}

		scanner.close();

	}

	/**
	 * updateFiles using Timer thread at run time,
	 * 
	 * @return timer
	 */
	private static Timer updateFiles() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				try {
					updatedFiles = ReadFiles.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(timerTask, Constant.DELAY, Constant.PERIOD);
		return timer;
	}
}
