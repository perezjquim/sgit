package sgit;
import perezjquim.GUI.*;
import perezjquim.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class sgit
{
	private static GUI main;
	private static File repoDirectory;
	private static TextArea currentDir;	
	private static ScrollableTextArea console;
	public static void main(String[] args)
	{
		main = new GUI("Sgit");

		Panel panRepo = new Panel("Git repository directory");
		currentDir = new TextArea(TextArea.HEIGHT_SMALL,TextArea.WIDTH_MEDIUM);
		panRepo.add(currentDir);
		panRepo.add(new Button("Choose directory",()->
			{
				repoDirectory = IO.askFolder();
				currentDir.setText(repoDirectory.getAbsolutePath());
			}));
		main.add(panRepo);		

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

		Panel panPushPull = new Panel("Push/Pull");
		TextField commitNameField = new TextField();
		panPushPull.add(commitNameField);
		panPushPull.add(new Button("Push",()->
			{
				push(commitNameField.getText());
			}));
		panPushPull.add(new Button("Pull",()->
			{
				pull();
			}));		
		main.add(panPushPull);

		Panel panConsole = new Panel();
		console = new ScrollableTextArea(TextArea.HEIGHT_MEDIUM,TextArea.WIDTH_LARGE);
		panConsole.add(console);
		main.add(panConsole);

		main.start();
	}
	private static void status()
	{
		if(!currentDir.getText().equals(""))
		{				
			console.getTextArea().clear();
			try
			{
				Cmd.exec("sgit status",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}			
	}
	private static void diff()
	{
		if(!currentDir.getText().equals(""))
		{			
			console.getTextArea().clear();		
			try
			{				
				Cmd.exec("sgit diff",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}			
	}
	private static void timeline()
	{
		if(!currentDir.getText().equals(""))
		{						
			console.getTextArea().clear();		
			try
			{				
				Cmd.exec("sgit timeline",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}			
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}						
	}
	private static void throwback()
	{
		if(!currentDir.getText().equals(""))
		{				
			console.getTextArea().clear();		
			try
			{				
				Cmd.exec("sgit throwback",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}		
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}					
	}
	private static void current()
	{
		if(!currentDir.getText().equals(""))
		{		
			console.getTextArea().clear();		
			try
			{				
				Cmd.exec("sgit current",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}			
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}						
	}
	private static void push(String commitName)
	{
		if(!commitName.equals("") && !currentDir.getText().equals(""))
		{
			console.getTextArea().clear();
			String[] cmdPush = { "/bin/sh","-c", "echo "+commitName+" | sgit push" };		
			try
			{				
				Cmd.exec(cmdPush,console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}
		else
		{
			IO.popup("Make sure you've chosen a directory and a name for the new commit.");
		}			
	}
	private static void pull()
	{
		if(!currentDir.getText().equals(""))
		{				
			console.getTextArea().clear();		
			try
			{				
				Cmd.exec("sgit pull",console.getTextArea(),repoDirectory);
			}
			catch(IOException e)
			{ e.printStackTrace(); }
		}			
		else
		{
			IO.popup("Make sure you've chosen a directory.");
		}							
	}
}
