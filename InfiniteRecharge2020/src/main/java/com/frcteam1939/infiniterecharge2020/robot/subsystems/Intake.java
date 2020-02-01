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
  private Solenoid intakeSolenoid1 = new Solenoid(RobotMap.intakeSolenoid1);
  private Solenoid intakeSolenoid2 = new Solenoid(RobotMap.intakeSolenoid2);
  private TalonSRX intakeTalon = new TalonSRX(RobotMap.intakeRollersTalon);

  @Override
  public void initDefaultCommand() {
  }

  public void extendIntake(){
    intakeSolenoid1.set(true);
    intakeSolenoid2.set(true);
  }

  public void retractIntake(){
    intakeSolenoid1.set(false);
    intakeSolenoid2.set(false);
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
