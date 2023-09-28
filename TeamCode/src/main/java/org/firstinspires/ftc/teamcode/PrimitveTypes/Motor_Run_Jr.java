package org.firstinspires.ftc.teamcode.PrimitveTypes;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp
public class Motor_Run_Jr extends OpMode {
    int myVar = 0;
    private DcMotor motor1;
    private DcMotor testMotor2;
    private Servo servo1;
    private TouchSensor bump;
    private DistanceSensor distSense;
    @Override
    public void init(){`
         motor1= hardwareMap.get(DcMotor.class, "testMotor1");
        testMotor2 = hardwareMap.get(DcMotor.class,"testMotor2");
        servo1 = hardwareMap.get(Servo.class,"servo1");
        bump = hardwareMap.get(TouchSensor.class,"bump");
        distSense = hardwareMap.get(DistanceSensor.class,"distanceSensor");
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
    }
    @Override
    public void loop(){
        if (gamepad1.a) {
            motor1.setPower(1);
        }
        else
            motor1.setPower(0);
        telemetry.update();
    }
}
