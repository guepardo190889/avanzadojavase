package com.blackdeath.lambdas;

/**
 * @author Seth Luis
 *
 */
public class Lambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OnOneListener listener = new OnOneListener() {
			@Override
			public void onOne(String message) {
				System.out.println("One: " + message);
			}
		};

		listener.onOne("listener");

		OnOneListener listener2 = (String message) -> {
			System.out.println("One: " + message);
		};

		listener2.onOne("lambda");

	}

}
