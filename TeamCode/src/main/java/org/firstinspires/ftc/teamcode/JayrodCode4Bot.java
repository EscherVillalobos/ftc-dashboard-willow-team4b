package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp()
@Config
public class JayrodCode4Bot extends OpMode {
    public DcMotorEx arm = null;
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public Servo leftServo = null;
    public Servo rightServo = null;
    public static int Top = 100;
    public static int Down = 0;
 //fuck u lil bich

    @Override
    public void init() {

        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        arm= hardwareMap.get(DcMotorEx.class, "arm");
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void loop(){
        int position = arm.getCurrentPosition();
        telemetry.addData("Arm is at", position );
        if(gamepad1.dpad_up){
            arm.setTargetPosition(Top);
            arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            arm.setVelocity(300);
            telemetry.addData("Arm", "is up");
        }  if(gamepad1.dpad_down){
            arm.setTargetPosition(Down);
            arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            arm.setVelocity(300);
            telemetry.addData("Arm", "is down");
        }
    }
}