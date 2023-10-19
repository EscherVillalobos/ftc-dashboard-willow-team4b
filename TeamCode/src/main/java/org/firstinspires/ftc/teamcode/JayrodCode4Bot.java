package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp()
public class JayrodCode4Bot extends OpMode {
    public DcMotorEx arm = null;
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public Servo leftServo = null;
    public Servo rightServo = null;

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
    }
    public void loop(){
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        int position = arm.getCurrentPosition();
        telemetry.addData("Arm is at", position );
        if (gamepad1.dpad_up){
            //arm up code
            arm.setPower(0.2);
            telemetry.addData("Arm", "is up");
        } else if (gamepad1.dpad_down){
            //arm down code
            arm.setPower(-.2);
            telemetry.addData("Arm", "is down");
        } else {
            arm.setPower(0);
            arm.setTargetPosition(position);
            arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        }
        if(gamepad1.a){
            arm.setTargetPosition(200);
            arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            arm.setPower(0);

        }
    }
}