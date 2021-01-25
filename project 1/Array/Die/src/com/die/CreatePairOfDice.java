package com.die;

public class CreatePairOfDice {
	void pairDraw()
	{
		int number1 = (int)(Math.random()*10) % 6 + 1;
		Die die1 = new Die(number1);
		System.out.println("Die 1");
		die1.draw();
		
		int number2 = (int)(Math.random()*10) % 6 + 1;
		Die die2 = new Die(number2);
		System.out.println("\nDie 2");
		die2.draw();
	}
	
	public static void main(String[] args)
	{
		CreatePairOfDice cpd = new CreatePairOfDice();
		cpd.pairDraw();
	}
}
