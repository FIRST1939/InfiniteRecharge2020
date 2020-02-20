/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frcteam1939.infiniterecharge2020.robot.subsystems;

import com.frcteam1939.infiniterecharge2020.robot.Robot;
import com.frcteam1939.infiniterecharge2020.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lights extends SubsystemBase {
  
  //private DigitalOutput lights1 = new DigitalOutput(RobotMap.ledStrip1);
  //private DigitalOutput lights2 = new DigitalOutput(RobotMap.ledStrip2);
  //private DigitalOutput lights3 = new DigitalOutput(RobotMap.ledStrip3);
  //private DigitalOutput lights4 = new DigitalOutput(RobotMap.ledStrip4);

  private int roborio_channel = 0;
  private final int NUM_ROBORIO_ONBOARD_DIGIO_PINS = 10;
  public final int MAX_NAVX_MXP_DIGIO_PIN_NUMBER = 9;

  private DigitalOutput lights1 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip1));
  private DigitalOutput lights2 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip2));
  private DigitalOutput lights3 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip3));
  private DigitalOutput lights4 = new DigitalOutput(getChannelFromPin(PinType.DigitalIO, RobotMap.ledStrip3));

  public enum PinType {DigitalIO, PWM, AnalogIn, AnalogOut};

  public int getChannelFromPin(PinType type, int io_pin_number) p{
    if ( io_pin_number < 0 ) {
      throw new IllegalArgumentException("Error:  navX MXP I/O Pin #");
    }
    if ( io_pin_number > MAX_NAVX_MXP_DIGIO_PIN_NUMBER ) {
      throw new IllegalArgumentException("Error:  Invalid navX MXP Digital I/O Pin #");
    }
    roborio_channel = io_pin_number + NUM_ROBORIO_ONBOARD_DIGIO_PINS + (io_pin_number > 3 ? 4 : 0);
    return roborio_channel;
  }

  public void powerUp(){
    lights1.set(true);
    lights2.set(true);
    lights3.set(true);
    lights4.set(false);
  }

  public void setGreen(){
    lights1.set(true);
    lights2.set(true);
    lights3.set(false);
    lights4.set(true);
  }

  public void greenFade(){
    lights1.set(true);
    lights2.set(false);
    lights3.set(true);
    lights4.set(true);
  }

  public void shooty(){
    lights1.set(false);
    lights2.set(true);
    lights3.set(true);
    lights4.set(true);
  }

  public void strobe(){
    lights1.set(false);
    lights2.set(false);
    lights3.set(true);
    lights4.set(true);
  }

  public void theaterChase(){
    lights1.set(true);
    lights2.set(true);
    lights3.set(false);
    lights4.set(false);
  }

  public void runningLights(){
    lights1.set(true);
    lights2.set(false);
    lights3.set(false);
    lights4.set(true);
  }

  @Override
  public void periodic() {

  }
}
