package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.*;

public class IntakeClass {
	
	VictorSP	    intakeMotorLeft,
					intakeMotorRight;
	
	boolean			intake,
					outtake;
					
	
	public void intakeCreation(VictorSP motor1, VictorSP motor2 )
	{
		intakeMotorLeft 	= motor1;
		intakeMotorRight 	= motor2;
	}
	
	public void intakeCode(JoystickButton intakeButton, JoystickButton outtakeButton)
	{
		intake 	= intakeButton.get();
		outtake = outtakeButton.get();
		
		if(intake && !outtake)
		{
			intakeMotorLeft.set(-0.5*.3);
			intakeMotorRight.set(0.5*.3);
		}
		else if(!intake && outtake)
		{
			intakeMotorLeft.set(0.5*.3);
			intakeMotorRight.set(-0.5*.3);
		}
		else if( (intake && outtake) || (!intake && !outtake) )
		{
			intakeMotorLeft.set(0);
			intakeMotorRight.set(0);
		}
		else
		{
			intakeMotorLeft.set(0);
			intakeMotorRight.set(0);
		}
	}
}
