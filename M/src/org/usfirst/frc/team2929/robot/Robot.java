/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TalonSRX;
/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */

//Main class
public class Robot extends IterativeRobot
{
	
	//create left and right joysticks
	private Joystick logitechLeft;
	private Joystick logitechRight;
	
	//create talon for front left and right
	//create talon for back left and right (leftDrive2 and rightDrive2)
	private TalonSRX 	leftDrive,
						rightDrive,
						leftDrive2,
						rightDrive2;
	                 
	
	//create joystick contructor for drive forward and backward
	private float	leftStickY,
					rightStickY,
					
					//the area of the joystick that doesn't move (the null zone)
					deadBand = (float) 0.45,
					//speed adjustment
					throttle;

	@Override
	public void robotInit()
	{
		//map left and right joystick to port 1 and 0
		//m_leftStick = new Joystick(1);
		//m_rightStick = new Joystick(0);
		@SuppressWarnings("unused")
		Joystick logitech = new Joystick(2);

	}
	{
		//map the drives to the 2, 0, 3, 1 ports
		leftDrive = new TalonSRX(2);
		rightDrive = new TalonSRX(0);
		leftDrive2 = new TalonSRX(3);
		rightDrive2 = new TalonSRX(1);
		}
	

//took too long to figure out

	@Override
	public void teleopPeriodic()
	{
		//call the forward and backward joysticks to get the y-values
		leftStickY = (float) logitechLeft.getRawAxis(1);
		rightStickY = (float) logitechRight.getRawAxis(3);
		
		//if joystick not pushed forward enough don't move
		throttle = (float) logitechLeft.getRawAxis(7);
		
		//if joystick not pushed forward enough don't move
		if(leftStickY > deadBand || leftStickY < -deadBand)
		{
			leftDrive.set(-leftStickY * throttle);
			leftDrive2.set(-leftStickY * throttle);
			
		}
		
		//if joystick not pushed forward enough don't move
		if(rightStickY > deadBand || rightStickY < -deadBand)
		{
			rightDrive.set( rightStickY * throttle);
			rightDrive2.set( rightStickY * throttle);
		}
		
}
		{
		}
		public static final int BTN_A = 1;
		public static final int BTN_B = 2;
		public static final int BTN_X = 3;
		public static final int BTN_Y = 4;
		public static final int BTN_LB = 5;
		public static final int BTN_RB = 6;
		public static final int BTN_BACK = 7;
		public static final int BTN_START = 8;
		public static final int BTN_LEFT_JOYSTICK = 9;
		public static final int BTN_RIGHT_JOYSTICK = 10;
		}
//End Auto generated Code
//{
//SmartDashboard.putData("rightDrive", new TalonSRX(2));
//SmartDashboard.putData("leftDrive", new TalonSRX(0));
//SmartDashboard.putData("rightDrive2", new TalonSRX(3));
//SmartDashboard.putData("leftDrive2", new TalonSRX(1));
//}