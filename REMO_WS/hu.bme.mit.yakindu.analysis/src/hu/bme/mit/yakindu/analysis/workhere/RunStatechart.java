package hu.bme.mit.yakindu.analysis.workhere;

import java.io.Console;
import java.io.IOException;

import hu.bme.mit.yakindu.analysis.RuntimeService;
import hu.bme.mit.yakindu.analysis.TimerService;
import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;



public class RunStatechart {
	
	public static void main(String[] args) throws IOException {
		ExampleStatemachine s = new ExampleStatemachine();
		s.setTimer(new TimerService());
		RuntimeService.getInstance().registerStatemachine(s, 200);
		s.init();
		s.enter();
		Console console = System.console();
		while (true) {
			String input = console.readLine();
			switch (input) {
			case "start":
				s.raiseStart();
			case "white":
				s.raiseWhite();
			case "black":
				s.raiseBlack();
			case "exit":
				System.exit(0);
			}
			s.runCycle();
			print(s);
		}
	}

	public static void print(IExampleStatemachine s) {
		System.out.println("W = " + s.getSCInterface().getWhiteTime());
		System.out.println("B = " + s.getSCInterface().getBlackTime());
	}
}
