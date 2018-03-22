package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.*;

public class DriveClass {
	
	WPI_TalonSRX	leftMotor1,
					leftMotor2,
					leftMotor3,
					rightMotor1,
					rightMotor2,
					rightMotor3;
	
	public void driveCreation(WPI_TalonSRX leftDrive1, WPI_TalonSRX leftDrive2, WPI_TalonSRX leftDrive3,
			WPI_TalonSRX rightDrive1, WPI_TalonSRX rightDrive2, WPI_TalonSRX rightDrive3)
	{
		leftMotor1 = leftDrive1;
		leftMotor2 = leftDrive2;
		leftMotor3 = leftDrive3;
		rightMotor1 = rightDrive1;
		rightMotor2 = rightDrive2;
		rightMotor3 = rightDrive3;
	}
	
	public void driveCode(JoystickButton throttleButton, JoystickButton clutch, Solenoid shifter0, Solenoid shifter1, float leftStickY, float rightStickY, float throttle)
	{
		if(throttleButton.get())
		{
			leftMotor1.set(-rightStickY * throttle);
			leftMotor2.set(-rightStickY * throttle);
			leftMotor3.set(-rightStickY * throttle);
			rightMotor1.set(leftStickY * throttle);
			rightMotor2.set(leftStickY * throttle);
			rightMotor3.set(leftStickY * throttle);
		}
		else
		{
			leftMotor1.set(-rightStickY);
			leftMotor2.set(-rightStickY);                                                                                                                                                                                                                                                                                                                                                                                                                                               
			leftMotor3.set(-rightStickY);
			rightMotor1.set(leftStickY);
			rightMotor2.set(leftStickY);
			rightMotor3.set(leftStickY);
		}
		
		if(clutch.get())
		{
			shifter0.set(false);
			shifter1.set(true);
		}
		else
		{
			shifter0.set(true);
			shifter1.set(false);
		}
	}

	// runs motors forward at 1/3 speed
	public void deployAuto() {
		leftMotor1.set(0.3);
		leftMotor2.set(0.3);
		leftMotor3.set(0.3);
		rightMotor1.set(-0.3);
		rightMotor2.set(-0.3);
		rightMotor3.set(-0.3);
	}
	
	// stops all drive motors
	public void stop() {
		leftMotor1.set(0);
		leftMotor2.set(0);
		leftMotor3.set(0);
		rightMotor1.set(0);
		rightMotor2.set(0);
		rightMotor3.set(0);
	}

}
