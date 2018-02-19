package sgit;
import perezjquim.GUI.*;
import perezjquim.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class sgit
{
	private static GUI main;
	private static ScrollableTextArea console;
	public static void main(String[] args)
	{
		main = new GUI("Sgit");

		Panel panAnalysis = new Panel("Analysis");
		panAnalysis.add(new Button("Status",()->
			{
				status();
			}));
		panAnalysis.add(new Button("Diff",()->
			{
				diff();
			}));
		main.add(panAnalysis);

		Panel panHistory = new Panel("History");
		panHistory.add(new Button("Timeline",()->
			{
				timeline();
			}));
		panHistory.add(new Button("Throwback",()->
			{
				throwback();
			}));
		panHistory.add(new Button("Current",()->
			{
				current();
			}));										
		main.add(panHistory);

		Panel panConsole = new Panel();
		console = new ScrollableTextArea(TextArea.HEIGHT_MEDIUM,TextArea.WIDTH_LARGE);
		panConsole.add(console);
		main.add(panConsole);

		main.start();
	}
	private static void status()
	{
		console.getTextArea().clear();
		try
		{
			Cmd.exec("sgit status",console.getTextArea());
		}
		catch(IOException e)
		{ e.printStackTrace(); }
	}
	private static void diff()
	{
		console.getTextArea().clear();		
		try
		{				
			Cmd.exec("sgit diff",console.getTextArea());
		}
		catch(IOException e)
		{ e.printStackTrace(); }
	}
	private static void timeline()
	{
		console.getTextArea().clear();		
		try
		{				
			Cmd.exec("sgit timeline",console.getTextArea());
		}
		catch(IOException e)
		{ e.printStackTrace(); }		
	}
	private static void throwback()
	{
		console.getTextArea().clear();		
		try
		{				
			Cmd.exec("sgit timeline",console.getTextArea());
		}
		catch(IOException e)
		{ e.printStackTrace(); }			
	}
	private static void current()
	{
		console.getTextArea().clear();		
		try
		{				
			Cmd.exec("sgit current",console.getTextArea());
		}
		catch(IOException e)
		{ e.printStackTrace(); }			
	}
}
