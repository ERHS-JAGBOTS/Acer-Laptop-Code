package org.usfirst.frc.team2929.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class LiftClass {
	
	WPI_TalonSRX	liftMotor;
	
	public void liftCreation(WPI_TalonSRX  motor)
	{
		liftMotor = motor;
	}
	
	public void liftCode(float leftTrigger, float rightTrigger)
	{
		if( (leftTrigger > 0 && !(rightTrigger > 0)) )
		{
			liftMotor.set(-leftTrigger);
		}
		else if( (!(leftTrigger > 0) && rightTrigger > 0) )
		{
			liftMotor.set(rightTrigger);
		}
		else if( (leftTrigger > 0 && rightTrigger > 0) || (leftTrigger == 0 && rightTrigger == 0) )
		{
			liftMotor.set(0);
		}
		else
		{
			liftMotor.set(0);
		}
	}
}
