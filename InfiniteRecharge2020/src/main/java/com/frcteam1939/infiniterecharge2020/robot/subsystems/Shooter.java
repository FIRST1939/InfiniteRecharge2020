/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import com.frcteam1939.infiniterecharge2020.util.Constants;

public class Shooter extends SubsystemBase {

  public boolean close = false;
  public boolean mid = false;
  public boolean far = false;
  
  private boolean isShooting = false;
  private double setRPM = 1500;

  private boolean ready;
  private boolean ready2;

  
  private TalonFX shooterTalon1 = new TalonFX(RobotMap.shooterFalcon1);
  private TalonFX shooterTalon2 = new TalonFX(RobotMap.shooterFalcon2);

  private Solenoid bigSolenoid = new Solenoid(RobotMap.shooterHoodBigSolenoid);
  private Solenoid smallSolenoid = new Solenoid(RobotMap.shooterHoodSmallSolenoid);

  private TalonFXConfiguration config = new TalonFXConfiguration();
  
  public Shooter(){
    config.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();
    
    config.slot0.kF = Constants.PID_Constants.sF;
    config.slot0.kP = Constants.PID_Constants.sP;
    config.slot0.kI = Constants.PID_Constants.sI;
    config.slot0.kD = Constants.PID_Constants.sD;

    config.slot0.integralZone = Constants.PID_Constants.sIzone;
    config.slot0.closedLoopPeakOutput = Constants.PID_Constants.sPeakOutput;

    //config.auxPIDPolarity = false; //true right talon, false left talon

    config.slot0.closedLoopPeriod = 1;

   /* shooterTalon1.config_kF(0,Constants.PID_Constants.sF,Constants.kTimeoutMs);
    shooterTalon1.config_kP(0,Constants.PID_Constants.sP,Constants.kTimeoutMs);
    shooterTalon1.config_kI(0,Constants.PID_Constants.sI,Constants.kTimeoutMs);
    shooterTalon1.config_kD(0,Constants.PID_Constants.sD,Constants.kTimeoutMs);*/



    shooterTalon1.configAllSettings(config);
    shooterTalon2.configAllSettings(config);

    /*
    _rightMaster.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, Constants.kTimeoutMs);
		_rightMaster.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, Constants.kTimeoutMs);
    _leftMaster.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, Constants.kTimeoutMs);
    */


    
    shooterTalon1.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    shooterTalon2.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    shooterTalon1.enableVoltageCompensation(true);
    shooterTalon2.enableVoltageCompensation(true);

    shooterTalon1.setInverted(true);
    shooterTalon2.setInverted(true);

    shooterTalon2.follow(shooterTalon1);
    disableBrakeMode();

    shooterTalon1.selectProfileSlot(0, 0);
  }

  @Override
  public void periodic() {
  }

  // Positive is out
  public void set(double value){
    if((value>0)||value<0){
      isShooting = true;
    }
    else{
      isShooting = false;
    }
    shooterTalon1.set(ControlMode.PercentOutput, value);
    Robot.lights.strobeGreen();
  }

  public void setRPM(double rpm){
    double targetRPM = rpm;
    double targetUnitsPer100ms = targetRPM * Constants.PID_Constants.sSensorUnitsPerRevolutions/ 600;//why /600 thats what it said in example code?
    double feedFwdTerm = .1;
    shooterTalon1.set(TalonFXControlMode.Velocity, targetUnitsPer100ms,DemandType.ArbitraryFeedForward,feedFwdTerm);
    ///shooterTalon1.set(TalonFXControlMode.Velocity, targetUnitsPer100ms);
    shooterTalon2.follow(shooterTalon1);
  }

  public double getSpeed(){
    double speed1 = shooterTalon1.getSelectedSensorVelocity();
    double speed2 = shooterTalon2.getSelectedSensorVelocity();
    return (speed1 + speed2) / 2;
  }

  public double getRevolutions(){
    return (getSpeed()/Constants.PID_Constants.sSensorUnitsPerRevolutions)*600;
  }

  public double getTemperature(){
    return shooterTalon1.getTemperature();
  }

  public double getOutput(){
    return shooterTalon1.getMotorOutputPercent();
  }

  public void hoodUp(){
    bigSolenoid.set(true);
    smallSolenoid.set(true);
  }

  public void hoodDown(){
    bigSolenoid.set(false);
    smallSolenoid.set(false);
  }

  public void hoodMiddleHigh(){
    bigSolenoid.set(false);
    smallSolenoid.set(true);
  }

  public void hoodMiddleLow(){
    bigSolenoid.set(true);
    smallSolenoid.set(false);
  }

  public void stop(){
    set(0);
  }
    
  public void enableBrakeMode(){
    shooterTalon1.setNeutralMode(NeutralMode.Brake);
    shooterTalon2.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    shooterTalon1.setNeutralMode(NeutralMode.Coast);
    shooterTalon2.setNeutralMode(NeutralMode.Coast);
  } 

  public boolean isReady(){
    return ready;
  }

  public void setReady(boolean status){
    ready = status;
  }
  
  public boolean isReadyLimelight(){
    return ready2;
  }

  public void setReadyLimelight(boolean status){
    ready2 = status;
  }

  public boolean getIsShooting()
  {
    return isShooting;
  }

  public double getSetRPM()
  {
    return setRPM;
  }

}