package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickReading {
	
    float		leftStickY,
    	 		rightStickY,
    	 		leftTrigger,
    	 		rightTrigger;
    
    Joystick  	controller;
    
    public float getLeftY(Joystick stick, float deadband)
    {
    	leftStickY  = (float) stick.getRawAxis(1);
    	
    	if(leftStickY > deadband || leftStickY < -deadband)
    	{
    		return (float) leftStickY;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public float getRightY(Joystick stick, float deadband)
    {
    	rightStickY = (float) stick.getRawAxis(5);
    	
    	if(rightStickY > deadband || rightStickY < -deadband)
    	{
    		return (float) rightStickY;
    	}
    	else
    	{
    		return 0;
    	}
    }
    
    public float getLeftTrigger(Joystick stick)
    {	
    	leftTrigger 	= (float) stick.getRawAxis(2);
    	return (float) leftTrigger;
    }
    
    public float getRightTrigger(Joystick stick)
    {
    	rightTrigger 	= (float) stick.getRawAxis(3);
    	return (float) rightTrigger;
    }
}
