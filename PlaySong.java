package com.capgemini.assesment;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;



public class PlaySong {
	
	
	void switchSong()
	{
		
		System.out.println("Press the key 1 to Play All song ");
		System.out.println("Press the key 2 to Play Song Randomly ");
		System.out.println("Press the key 3 to Play a Particular song ");
		
		Scanner in = new Scanner(System.in);
		
		int ch = in.nextInt();
		
		switch(ch)
		{
			case 1: playAllSong();
					
			break;
			case 2: playRandomSong();
			break;
			case 3: System.out.println("Enter the song ID To play");
				int id = in.nextInt();
				playParticular(id);
			break;

			default:System.out.println("Please choose from the given options");
		}
	}
	
	
	private void playParticular(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		try {
			
		
			FileInputStream fileInputStream = new FileInputStream("Prop.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			Class.forName(prop.getProperty("driver_name"));
			connection = DriverManager.getConnection(prop.getProperty("url"),prop);
			String sql =	"SELECT Song_Title FROM musicfiles where Song_ID=?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,id );
			resultSet=preparedStatement.executeQuery();
			
			
			if(resultSet.next())
			{
				System.out.println("Song Title " +resultSet.getString("Song_Title"));
				System.out.println("---------------------------");
			}
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		finally {
			try {
				
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(resultSet!=null)
					resultSet.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}


	void playAllSong()
	{
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		try {
			
		
			FileInputStream fileInputStream = new FileInputStream("Prop.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			Class.forName(prop.getProperty("driver_name"));
			connection = DriverManager.getConnection(prop.getProperty("url"),prop);
			String sql = "select * from musicfiles";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				//System.out.println("Song Id -- " +resultSet.getInt("Song_ID"));
				System.out.println("Song Title " +resultSet.getString("Song_Title"));
//				System.out.println("Artist Name " +resultSet.getString("Artist_Name"));
//				System.out.println("Album Name " +resultSet.getString("Album_Name"));
//				System.out.println("Song Location " +resultSet.getString("Song_Location"));
//				System.out.println("Song Description " +resultSet.getString("Description"));
				
				System.out.println("---------------------------");
			}
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();

		}
		
		finally {
			try {
				
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(resultSet!=null)
					resultSet.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	void playRandomSong()
	{
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;

		try {
			
		
			FileInputStream fileInputStream = new FileInputStream("Prop.properties");
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			Class.forName(prop.getProperty("driver_name"));
			connection = DriverManager.getConnection(prop.getProperty("url"),prop);
			String sql =	"SELECT Song_Title FROM musicfiles ORDER BY RAND()";
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				
				
				//System.out.println("Song Id -- " +resultSet.getInt("Song_ID"));
				System.out.println("Song Title " +resultSet.getString("Song_Title"));
//				System.out.println("Artist Name " +resultSet.getString("Artist_Name"));
//				System.out.println("Album Name " +resultSet.getString("Album_Name"));
//				System.out.println("Song Location " +resultSet.getString("Song_Location"));
//				System.out.println("Song Description " +resultSet.getString("Description"));
				
				System.out.println("---------------------------");
			}
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();

		}
		
		finally {
			try {
				
				if(connection!=null)
					connection.close();
				if(preparedStatement!=null)
					preparedStatement.close();
				if(resultSet!=null)
					resultSet.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
