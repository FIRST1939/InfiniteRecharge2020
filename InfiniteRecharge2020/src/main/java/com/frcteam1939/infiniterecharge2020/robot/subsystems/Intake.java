/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
  private Solenoid intakeSolenoid = new Solenoid(RobotMap.intakeSolenoid);
  private TalonSRX intakeTalon = new TalonSRX(RobotMap.intakeRollersTalon);

  @Override
  public void initDefaultCommand() {
  }

  public void extendIntake(){
    intakeSolenoid.set(true);
  }

  public void retractIntake(){
    intakeSolenoid.set(false);
  }

  public void enableBrakeMode(){
    intakeTalon.setNeutralMode(NeutralMode.Brake);
  }

  public void disableBrakeMode(){
    intakeTalon.setNeutralMode(NeutralMode.Coast);
  }
  
  public void setRoller(double value){
    intakeTalon.set(ControlMode.PercentOutput,value);
  }
}
