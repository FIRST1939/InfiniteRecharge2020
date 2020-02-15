/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.robot.commands.DriveByJoystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private static final double WHEEL_DIAMETER = 6.0;
  private static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
  private static final double MAX_TURN_OUTPUT = 0.25;

  private static final double MAX_SPEED = 0.0;

  private static final double CPR = 2048.0;

  private static final int MOTION_MAGIC_CRUISE_VELOCITY = 0;
  private static final int MOTION_MAGIC_ACCELERATION = 0;

  private static final int posIndex = 0;
  private static final double posP = 0;
  private static final double posI = 0;
  private static final double posD = 0;

  // public PIDController turnPID;
	private static final double turnF = 0.0;
	private static final double turnP = 0.0;
	private static final double turnI = 0.0;
	private static final double turnD = 0.0;

  private TalonFX frontLeft = new TalonFX(RobotMap.leftFrontFalcon);
  private TalonFX backLeft = new TalonFX(RobotMap.leftBackFalcon);
  private TalonFX frontRight = new TalonFX(RobotMap.rightFrontFalcon);
  private TalonFX backRight = new TalonFX(RobotMap.rightBackFalcon);

  // private AHRS navx;
  // public Limelight limelight = new Limelight();

  public Drivetrain(){
    setupMasterTalons();

    // navx = new AHRS(Port.kUSB);
		// navx.setPIDSourceType(PIDSourceType.kDisplacement);
		// turnPID = new PIDController(turnP, turnI, turnD, turnF, navx, output -> {});
		// turnPID.setInputRange(-180, 180);
		// turnPID.setContinuous(true);
		// turnPID.setOutputRange(-MAX_TURN_OUTPUT, MAX_TURN_OUTPUT);
		// turnPID.setSetpoint(0);
    // turnPID.enable();

  }
  @Override
  public void periodic() {
  }

  // Get Methods 

  public double getLeftPosition(){
    double frontPosition = frontLeft.getSelectedSensorPosition() / CPR;
    double backPosition = backLeft.getSelectedSensorPosition() / CPR;
    return (frontPosition + backPosition) / 2.0;
  }

  public double getRightPosition(){
    double frontPosition = frontRight.getSelectedSensorPosition() / CPR;
    double backPosition = backRight.getSelectedSensorPosition() / CPR;
    return (frontPosition + backPosition) / 2.0;
  }

  public double getLeftVelocity(){
    double frontVelocity = frontLeft.getSelectedSensorVelocity();
    double backVelocity = backLeft.getSelectedSensorVelocity();
    return (frontVelocity + backVelocity) / 2.0;
  }

  public double getRightVelocity(){
    double frontVelocity = frontRight.getSelectedSensorVelocity();
    double backVelocity = backRight.getSelectedSensorVelocity();
    return (frontVelocity + backVelocity) / 2.0;
  }

  public double getLeftPercentOutput(){
    return frontLeft.getMotorOutputPercent();
  }

  public double getRightPercentOutput(){
    return frontRight.getMotorOutputPercent();
  }

  public double getLeftVoltage(){
    return frontLeft.getMotorOutputVoltage();
  }

  public double getRightVoltage(){
    return frontRight.getMotorOutputVoltage();
  }

  // public double getHeading() {
	// 	if (navx.isConnected()) {
	// 		return navx.pidGet();
	// 	} else {
	// 		return 0;
	// 	}
	// }

	// public double getTurnSpeed() {
		// if (navx.isConnected()) {
		//	return navx.getRate();
	// 	} else {
	// 		return 0;
	// 	}
	// }

  // Set Methods

  public void setPercentOutput(double leftPercent, double rightPercent){
    frontLeft.set(ControlMode.PercentOutput, leftPercent);
    frontRight.set(ControlMode.PercentOutput, rightPercent);
  }

  public void setDistance(double value){
    frontLeft.set(ControlMode.MotionMagic, value);
    frontRight.set(ControlMode.MotionMagic, value);
  }

  public void stop(){
    setPercentOutput(0, 0);
  }

  public void zeroEncoders(){
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);
  }

  public void drive(double moveValue, double rotateValue) {

		// Calculate left and right speeds from move and rotate values
		double leftMotorSpeed;
		double rightMotorSpeed;
		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		// Tell Drivetrain to move
    setPercentOutput(-leftMotorSpeed, -rightMotorSpeed);
    
		SmartDashboard.putNumber("Move Output", moveValue);
		SmartDashboard.putNumber("Turn Output", rotateValue);
  }

  public void enableBrakeMode(){
    frontLeft.setNeutralMode(NeutralMode.Brake);
    backLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
    frontLeft.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    frontLeft.setNeutralMode(NeutralMode.Coast);
    backLeft.setNeutralMode(NeutralMode.Coast);
    frontRight.setNeutralMode(NeutralMode.Coast);
    frontLeft.setNeutralMode(NeutralMode.Coast);
  }

  public void setPositionPID(double P, double I, double D){
    frontLeft.selectProfileSlot(posIndex, 0);
    frontRight.selectProfileSlot(posIndex, 0);
    frontLeft.config_kP(posIndex, P);
    frontLeft.config_kI(posIndex, I);
    frontLeft.config_kD(posIndex, D);
    frontRight.config_kP(posIndex, P);
    frontRight.config_kI(posIndex, I);
    frontRight.config_kD(posIndex, D);
  }

  // Private Convenience Methods

  private void setupMasterTalons(){

    frontRight.setInverted(true);
    backRight.setInverted(true);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    setPositionPID(posP, posI, posD);

    frontLeft.configNominalOutputForward(+0);
		frontLeft.configNominalOutputReverse(-0);
		frontLeft.configPeakOutputForward(+1);
    frontLeft.configPeakOutputReverse(-1);
    frontRight.configNominalOutputForward(+0);
		frontRight.configNominalOutputReverse(-0);
		frontRight.configPeakOutputForward(+1);
    frontRight.configPeakOutputReverse(-1);
    frontLeft.enableVoltageCompensation(true);
    frontRight.enableVoltageCompensation(true);

		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
		frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
		frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10);
    frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10);
    frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);
    frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 20);

    frontLeft.configMotionCruiseVelocity(MOTION_MAGIC_CRUISE_VELOCITY);
    frontLeft.configMotionAcceleration(MOTION_MAGIC_ACCELERATION);
    frontRight.configMotionCruiseVelocity(MOTION_MAGIC_CRUISE_VELOCITY);
    frontRight.configMotionAcceleration(MOTION_MAGIC_ACCELERATION);
  }
}
