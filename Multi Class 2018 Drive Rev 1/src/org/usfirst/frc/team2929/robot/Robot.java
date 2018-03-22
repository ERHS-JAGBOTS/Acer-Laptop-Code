

package org.usfirst.frc.team2929.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Robot extends IterativeRobot {

	private static int autonCounter = 0;
	
	WPI_TalonSRX 	leftMotor1 			= new WPI_TalonSRX(0),
			  		leftMotor2 			= new WPI_TalonSRX(1),
			  		leftMotor3 			= new WPI_TalonSRX(2),
			  		rightMotor1 		= new WPI_TalonSRX(3),
			  		rightMotor2 		= new WPI_TalonSRX(4),
			  		rightMotor3 		= new WPI_TalonSRX(5),
					liftMotor           = new WPI_TalonSRX(6);
	
	VictorSP      
					intakeMotorRight   	 	= new VictorSP(0),
					intakeMotorLeft			= new VictorSP(1);
	
	Compressor  	comp 				= new Compressor(0);
	
    Joystick  		controller		= new Joystick(0),
    				controller1			= new Joystick(1);
    
    Solenoid 		shifter0 			= new Solenoid(0),
    				shifter1 			= new Solenoid(1);
    
    JoystickButton 	clutch 				= new JoystickButton(controller, 5),
    				throttleButton 		= new JoystickButton(controller, 6),
    				intakeButton		= new JoystickButton(controller1, 2),
    				outtakeButton		= new JoystickButton(controller1, 3);
    
    float 			deadband 			= (float) 0.2,
    				leftStickY,
    				rightStickY,
    				throttle 			= (float) 0.3;
    
    JoystickReading controllerRead;
    DriveClass 		robotDrive;
    LiftClass 		robotLift;
    IntakeClass		robotIntake;
    
	@Override
	public void robotInit() {
		comp.start();
		CameraServer.getInstance().startAutomaticCapture();
		
		controllerRead 	= new JoystickReading();
		robotDrive 		= new DriveClass();
		robotLift		= new LiftClass();
		robotIntake		= new IntakeClass();
		robotDrive.driveCreation(leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3);
		robotLift.liftCreation(liftMotor);
		robotIntake.intakeCreation(intakeMotorLeft, intakeMotorRight);
	}

	
	@Override
	public void autonomousInit() {
		shifter0.set(false);
		shifter1.set(true);
	}

	
	@Override
	public void autonomousPeriodic() {
		// Runs code in bellow block once energy 250 ms
		Scheduler.getInstance().run();
		// Value to go to, up for more time down for less
		for (int i = 0; autonCounter < 50000; autonCounter++) {
			// see the method
			robotDrive.deployAuto();
		}
		// see the method
		robotDrive.stop();
	}

	@Override
	public void teleopPeriodic() {

	robotDrive.driveCode(throttleButton, clutch, shifter0, shifter1, controllerRead.getLeftY(controller, deadband),
			controllerRead.getRightY(controller,  deadband), throttle);

	robotLift.liftCode(controllerRead.getLeftTrigger(controller1), controllerRead.getRightTrigger(controller1));
	robotIntake.intakeCode(intakeButton, outtakeButton);
		
	}

	
	@Override
	public void testPeriodic() {
	}
}
